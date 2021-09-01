package com.sujal.DigitalJavaAssessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    @NotEmpty(message = "customerId is mandatory")
    private String customerid;

    @Column(name = "title")
    @NotBlank(message = "title is mandatory")
    private String title;

    @Column(name = "first_name")
    @NotBlank(message = "firstname is mandatory")
    private String firstname;

    @Column(name = "last_name")
    @NotBlank(message = "lastname is mandatory")
    private String lastname;

    @Column(name = "gender")
    @NotBlank(message = "gender is mandatory")
    private String gender;

    @JsonIgnore
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerid='" + customerid + '\'' +
                ", title='" + title + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
