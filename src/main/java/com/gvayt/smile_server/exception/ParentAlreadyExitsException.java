package com.gvayt.smile_server.exception;

public class ParentAlreadyExitsException extends RuntimeException {
    public ParentAlreadyExitsException(String email) {
        super("Родитель с почтой " + email + " уже зарегистрирован");
    }
}
