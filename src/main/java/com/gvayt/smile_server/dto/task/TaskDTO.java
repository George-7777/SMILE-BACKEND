package com.gvayt.smile_server.dto.task;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TaskDTO {
    private long id;
    private String text;
    private LocalTime localTime;
}
