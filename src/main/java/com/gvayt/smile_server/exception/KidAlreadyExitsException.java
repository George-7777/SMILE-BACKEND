package com.gvayt.smile_server.exception;

public class KidAlreadyExitsException extends RuntimeException {
    public KidAlreadyExitsException(String login) {
        super("Ребенок с логином " + login + " уже зарегистрирован");
    }
}
