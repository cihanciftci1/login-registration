package com.example.registrationlogin.service;

import java.util.List;

import com.example.registrationlogin.entities.User;

public interface IUserService {
	void save(User user);
	List<User> getAll();
}
