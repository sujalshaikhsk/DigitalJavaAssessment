package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.CustomerAccountPOJO;
import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<CustomerPOJO> getCustomers();

    Optional<CustomerPOJO> save(Customer customer);

    Optional<CustomerAccountPOJO> getAccountDetails(String customerid);
}
