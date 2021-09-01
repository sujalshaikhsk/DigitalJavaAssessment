package com.sujal.DigitalJavaAssessment.dto;


import com.sujal.DigitalJavaAssessment.model.Account;

import java.io.Serializable;
import java.util.Set;

public class CustomerAccountPOJO implements Serializable {

    private String customerid;
    private String title;
    private String firstname;
    private String lastname;
    private String gender;
    private Set<Account> accounts;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

}
