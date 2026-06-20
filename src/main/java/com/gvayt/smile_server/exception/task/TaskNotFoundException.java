package com.gvayt.smile_server.exception.task;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(long id) {
        super("Задание с id №" + id + " не найдено");
    }
}
