package com.pks.cricket_app.exception;

import com.pks.cricket_app.exception.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CricketAppCustomException.class)
    public ResponseEntity<ErrorResponse>  handleCricketAppCustomException(
            CricketAppCustomException exception){
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .errorCode(exception.getErrCode())
                .errorMessage(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse,
                HttpStatus.NOT_FOUND);

    }

}
