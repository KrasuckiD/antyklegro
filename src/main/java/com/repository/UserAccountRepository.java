package com.repository;

import com.domain.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    boolean existsByEmail(String email);
    Optional <UserAccount> findByEmailAndPassword(String email, String password);
    Optional<UserAccount> findByEmail(String email);
}
