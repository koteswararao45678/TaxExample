/*
 * Creation : Jun 9, 2023
 */
package com.example.tax.TaxApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BadRequest.class)
    public ResponseEntity<CustomErrorResponse> badRequest(Exception e) {
        CustomErrorResponse error = new CustomErrorResponse(400, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
