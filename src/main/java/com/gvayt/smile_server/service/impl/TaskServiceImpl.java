package com.gvayt.smile_server.service.impl;

import com.gvayt.smile_server.dto.task.TaskAddDTO;
import com.gvayt.smile_server.dto.task.TaskDTO;
import com.gvayt.smile_server.entity.Task;
import com.gvayt.smile_server.exception.kid.LoginNotFoundException;
import com.gvayt.smile_server.repository.KidRepository;
import com.gvayt.smile_server.repository.TaskRepository;
import com.gvayt.smile_server.service.TaskService;
import com.gvayt.smile_server.util.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private KidRepository kidRepository;

    @Override
    @PreAuthorize("@kidSecurity.canAccessChild(#login, authentication.principal)")
    public List<TaskDTO> getAllTasksByKid(String login) {
        return taskRepository.findByKidId(kidRepository.findByLogin(login).orElseThrow(
                () -> new LoginNotFoundException(login)
        ).getId()).stream().map(TaskMapper::convertToDto).toList();
    }

    @Override
    @PreAuthorize("@kidSecurity.canAccessChild(#login, authentication.principal)")
    public TaskDTO addTask(String login, TaskAddDTO taskDTO) {
        Task task = TaskMapper.convertToEntity(taskDTO);
        task.setKid(kidRepository.findByLogin(login).orElseThrow(
                () -> new LoginNotFoundException(login)
        ));

        return TaskMapper.convertToDto(taskRepository.save(task));
    }

    @Override
    @PreAuthorize("@kidSecurity.canAccessChild(#login, authentication.principal) && @taskSecurity.canAccessTask(#login, #task_id)")
    public void deleteTask(String login, long task_id) {
        taskRepository.deleteById(task_id);
    }
}
