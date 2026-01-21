package com.example.School.exception.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationException{
    private int status;
    private List<FieldError> fieldErrors = new ArrayList<>();

    public ValidationException(int status, List<FieldError> fieldErrors){
        this.status = status;
        this.fieldErrors = fieldErrors;
    }

    // Getters

    public int getStatus( ){
        return status;
    }

    public List<FieldError> getFieldErrors( ){
        return fieldErrors;
    }
}
