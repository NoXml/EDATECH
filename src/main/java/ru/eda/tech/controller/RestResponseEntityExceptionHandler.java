package ru.eda.tech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.eda.tech.controller.api.Response;

import java.util.Arrays;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Throwable.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException e, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        Response.failed()
                                .errorCode("TechnicalError", Arrays.toString(e.getStackTrace()))
                                .build()
                );
    }
}
