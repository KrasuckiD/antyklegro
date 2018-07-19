package com.controller;

import com.dto.UserDto;
import com.exeption.IncorrectPasswordOrEmailException;
import com.exeption.UserAlreadyExistException;
import com.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;


@RestController
public class UserAccountControllerImpl implements UserAccountController {

    @Autowired
    public UserAccountControllerImpl(UserAccountService service) {
        this.service = service;
    }

   private UserAccountService service;


    @Override
    @PostMapping("/register")
    public ResponseEntity<UserDto> addUserToDtb(@RequestBody UserDto userDto) throws UserAlreadyExistException {
        service.createUser(userDto);
        return new ResponseEntity<>(OK);
    }

    @Override
    @GetMapping("/login")
    public ResponseEntity<UserDto> loginUser(UserDto userDto) throws IncorrectPasswordOrEmailException {
        service.getUserByEmailAndPassword(userDto);
        return new ResponseEntity<>(OK);
    }
}
