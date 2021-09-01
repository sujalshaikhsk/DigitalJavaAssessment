package com.sujal.DigitalJavaAssessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @NotEmpty(message = "accountno is mandatory ")
    @Column(name = "account_no")
    private String accountno;

    @NotBlank(message = "bsb is mandatory ")
    @Column(name = "bsb")
    private String bsb;

    @NotBlank(message = "name is mandatory ")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "balance is mandatory ")
    @Column(name = "balance")
    private Double balance;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getBsb() {
        return bsb;
    }

    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountno='" + accountno + '\'' +
                ", bsb='" + bsb + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
