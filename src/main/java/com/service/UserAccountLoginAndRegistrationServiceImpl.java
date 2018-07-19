package com.service;

import com.AntyklegroApplication;
import com.domain.UserAccount;
import com.dto.UserDto;
import com.exeption.EmailNotFoundException;
import com.exeption.IncorrectPasswordException;
import com.exeption.UserAlreadyExistException;
import com.repository.UserAccountRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserAccountLoginAndRegistrationServiceImpl implements UserAccountLoginAndRegistrationService {

    @Autowired
    public UserAccountLoginAndRegistrationServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    private UserAccountRepository repository;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AntyklegroApplication.class);

    @Override
    public UserDto getUserByEmailAndPassword(UserDto userDto) throws IOException, IncorrectPasswordException, EmailNotFoundException {
        if (repository.existsByEmail(userDto.getEmail())) {
            Optional<UserAccount> user = repository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
            if (repository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword()).isPresent()) {
                UserDto returnedUser = getDtoUser(user);
                return returnedUser;
            } else {
                log.info("Password incorrect, try again.");
                throw new IncorrectPasswordException();
            }
        }
        log.info("Email not found.");
        throw new EmailNotFoundException();
    }

    @Override
    public UserAccount createUser(UserDto userDto) throws UserAlreadyExistException {
        if (repository.existsByEmail(userDto.getEmail())) {
            log.info("User with that email already exist");
            throw new UserAlreadyExistException();
        } else {
            UserAccount user = UserAccount.builder()
                    .email(userDto.getEmail())
                    .password(userDto.getPassword())
                    .accountName(userDto.getAccountName())
                    .addressRegion(userDto.getAddressRegion())
                    .addressCity(userDto.getAddressCity())
                    .addressStreet(userDto.getAddressStreet())
                    .accountCreateDate(LocalDate.now().toString())
                    .accountActivation(false)
                    .accountTypePremium(false)
                    .build();
            log.info("New user add to database");
            return repository.save(user);
        }
    }

    private UserDto getDtoUser(Optional<UserAccount> user) {
        UserDto userDto = UserDto.builder()
                .email(user.get().getEmail())
                .password(user.get().getPassword())
                .accountName(user.get().getAccountName())
                .addressRegion(user.get().getAddressRegion())
                .addressCity(user.get().getAddressCity())
                .addressStreet(user.get().getAddressStreet())
                .build();
        return userDto;
    }
}
