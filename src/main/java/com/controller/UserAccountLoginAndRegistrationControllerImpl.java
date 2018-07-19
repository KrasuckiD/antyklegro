package com.controller;

import com.dto.UserDto;
import com.exeption.EmailNotFoundException;
import com.exeption.IncorrectPasswordException;
import com.exeption.UserAlreadyExistException;
import com.service.UserAccountLoginAndRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UserAccountLoginAndRegistrationControllerImpl implements UserAccountLoginAndRegistrationController {

    @Autowired
    public UserAccountLoginAndRegistrationControllerImpl(UserAccountLoginAndRegistrationService service) {
        this.service = service;
    }

   private UserAccountLoginAndRegistrationService service;


    @Override
    @PostMapping("/register")
    public ResponseEntity<UserDto> addUserToDtb(@RequestBody UserDto userDto) throws UserAlreadyExistException {
        service.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/login")
    public ResponseEntity<UserDto> loginUser(UserDto userDto) throws EmailNotFoundException, IncorrectPasswordException, IOException {
        service.getUserByEmailAndPassword(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
