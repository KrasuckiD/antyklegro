package com.service;

import com.domain.UserAccount;
import com.dto.UserDto;
import com.exeption.EmailNotFoundException;
import com.exeption.IncorrectPasswordOrEmailException;
import com.exeption.UserAlreadyExistException;

public interface UserAccountService {

    UserDto getUserByEmailAndPassword(UserDto userDto) throws IncorrectPasswordOrEmailException;

    UserAccount createUser(UserDto userDto) throws UserAlreadyExistException;

    UserAccount getUserByEmail(String email) throws EmailNotFoundException;


    //String email, String password, String accountName, String addressRegion, String addressCity, String addressStreet
}
