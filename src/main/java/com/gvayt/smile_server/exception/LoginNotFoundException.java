package com.gvayt.smile_server.exception;

public class LoginNotFoundException extends RuntimeException {
    public LoginNotFoundException(String login) {
        super("Ребенок с логином " + login + " не найден");
    }
}
