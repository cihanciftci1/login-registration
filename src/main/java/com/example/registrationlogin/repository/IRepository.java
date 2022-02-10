package com.example.registrationlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registrationlogin.entities.User;

public interface IRepository extends JpaRepository<User, Long> {

}
