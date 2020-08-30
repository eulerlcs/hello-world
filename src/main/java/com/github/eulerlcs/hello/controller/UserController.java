package com.github.eulerlcs.hello.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.eulerlcs.hello.domain.User;
import com.github.eulerlcs.hello.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@RequestMapping({ "/", "/user/search" })
	public String search(@ModelAttribute("user") User user) {
		return "/user/detail";
	}

	@RequestMapping("/user/detail")
	public String detail(@ModelAttribute("user") User user) {
		User selectedUser = userService.selectUser(user.getId());
		if (selectedUser == null) {
			return "redirect:/user/search";
		} else {
			BeanUtils.copyProperties(selectedUser, user);
			return "/user/detail";
		}
	}
}
