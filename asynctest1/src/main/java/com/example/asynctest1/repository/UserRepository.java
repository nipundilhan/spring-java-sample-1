package com.example.asynctest1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.asynctest1.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
