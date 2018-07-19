package com.controller;

import com.dto.UserDto;
import com.exeption.EmailNotFoundException;
import com.exeption.IncorrectPasswordOrEmailException;
import com.exeption.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface UserAccountController {
    ResponseEntity<UserDto> addUserToDtb(UserDto userDto) throws UserAlreadyExistException;

    ResponseEntity<UserDto> loginUser(UserDto userDto) throws EmailNotFoundException, IncorrectPasswordOrEmailException, IOException;
}
