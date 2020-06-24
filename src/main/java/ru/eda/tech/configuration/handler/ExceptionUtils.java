package ru.eda.tech.configuration.handler;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public final class ExceptionUtils {

    private static final String ERROR_NAME_AND_MSG_DELIMETER = " : ";
    private static final String EMPTY_STRING = "";
    private static final String ERROR_AND_ERROR_DELIMETER = " , ";

    private ExceptionUtils() {
    }

    public static String stringFromAllErrorsOf(MethodArgumentNotValidException e) {
        final BiFunction<ObjectError, Supplier<String>, String> objectErrorToString =
                (objectError, nameSupplier) -> nameSupplier.get()
                        .concat(ERROR_NAME_AND_MSG_DELIMETER)
                        .concat(ofNullable(objectError.getDefaultMessage()).orElse(EMPTY_STRING));

        final Function<FieldError, String> fieldErrorToString =
                fieldError -> objectErrorToString.apply(fieldError, fieldError::getField);
        final Function<ObjectError, String> globalErrorToString =
                objectError -> objectErrorToString.apply(objectError, objectError::getObjectName);

        return Stream.concat(e.getBindingResult().getFieldErrors().stream().map(fieldErrorToString),
                e.getBindingResult().getGlobalErrors().stream().map(globalErrorToString))
                .collect(Collectors.joining(ERROR_AND_ERROR_DELIMETER));
    }

}
