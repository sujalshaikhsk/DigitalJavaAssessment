package com.sujal.DigitalJavaAssessment.resource;

import com.sujal.DigitalJavaAssessment.dto.CustomerPOJO;
import com.sujal.DigitalJavaAssessment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("customers")
    public ResponseEntity<CustomerPOJO> getCustomers(){
        Optional<CustomerPOJO> customerDTOOptional= customerService.getCustomers();

        if(customerDTOOptional.isPresent()){
            CustomerPOJO customerPOJO= customerDTOOptional.get();
            customerPOJO.setStatusCode(200);
            customerPOJO.setMessage("SUCCESS");
            return new ResponseEntity<>(customerPOJO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
