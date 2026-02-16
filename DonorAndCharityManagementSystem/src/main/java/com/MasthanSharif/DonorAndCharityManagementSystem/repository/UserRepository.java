package com.MasthanSharif.DonorAndCharityManagementSystem.repository;

import com.MasthanSharif.DonorAndCharityManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserName(String userName);
}
