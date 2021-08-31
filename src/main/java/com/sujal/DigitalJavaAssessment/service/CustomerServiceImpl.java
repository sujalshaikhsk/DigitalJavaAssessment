package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.model.Customer;
import com.sujal.DigitalJavaAssessment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * @return Optional<CustomerPOJO>
     */
    @Override
    public Optional<CustomerPOJO> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty())
            return Optional.empty();
        else {
            CustomerPOJO customerPOJO = new CustomerPOJO();
            customerPOJO.setCustomerList(customers);
            return Optional.of(customerPOJO);
        }
    }

    @Override
    public Optional<CustomerPOJO> save(Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        if (customer1 != null) {
            CustomerPOJO customerPOJO = new CustomerPOJO();
            customerPOJO.setCustomerList(Arrays.asList(customer1));
            return Optional.of(customerPOJO);
        }
        return Optional.empty();
    }
}
