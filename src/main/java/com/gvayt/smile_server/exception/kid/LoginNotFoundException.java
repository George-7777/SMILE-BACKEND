package com.gvayt.smile_server.exception.kid;

public class LoginNotFoundException extends RuntimeException {
    public LoginNotFoundException(String login) {
        super("Ребенок с логином " + login + " не найден");
    }
}
