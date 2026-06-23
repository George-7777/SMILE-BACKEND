package com.gvayt.smile_server.controller;

import com.gvayt.smile_server.dto.task.TaskAddDTO;
import com.gvayt.smile_server.dto.task.TaskDTO;
import com.gvayt.smile_server.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDTO> getAllMyTasks(Authentication authentication) {
        return taskService.getAllTasksByKid(authentication.getName());
    }

    @PostMapping
    public void addTask(Authentication authentication, TaskAddDTO taskDTO) {
        taskService.addTask(authentication.getName(), taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(Authentication authentication, @Param("id") long task_id) {
        taskService.deleteTask(authentication.getName(), task_id);
    }

    @GetMapping("/kids/{login}")
    public List<TaskDTO> getAllTasksMyKid(@Param("login") String kid_login) {
        return taskService.getAllTasksByKid(kid_login);
    }

    @PostMapping("/kids/{login}")
    public void addTaskMyKid(@Param("login") String kid_login, TaskAddDTO taskDTO) {
        taskService.addTask(kid_login, taskDTO);
    }

    @DeleteMapping("/kids/{login}/{id}")
    public void deleteTaskMyKid(@Param("login") String kid_login, @Param("id") long task_id) {
        taskService.deleteTask(kid_login, task_id);
    }
}
