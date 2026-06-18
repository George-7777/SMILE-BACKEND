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
    public ResponseEntity<?> addTask(Authentication authentication, TaskAddDTO taskDTO) {
        try {
            taskService.addTask(authentication.getName(), taskDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(Authentication authentication, @Param("id") long task_id) {
        try {
            taskService.deleteTask(authentication.getName(), task_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/kids/{login}")
    public ResponseEntity<?> getAllTasksMyKid(@Param("login") String kid_login) {
        return ResponseEntity.ok(taskService.getAllTasksByKid(kid_login));
    }

    @PostMapping("/kids/{login}")
    public ResponseEntity<?> addTaskMyKid(@Param("login") String kid_login, TaskAddDTO taskDTO) {
        try {
            taskService.addTask(kid_login, taskDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
