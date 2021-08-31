package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.dto.AccountPOJO;

import java.util.Optional;

public interface AccountService {

    Optional<AccountPOJO> getAccount(Long accountNumber);
}
