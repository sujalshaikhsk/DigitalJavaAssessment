package com.sujal.DigitalJavaAssessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @NotEmpty(message = "accountNumber is mandatory ")
    @Column(name = "account_number")
    private Long accountNumber;

    @NotBlank(message = "accountNumber is mandatory ")
    @Column(name = "account_type")
    private String accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
