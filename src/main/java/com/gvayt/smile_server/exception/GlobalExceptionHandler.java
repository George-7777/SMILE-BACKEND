package com.gvayt.smile_server.exception;

import com.gvayt.smile_server.exception.kid.KidAlreadyExitsException;
import com.gvayt.smile_server.exception.kid.LoginNotFoundException;
import com.gvayt.smile_server.exception.parent.EmailNotFoundException;
import com.gvayt.smile_server.exception.parent.ParentAlreadyExitsException;
import com.gvayt.smile_server.exception.task.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(KidAlreadyExitsException.class)
    public ResponseEntity<AppError> catchKidAlreadyExitsException(KidAlreadyExitsException e) {
        log.error(e.getMessage(), e);
        AppError body = new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(LoginNotFoundException.class)
    public ResponseEntity<AppError> catchLoginNotFoundException(LoginNotFoundException e) {
        log.error(e.getMessage(), e);
        AppError body = new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<AppError> catchEmailNotFoundException(EmailNotFoundException e) {
        log.error(e.getMessage(), e);
        AppError body = new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(ParentAlreadyExitsException.class)
    public ResponseEntity<AppError> catchParentAlreadyExitsException(ParentAlreadyExitsException e) {
        log.error(e.getMessage(), e);
        AppError body = new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<AppError> catchTaskNotFoundException(TaskNotFoundException e) {
        log.error(e.getMessage(), e);
        AppError body = new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    public record AppError(
            int statusCode,
            String message
    ) {}
}
