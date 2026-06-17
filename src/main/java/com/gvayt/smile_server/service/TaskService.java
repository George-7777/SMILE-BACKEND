package com.gvayt.smile_server.service;

import com.gvayt.smile_server.dto.TaskDTO;
import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasksByKid(String login);
    TaskDTO addTask(String login, TaskDTO taskDTO);
}
