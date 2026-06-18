package com.gvayt.smile_server.service;

import com.gvayt.smile_server.dto.task.TaskAddDTO;
import com.gvayt.smile_server.dto.task.TaskDTO;
import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasksByKid(String login);
    void addTask(String login, TaskAddDTO taskDTO);
    void deleteTask(String login, long task_id);
}
