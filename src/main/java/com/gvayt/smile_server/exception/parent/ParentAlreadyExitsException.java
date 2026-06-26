package com.gvayt.smile_server.exception.parent;

public class ParentAlreadyExitsException extends RuntimeException {
    public ParentAlreadyExitsException(String email) {
        super("Родитель с почтой " + email + " уже зарегистрирован");
    }
}
