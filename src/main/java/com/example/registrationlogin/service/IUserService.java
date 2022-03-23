package com.example.registrationlogin.service;

import java.util.List;

import com.example.registrationlogin.controller.dto.UserLoginDto;
import com.example.registrationlogin.entities.User;

public interface IUserService {
	void save(User user);
	List<User> getAll();
	User checkLogin(UserLoginDto userDto);
}
