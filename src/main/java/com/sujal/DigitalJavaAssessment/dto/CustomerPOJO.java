package com.sujal.DigitalJavaAssessment.dto;


import com.sujal.DigitalJavaAssessment.model.Customer;

import java.util.List;

public class CustomerPOJO {

    private List<Customer> customerList;
    private Integer statusCode;
    private String message;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
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
