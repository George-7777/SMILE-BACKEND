package com.gvayt.smile_server.controller;

import com.gvayt.smile_server.dto.TaskDTO;
import com.gvayt.smile_server.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllMyTasks(Authentication authentication) {
        return ResponseEntity.ok(taskService.getAllTasksByKid(authentication.getName()));
    }

    @PostMapping
    public ResponseEntity<?> addTask(Authentication authentication, TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.addTask(authentication.getName(), taskDTO));
    }

    @GetMapping("/kids/{login}")
    public ResponseEntity<?> getAllTasksMyKid(@Param("login") String kid_login) {
        return ResponseEntity.ok(taskService.getAllTasksByKid(kid_login));
    }

    @PostMapping("/kids/{login}")
    public ResponseEntity<?> addTaskMyKid(@Param("login") String kid_login, TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.addTask(kid_login, taskDTO));
    }
}
