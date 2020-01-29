package ru.eda.tech.controller.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.eda.tech.controller.api.ResponseContent;

import java.util.Arrays;

@RestControllerAdvice
public class ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Throwable.class})
    ResponseEntity<ResponseContent<?>> handleConflict(RuntimeException e, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ResponseContent.failed()
                                .errorCode("TechnicalError", e.getLocalizedMessage())
                                .build()
                );
    }
}
