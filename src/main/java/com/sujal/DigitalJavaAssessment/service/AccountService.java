package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.AccountPOJO;
import com.sujal.DigitalJavaAssessment.dto.CustomerAccountPOJO;
import com.sujal.DigitalJavaAssessment.model.Account;

import java.util.Optional;

public interface AccountService {

    Optional<AccountPOJO> getAccount(String accountno);

    Optional<AccountPOJO> save(Account account);
}
