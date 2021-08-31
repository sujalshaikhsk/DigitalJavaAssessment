package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.AccountPOJO;
import com.sujal.DigitalJavaAssessment.model.Account;
import com.sujal.DigitalJavaAssessment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<AccountPOJO> getAccount(Long accountNumber) {
        Optional<Account> accountOptional = accountRepository.findById(accountNumber);
        if (accountOptional.isPresent()) {
            AccountPOJO accountPOJO = new AccountPOJO();
            accountPOJO.setAccount(accountOptional.get());
            return Optional.of(accountPOJO);
        } else
            return Optional.empty();
    }
}
