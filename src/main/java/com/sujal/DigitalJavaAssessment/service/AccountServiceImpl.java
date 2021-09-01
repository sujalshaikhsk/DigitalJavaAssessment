package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.AccountPOJO;
import com.sujal.DigitalJavaAssessment.model.Account;
import com.sujal.DigitalJavaAssessment.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * @param accountno
     * @return Optional<AccountPOJO>
     */
    @Override
    public Optional<AccountPOJO> getAccount(String accountno) {
        Optional<Account> accountOptional = accountRepository.findById(accountno);
        if (accountOptional.isPresent()) {
            AccountPOJO accountPOJO = new AccountPOJO();
            accountPOJO.setAccount(accountOptional.get());
            return Optional.of(accountPOJO);
        } else
            return Optional.empty();
    }

    /**
     * @param account
     * @return Optional<AccountPOJO>
     */
    @Override
    public Optional<AccountPOJO> save(Account account) {
        Account account1 = accountRepository.save(account);
        if (Objects.isNull(account1)) {
            AccountPOJO accountPOJO = new AccountPOJO();
            accountPOJO.setAccount(account);
            return Optional.of(accountPOJO);
        }
        return Optional.empty();
    }
}
