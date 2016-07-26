package com.codecool.fightclub.controller;

import static com.codecool.fightclub.password.Password.checkPassword;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codecool.fightclub.model.LoginBean;
import com.codecool.fightclub.model.User;
import com.codecool.fightclub.password.Password;
import com.codecool.fightclub.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Fightclub Rest Service.";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void submitLogin(@RequestBody LoginBean loginBean, HttpServletResponse response, HttpSession session) {

		List<User> userList = userService.getAllUsers();
		for (User u :
				userList) {
			if (loginBean.getEmailAddress().equals(u.getEmailAddress()) &&
					checkPassword(loginBean.getPassword(), u.getPassword())) {

				session.setAttribute("session", u.getId());
				session.setMaxInactiveInterval(3 * 60);

				response.setStatus(HttpServletResponse.SC_ACCEPTED);
				break;
			} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user, HttpServletResponse response, BindingResult result) {
		if (!userService.isUserExists(user)) {
			if (result.hasErrors()) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				System.out.println(result);
			} else {
				User newUser = user;
				newUser.setPassword(Password.hashPassword(newUser.getPassword()));

				userService.insert(newUser);

				response.setStatus(HttpServletResponse.SC_CREATED);
			}
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

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getUser(User user, HttpSession session, HttpServletResponse response) {
		// validate

		// after validation
		try {
			Integer userloggedin = (Integer) session.getAttribute("session");
			List<User> userList = userService.getAllUsers();
			for (User u :
					userList) {
				if (userloggedin.equals(u.getId())) {

					user = userService.getUser(userloggedin);
					return user;

				} else {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				}

			}

		} catch (NullPointerException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		return null;
	}
}
