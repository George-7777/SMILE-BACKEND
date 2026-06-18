package com.gvayt.smile_server.dto.task;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TaskAddDTO {
    private String text;
    private LocalTime localTime;
}
