package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.model.User;
import com.sujal.DigitalJavaAssessment.model.UserPOJO;

import java.util.Optional;

public interface UserService {

    Optional<UserPOJO> getUsers();

    void saveUser(User user);
}
