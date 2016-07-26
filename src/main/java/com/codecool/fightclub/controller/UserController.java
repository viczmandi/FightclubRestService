package com.codecool.fightclub.controller;

import javax.servlet.http.HttpServletResponse;

import com.codecool.fightclub.model.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codecool.fightclub.model.User;
import com.codecool.fightclub.password.Password;
import com.codecool.fightclub.service.UserService;

import java.util.List;

import static com.codecool.fightclub.password.Password.checkPassword;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Fightclub Rest Service.";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void submitLogin(@RequestBody LoginBean loginBean, HttpServletResponse response) {
		List<User> userList = userService.getAllUsers();
		for (User u :
				userList) {
			if (loginBean.getEmailAddress().equals(u.getEmailAddress()) &&
					checkPassword(loginBean.getPassword(), u.getPassword())) {
				response.setStatus(HttpServletResponse.SC_ACCEPTED);
				break;
			} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void createUser(@RequestBody User user, HttpServletResponse response) {
		if (!userService.isUserExists(user)) {

			User newUser = user;
			newUser.setPassword(Password.hashPassword(newUser.getPassword()));

			userService.insert(newUser);

			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
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

