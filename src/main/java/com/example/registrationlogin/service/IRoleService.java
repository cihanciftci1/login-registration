package com.example.registrationlogin.service;


import java.util.List;

import com.example.registrationlogin.entities.Role;

public interface IRoleService {
	void save(Role role);
	List<Role> getAll();
}
