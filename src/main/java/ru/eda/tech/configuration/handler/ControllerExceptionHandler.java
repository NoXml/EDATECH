package ru.eda.tech.configuration.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.eda.tech.controller.api.ResponseContent;

import javax.validation.ConstraintViolationException;

import static java.lang.String.valueOf;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static ru.eda.tech.configuration.handler.ExceptionUtils.stringFromAllErrorsOf;
import static ru.eda.tech.controller.api.Error.of;
import static ru.eda.tech.controller.api.ResponseContent.failed;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = {RuntimeException.class})
    ResponseEntity<ResponseContent<?>> handleBaseExceptions(RuntimeException e) {
        log.error("Can't finished request", e);
        return responseEntityWith(INTERNAL_SERVER_ERROR, "Request was failed with exception");
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    ResponseEntity<ResponseContent<?>> handleValidationExceptions(MethodArgumentNotValidException e) {
        log.error("Can't finished request", e);
        return responseEntityWith(BAD_REQUEST, stringFromAllErrorsOf(e));
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    ResponseEntity<ResponseContent<?>> handleValidationExceptions(ConstraintViolationException e) {
        log.error("Can't finished request", e);
        return responseEntityWith(BAD_REQUEST, e.getLocalizedMessage());
    }

    private ResponseEntity<ResponseContent<?>> responseEntityWith(HttpStatus httpStatus, String errorMessage) {
        return ResponseEntity
                .status(httpStatus)
                .body(failed(of(valueOf(httpStatus.value()), errorMessage)));
    }

}
