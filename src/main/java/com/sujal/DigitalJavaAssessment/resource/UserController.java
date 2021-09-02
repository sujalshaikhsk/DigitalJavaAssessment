package com.sujal.DigitalJavaAssessment.resource;

import com.sujal.DigitalJavaAssessment.model.User;
import com.sujal.DigitalJavaAssessment.model.UserPOJO;
import com.sujal.DigitalJavaAssessment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     *
     * @return
     */
    @GetMapping()
    public ResponseEntity<UserPOJO> getUsers(){
        logger.info("Starting getUsers method");
        //List<User> userList = Collections.emptyList();
        UserPOJO userPOJO = null;
        Optional<UserPOJO> userOptional = userService.getUsers();
        if(userOptional.isPresent())
            userPOJO= userOptional.get();

        return new ResponseEntity<>(userPOJO,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured")
    public ResponseEntity<UserPOJO> getUser(){
        logger.info("Starting getUsers method");
        //List<User> userList = Collections.emptyList();
        UserPOJO userPOJO = null;
        Optional<UserPOJO> userOptional = userService.getUsers();
        if(userOptional.isPresent())
            userPOJO= userOptional.get();

        return new ResponseEntity<>(userPOJO,HttpStatus.OK);
    }
}
