package com.test.inditex.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class PricesErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<ErrorResponse> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {

        return ex.getBindingResult().getFieldErrors().stream()
                .map(this::getErrorResponse)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(AssertionError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleAssertionError(final AssertionError ex) {
        return ErrorResponse.builder()
                .message(ex.getLocalizedMessage())
                .build();
    }

    private ErrorResponse getErrorResponse(final FieldError fieldError) {
        return ErrorResponse.builder()
                .fieldName(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }
}
