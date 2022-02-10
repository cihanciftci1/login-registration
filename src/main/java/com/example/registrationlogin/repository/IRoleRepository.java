package com.example.registrationlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registrationlogin.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

}
