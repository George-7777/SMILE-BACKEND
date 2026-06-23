package com.gvayt.smile_server.dto.kid;

import com.gvayt.smile_server.dto.task.TaskDTO;
import lombok.Data;

import java.util.List;

@Data
public class KidDTO {
    private long id;
    private String fio;
    private String login;
    private long parent_id;
    private List<TaskDTO> tasks;
}
