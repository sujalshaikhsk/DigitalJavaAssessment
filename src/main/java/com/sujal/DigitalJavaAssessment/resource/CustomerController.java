package com.sujal.DigitalJavaAssessment.resource;

import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.model.Customer;
import com.sujal.DigitalJavaAssessment.service.CustomerService;
import com.sujal.DigitalJavaAssessment.util.ApiConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    /**
     * @return CustomerPOJO
     */
    @GetMapping
    public ResponseEntity<CustomerPOJO> getCustomers() {
        Optional<CustomerPOJO> customerDTOOptional = customerService.getCustomers();

        if (customerDTOOptional.isPresent()) {
            CustomerPOJO customerPOJO = customerDTOOptional.get();
            logger.info("size of the list" + customerPOJO.getCustomerList().size());
            customerPOJO.setStatusCode(200);
            customerPOJO.setMessage(ApiConstant.SUCCESS);
            return new ResponseEntity<>(customerPOJO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * @param customer
     * @return CustomerPOJO
     */
    @PostMapping
    public ResponseEntity<CustomerPOJO> save(@Valid @RequestBody Customer customer) {
        Optional<CustomerPOJO> customerDTOOptional = customerService.save(customer);
        if (customerDTOOptional.isPresent()) {
            CustomerPOJO customerPOJO = customerDTOOptional.get();
            customerPOJO.setStatusCode(200);
            customerPOJO.setMessage(ApiConstant.SUCCESS);
            return new ResponseEntity<>(customerPOJO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
