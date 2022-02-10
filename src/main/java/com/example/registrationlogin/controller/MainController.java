package com.example.registrationlogin.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.registrationlogin.controller.dto.UserLoginDto;
import com.example.registrationlogin.entities.User;
import com.example.registrationlogin.service.IUserService;


@Controller
public class MainController {
	IUserService userService;
	
	
	public MainController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("userDto", new UserLoginDto());
		return "login";
		
	}
	
	@PostMapping("/mainpage")
	public String loginCheck(@ModelAttribute("userDto") UserLoginDto userDto, Model model) {
		for(User user:userService.getAll()) {
			if(user.getEmail().equals(userDto.getEmail())) {
				if (user.getPassword().equals(userDto.getPassword())) {
					model.addAttribute("user", user);
					return "mainpage";
				}else {
					return "redirect:/login?error";
				}
			}
		}
		return "redirect:/login?error";
		
		
	}
}
