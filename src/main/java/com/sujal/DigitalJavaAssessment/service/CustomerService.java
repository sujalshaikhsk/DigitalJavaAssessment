package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;

import java.util.Optional;

public interface CustomerService {

    Optional<CustomerPOJO> getCustomers();
}
