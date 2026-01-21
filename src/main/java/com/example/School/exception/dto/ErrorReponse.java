package com.example.School.exception.dto;

import java.time.LocalDate;

public class ErrorReponse{
    private LocalDate localDate = LocalDate.now();
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ErrorReponse(int status, String error, String message, String path){
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters

    public LocalDate getLocalDate( ){
        return localDate;
    }

    public int getStatus( ){
        return status;
    }

    public String getError( ){
        return error;
    }

    public String getMessage( ){
        return message;
    }

    public String getPath( ){
        return path;
    }
}
