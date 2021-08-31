package com.sujal.DigitalJavaAssessment.resource;

import com.sujal.DigitalJavaAssessment.dto.AccountPOJO;
import com.sujal.DigitalJavaAssessment.service.AccountService;
import com.sujal.DigitalJavaAssessment.util.ApiConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/{account_number}")
    public ResponseEntity<AccountPOJO> getAccount(@PathVariable("account_number") @NotBlank @Size(max = 10) Long accountNumber) {
        Optional<AccountPOJO> accountPOJOOptional = accountService.getAccount(accountNumber);
        if (accountPOJOOptional.isPresent()) {
            AccountPOJO accountPOJO = accountPOJOOptional.get();
            logger.info("Customer number "+accountPOJO.getAccount().getCustomer().getCustomerId());
            accountPOJO.setStatusCode(200);
            accountPOJO.setMessage(ApiConstant.SUCCESS);
            return new ResponseEntity<>(accountPOJO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
