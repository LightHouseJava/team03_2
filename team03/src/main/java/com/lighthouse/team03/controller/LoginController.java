package com.lighthouse.team03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lighthouse.team03.entity.User;
import com.lighthouse.team03.mapper.UserMapper;

@Controller
public class LoginController {
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("loginUser", new User());
		return "login";
	}
	
	@PostMapping("/")
	public String loginSubmisstion(@ModelAttribute("loginUser") User loginUser) {
		
		if(userMapper.checkUserExists(loginUser.getUserName())) {
			User tmpUser = userMapper.findByUserName(loginUser.getUserName());
			if(tmpUser.getPassword().equals(loginUser.getPassword())) 
				return "mypage";
			else
				return "failed_page";
		}else
			return "failed_page";
		
	}
		
}
