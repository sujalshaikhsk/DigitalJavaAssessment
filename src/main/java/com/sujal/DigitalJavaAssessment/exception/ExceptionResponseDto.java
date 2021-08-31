package com.sujal.DigitalJavaAssessment.exception;

import java.io.Serializable;

public class ExceptionResponseDto implements Serializable {

    String message;
    String defaultMessage;

    public ExceptionResponseDto(String message, String defaultMessage) {
        this.message=message;
        this.defaultMessage= defaultMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
