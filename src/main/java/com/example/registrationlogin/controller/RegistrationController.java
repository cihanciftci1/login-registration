package com.example.registrationlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.registrationlogin.entities.User;
import com.example.registrationlogin.service.IRoleService;
import com.example.registrationlogin.service.IUserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	private IUserService service;
	private IRoleService roleService;

	public RegistrationController(IUserService service, IRoleService roleService) {
		this.service = service;
		this.roleService=roleService;
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listRoles", roleService.getAll());
		return "registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") User user) {
		user.setFirstName(user.getFirstName().substring(0, 1).toUpperCase()
				+user.getFirstName().substring(1).toLowerCase());
		user.setLastName(user.getLastName().toUpperCase());
		
		try{
			service.save(user);
		}
		catch (Exception e) {
			return "redirect:/registration?error";
		}
		return "redirect:/registration?success";
	}
	
}
