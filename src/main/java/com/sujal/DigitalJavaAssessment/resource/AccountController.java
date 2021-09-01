package com.sujal.DigitalJavaAssessment.resource;

import com.sujal.DigitalJavaAssessment.dto.AccountPOJO;
import com.sujal.DigitalJavaAssessment.model.Account;
import com.sujal.DigitalJavaAssessment.service.AccountService;
import com.sujal.DigitalJavaAssessment.util.ApiConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountno}")
    public ResponseEntity<AccountPOJO> getAccount(@PathVariable("accountno") @NotBlank @Size(max = 10) String accountno) {
        Optional<AccountPOJO> accountPOJOOptional = accountService.getAccount(accountno);
        if (accountPOJOOptional.isPresent()) {
            AccountPOJO accountPOJO = accountPOJOOptional.get();
            logger.info("Customer number " + accountPOJO.getAccount().getCustomer().getCustomerid());
            accountPOJO.setStatusCode(200);
            accountPOJO.setMessage(ApiConstant.SUCCESS);
            return new ResponseEntity<>(accountPOJO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * @param account
     * @return AccountPOJO
     */
    @PostMapping
    public ResponseEntity<AccountPOJO> save(@Valid @RequestBody Account account) {
        Optional<AccountPOJO> accountPOJOOptional = accountService.save(account);
        if (accountPOJOOptional.isPresent()) {
            AccountPOJO accountPOJO = accountPOJOOptional.get();
            logger.info("Customer number " + accountPOJO.getAccount().getCustomer().getCustomerid());
            accountPOJO.setStatusCode(200);
            accountPOJO.setMessage(ApiConstant.SUCCESS);
            return new ResponseEntity<>(accountPOJO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
