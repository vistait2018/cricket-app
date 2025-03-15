package com.pks.cricket_app.exception;

import lombok.Data;

@Data
public class CricketAppCustomException extends RuntimeException{
    private String errCode;

    public CricketAppCustomException(String message, String errCode) {
        super(message);
        this.errCode = errCode;
    }
}
