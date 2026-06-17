package com.gvayt.smile_server.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TaskDTO {
    private String text;
    private LocalTime localTime;
}
