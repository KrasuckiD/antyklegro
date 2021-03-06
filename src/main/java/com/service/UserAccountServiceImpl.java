package com.service;

import com.AntyklegroApplication;
import com.domain.UserAccount;
import com.dto.UserDto;
import com.exeption.EmailNotFoundException;
import com.exeption.IncorrectPasswordOrEmailException;
import com.exeption.UserAlreadyExistException;
import com.repository.UserAccountRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    private UserAccountRepository repository;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AntyklegroApplication.class);

    @Override
    public UserDto getUserByEmailAndPassword(UserDto userDto) throws IncorrectPasswordOrEmailException {
        if (repository.existsByEmail(userDto.getEmail())) {
            Optional<UserAccount> user = repository.findByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
            if (user.isPresent()) {
                return getDtoUser(user.get());

            } else {
                log.info("Password or email incorrect, try again.");
                throw new IncorrectPasswordOrEmailException();
            }
        }
        log.info("Email not found.");
        throw new IncorrectPasswordOrEmailException();
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

    @Override
    public UserAccount getUserByEmail(String email) throws EmailNotFoundException {
        Optional<UserAccount> user = repository.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        } else {
            log.info("Email not found");
            throw new EmailNotFoundException();
        }
    }

    private UserDto getDtoUser(UserAccount user) {
             return UserDto.builder()
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .accountName(user.getAccountName())
                    .addressRegion(user.getAddressRegion())
                    .addressCity(user.getAddressCity())
                    .addressStreet(user.getAddressStreet())
                    .build();
        }
    }

