package com.example.registrationlogin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.registrationlogin.entities.Role;
import com.example.registrationlogin.repository.IRoleRepository;

@Service
public class RoleService implements IRoleService{
	private IRoleRepository repository;
	
	
	public RoleService(IRoleRepository repository) {
		this.repository=repository;
	}


	@Override
	public void save(Role role) {
		repository.save(role);
	}


	@Override
	public List<Role> getAll() {
		return repository.findAll();
	}
	
	

}
