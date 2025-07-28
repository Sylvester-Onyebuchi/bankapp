package com.sylvester.bank.repository;

import com.sylvester.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByAccountNumber(String accountNumber);
    Optional<User> findByEmail(String email);
    User findByAccountNumber(String accountNumber);
}
