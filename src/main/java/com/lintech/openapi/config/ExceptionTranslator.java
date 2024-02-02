package com.lintech.openapi.config;


import com.lintech.openapi.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.lintech.openapi.dto.Error;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Error> handleOrderNotFoundException(ProductNotFoundException e){
        return ResponseEntity.ok(generateError(e.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    public Error generateError(String message, Integer code){
        Error error = new Error();
        error.setCode(code);
        error.setMessage(message);
        return error;
    }
}
