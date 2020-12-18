package com.mitchmele.optionslounge.option.controller;

import com.mitchmele.optionslounge.option.exception.InvalidOptionTypeException;
import com.mitchmele.optionslounge.option.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdvice {


    @ExceptionHandler(InvalidOptionTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadType(Throwable t) {
        return processError(t);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ErrorResponse handleAllExceptions(Exception e) {
        return processError(e);
    }

    public ErrorResponse processError(Throwable t) {
        return ErrorResponse.builder()
                .message(t.getLocalizedMessage())
                .exception(t.getClass().toString())
                .build();
    }
}
