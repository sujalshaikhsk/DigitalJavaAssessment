package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.CustomerAccountPOJO;
import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.model.Customer;
import com.sujal.DigitalJavaAssessment.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

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

    /**
     * @param customer
     * @return Optional<CustomerPOJO>
     */
    @Override
    public Optional<CustomerPOJO> save(Customer customer) {
        Customer customer1 = customerRepository.save(customer);
        if (Objects.isNull(customer1)) {
            CustomerPOJO customerPOJO = new CustomerPOJO();
            customerPOJO.setCustomerList(Arrays.asList(customer1));
            return Optional.of(customerPOJO);
        }
        return Optional.empty();
    }

    /**
     * @param customerid
     * @return Optional<CustomerAccountPOJO>
     */
    @Override
    public Optional<CustomerAccountPOJO> getAccountDetails(String customerid) {
        Optional<Customer> customerOptional = customerRepository.findById(customerid);
        logger.info(customerOptional.toString());
        if (customerOptional.isPresent()) {
            CustomerAccountPOJO customerAccountPOJO = new CustomerAccountPOJO();
            BeanUtils.copyProperties(customerOptional.get(), customerAccountPOJO);
            logger.info(customerAccountPOJO.toString());
            return Optional.of(customerAccountPOJO);
        }
        return Optional.empty();
    }
}
