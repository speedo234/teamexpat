package com.teamexpat.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorDetails> handleInvalidInputException(InvalidInputException exception, HttpServletResponse response, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpServletResponse.SC_NOT_ACCEPTABLE, HttpStatus.NOT_ACCEPTABLE.toString(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorDetails);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorDetails> handleApplicationException(ApplicationException exception, HttpServletResponse response, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpServletResponse.SC_NOT_ACCEPTABLE, HttpStatus.NOT_ACCEPTABLE.toString(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorDetails);
    }


}
