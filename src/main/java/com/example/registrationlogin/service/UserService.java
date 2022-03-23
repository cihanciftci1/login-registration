package com.example.registrationlogin.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.registrationlogin.controller.dto.UserLoginDto;
import com.example.registrationlogin.entities.User;
import com.example.registrationlogin.repository.IRepository;

@Service
public class UserService implements IUserService{
	private IRepository repository;
	
	public UserService(IRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(User user) {
		repository.save(user);
	}

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User checkLogin(UserLoginDto userDto) {
		for(User user:getAll()) {
			if(user.getEmail().equals(userDto.getEmail())) {
				if (user.getPassword().equals(userDto.getPassword())) {
					return user;					
				}else {
					return null;
				}
			}
		}
		return null;
	}
	
	
	

}
