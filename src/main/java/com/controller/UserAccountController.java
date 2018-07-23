package com.controller;

import com.domain.UserAccount;
import com.dto.UserDto;
import com.exeption.IncorrectPasswordOrEmailException;
import com.exeption.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface UserAccountController {
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    ResponseEntity<UserAccount> addUserToDtb
            (@RequestBody UserDto userDto) throws UserAlreadyExistException;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    ResponseEntity<UserDto> loginUser
            (@RequestBody UserDto userDto)
            throws IncorrectPasswordOrEmailException;
}