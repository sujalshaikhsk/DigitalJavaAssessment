package com.sujal.DigitalJavaAssessment.dto;

import com.sujal.DigitalJavaAssessment.model.Account;

import java.io.Serializable;

public class AccountPOJO implements Serializable {

    private Account account;
    private Integer statusCode;
    private String message;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
