package com.example.School.exception.handler;

import com.example.School.exception.consum.BadRequestException;
import com.example.School.exception.consum.ResourseNotFoundException;
import com.example.School.exception.dto.ErrorReponse;
import com.example.School.exception.dto.FieldError;
import com.example.School.exception.dto.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler( ResourseNotFoundException.class)
    public ResponseEntity<ErrorReponse> notFound (ResourseNotFoundException ex,
                                                   HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorReponse(
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.name(),
                        ex.getMessage(),
                        request.getRequestURI()
                )
        );
    }

    @ExceptionHandler( BadRequestException.class)
    public ResponseEntity<ErrorReponse> badRequest (BadRequestException ex,
                                                    HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorReponse(
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.name(),
                        ex.getMessage(),
                        request.getRequestURI()

                )
        );
    }

    @ExceptionHandler( MethodArgumentNotValidException.class )
    public ResponseEntity<ValidationException> validation (MethodArgumentNotValidException ex,
                                                           HttpServletRequest request){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors()
                .stream().map(
                        fieldError -> new FieldError(ex.getMessage(), request.getRequestURI())
                ).toList();
        ValidationException validationException = new ValidationException(HttpStatus.BAD_REQUEST.value(), fieldErrors);
        return ResponseEntity.badRequest().body(validationException);
    }

}
