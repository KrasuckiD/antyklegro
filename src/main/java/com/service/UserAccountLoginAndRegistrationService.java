package com.service;

import com.domain.UserAccount;
import com.dto.UserDto;
import com.exeption.EmailNotFoundException;
import com.exeption.IncorrectPasswordException;
import com.exeption.UserAlreadyExistException;

import java.io.IOException;

public interface UserAccountLoginAndRegistrationService {

    UserDto getUserByEmailAndPassword(UserDto userDto) throws IOException, IncorrectPasswordException, EmailNotFoundException;

    UserAccount createUser(UserDto userDto) throws UserAlreadyExistException;


    //String email, String password, String accountName, String addressRegion, String addressCity, String addressStreet
}
