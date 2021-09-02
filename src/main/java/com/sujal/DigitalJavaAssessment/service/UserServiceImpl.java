package com.sujal.DigitalJavaAssessment.service;

import com.sujal.DigitalJavaAssessment.model.User;
import com.sujal.DigitalJavaAssessment.model.UserPOJO;
import com.sujal.DigitalJavaAssessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserPOJO> getUsers() {
        UserPOJO userPOJO=new UserPOJO();

        List<User> userList = userRepository.findAll();
        userPOJO.setUserList(userList);

        return Optional.of(userPOJO);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
