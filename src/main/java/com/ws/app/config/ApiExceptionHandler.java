package com.ws.app.config;


import com.ws.app.config.model.ErrorModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(org.springframework.validation.BindException.class)
    public ResponseEntity<Object> handleBindException(org.springframework.validation.BindException ex) {


        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x ->  x.getField() + " " + x.getDefaultMessage())
                .collect(Collectors.toList());


        ErrorModel errorModel = new ErrorModel(HttpStatus.BAD_REQUEST,errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorModel);

    }

    @ExceptionHandler(value = ResponseStatusException.class)
    protected ResponseEntity<Object> responseStatusException(ResponseStatusException ex ) {
        log.error("ApiExceptionHandler ::> ResponseStatusException ::> Error: " + ex.getMessage(), ex);
        ErrorModel errorModel = new ErrorModel(ex.getStatus(), ex.getReason());
        return ResponseEntity.status(ex.getStatus()).body(errorModel);
    }

}
