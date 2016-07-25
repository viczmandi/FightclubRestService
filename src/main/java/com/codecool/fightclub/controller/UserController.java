package com.codecool.fightclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codecool.fightclub.model.User;
import com.codecool.fightclub.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public void login(HttpSession session, LoginBean loginBean) {
	// String email = loginBean.getEmail();
	// String password = loginBean.getPassword();
	//
	// // ....
	//
	// session.setMaxInactiveInterval(60);
	// }
	//
	// @RequestMapping(value = "/logout", method = RequestMethod.POST)
	// public void logout(HttpSession session) {
	// if (session != null) {
	// session.invalidate();
	// }
	// }

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Fightclub Rest Service.";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		if (!userService.isUserExists(user)) {
			userService.insert(user);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public void modifyUser(User user) {
		// validate

		// after validation
		userService.modify(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public void deleteUser(User user) {
		// validate

		// after validation
		userService.delete(user.getId());
	}
}
