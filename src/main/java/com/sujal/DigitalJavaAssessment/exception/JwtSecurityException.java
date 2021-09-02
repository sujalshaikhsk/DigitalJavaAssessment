package com.sujal.DigitalJavaAssessment.exception;

public class JwtSecurityException extends RuntimeException{
    public JwtSecurityException(String errorMessage){
        super(errorMessage);
    }
}
