package com.blog.blogspring.repository;

import com.blog.blogspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<Model, Id>
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmationCode(String confirmationCode);
}