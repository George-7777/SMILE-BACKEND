package com.gvayt.smile_server.security;

import com.gvayt.smile_server.entity.Task;
import com.gvayt.smile_server.exception.TaskNotFoundException;
import com.gvayt.smile_server.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("taskSecurity")
@RequiredArgsConstructor
public class TaskSecurityService {
    private final TaskRepository taskRepository;

    public boolean canAccessTask(String kid_login, long task_id) {
        Task task = taskRepository.findById(task_id).orElseThrow(
                () -> new TaskNotFoundException(task_id)
        );
        return task.getKid().getLogin().equals(kid_login);
    }
}
