package com.test.inditex.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    String fieldName;
    String message;

    public ErrorResponse(final String fieldName, final String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
