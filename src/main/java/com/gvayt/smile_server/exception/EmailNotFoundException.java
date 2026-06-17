package com.gvayt.smile_server.exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String email) {
        super("Родитель с почтой " + email + " не зарегистрирован");
    }
}
