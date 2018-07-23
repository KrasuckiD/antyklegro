package com.controller;

import com.domain.UserAccount;
import com.dto.UserDto;
import com.exeption.IncorrectPasswordOrEmailException;
import com.exeption.UserAlreadyExistException;
import com.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



@RestController
public class UserAccountControllerImpl implements UserAccountController {

    @Autowired
    public UserAccountControllerImpl(UserAccountService service) {
        this.service = service;
    }

   private UserAccountService service;


    @Override
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserAccount> addUserToDtb
            (@RequestBody UserDto userDto) throws UserAlreadyExistException {
        return Optional.ofNullable(service.createUser(userDto))
                .map(ResponseEntity::ok)
                .orElseThrow(UserAlreadyExistException::new);
    }

    @Override
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<UserDto> loginUser
            (@RequestBody UserDto userDto)
            throws IncorrectPasswordOrEmailException {
        return Optional.ofNullable(service.getUserByEmailAndPassword(userDto))
                .map(ResponseEntity::ok)
                .orElseThrow(IncorrectPasswordOrEmailException::new);
    }
}
