package com.controller;

import com.domain.UserAccount;
import com.dto.UserDto;
import com.exeption.EmailNotFoundException;
import com.exeption.IncorrectPasswordException;
import com.exeption.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface UserAccountLoginAndRegistrationController {
    ResponseEntity<UserDto> addUserToDtb(UserDto userDto) throws UserAlreadyExistException;

    ResponseEntity<UserDto> loginUser(UserDto userDto) throws EmailNotFoundException, IncorrectPasswordException, IOException;
}
