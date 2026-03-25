package com.example.sportsbooking.repository;

import com.example.sportsbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}