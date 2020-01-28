package ru.eda.tech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.eda.tech.controller.api.ResponseBody;

import java.util.Arrays;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Throwable.class})
    ResponseEntity<ResponseBody<?>> handleConflict(RuntimeException e, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ResponseBody.failed()
                                .errorCode("TechnicalError", Arrays.toString(e.getStackTrace()))
                                .build()
                );
    }
}
