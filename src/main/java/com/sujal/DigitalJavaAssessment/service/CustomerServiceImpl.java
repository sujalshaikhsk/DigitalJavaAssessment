package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.model.Customer;
import com.sujal.DigitalJavaAssessment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<CustomerPOJO> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        if(customerList.isEmpty())
            return Optional.empty();
        else {
            CustomerPOJO customerPOJO = new CustomerPOJO();
            customerPOJO.setCustomerList(customerList);
            return Optional.of(customerPOJO);
        }
    }
}
