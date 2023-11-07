package com.ws.app.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static com.ws.app.util.Constants.Message.ERROR_DATE;
import static com.ws.app.util.Constants.Message.ERROR_TIME;

public  class Util {
    private Util() {
    }

    public static LocalDate getDate(String date){
        try {
            String format = "";
            if(date.matches("^\\d{2}-(0\\d|1[0-2])-\\d{4}$"))
                format = "dd-MM-yyyy";
            else if(date.matches("^\\d{4}-(0\\d|1[0-2])-\\d{2}"))
                format = "yyyy-MM-dd";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDate.parse(date, formatter);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT,ERROR_DATE);
        }
    }

    public static LocalTime getTime(String hour){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(hour, formatter);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT,ERROR_TIME);
        }

    }



}
