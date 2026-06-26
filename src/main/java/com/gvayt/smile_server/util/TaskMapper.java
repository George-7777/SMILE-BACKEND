package com.gvayt.smile_server.util;

import com.gvayt.smile_server.dto.task.TaskAddDTO;
import com.gvayt.smile_server.dto.task.TaskDTO;
import com.gvayt.smile_server.entity.Task;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TaskMapper {
    public TaskDTO convertToDto(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setLocalTime(task.getLocalTime());
        taskDTO.setText(task.getText());

        return taskDTO;
    }

    public Task convertToEntity(TaskAddDTO taskDTO) {
        Task task = new Task();
        task.setText(taskDTO.getText());
        task.setLocalTime(taskDTO.getLocalTime());

        return task;
    }
}
