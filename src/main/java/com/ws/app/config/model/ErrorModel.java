package com.ws.app.config.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Data
public class ErrorModel {

    private String timestamp = new Date().toString();
    private String status;
    private String error;
    private Object message;


    public ErrorModel(HttpStatus httpStatus, Object message) {

        if (null != httpStatus) {
            this.status = String.valueOf(httpStatus.value());
            this.error = httpStatus.toString();
        }
        this.message = message;

    }


}
