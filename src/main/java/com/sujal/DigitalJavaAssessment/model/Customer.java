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
    private String customerId;

    @Column(name = "first_name")
    @NotBlank(message = "firstName is mandatory")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "lastName is mandatory")
    private String lastName;

    @Column(name = "gender")
    @NotBlank(message = "gender is mandatory")
    private String gender;

    @JsonIgnore
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Account> accounts;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
