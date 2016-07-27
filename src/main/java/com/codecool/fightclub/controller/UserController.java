package com.codecool.fightclub.controller;

import static com.codecool.fightclub.password.Password.checkPassword;

import java.util.List;

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
		for (User u : userList) {
			if (loginBean.getEmailAddress().equals(u.getEmailAddress())
					&& checkPassword(loginBean.getPassword(), u.getPassword())) {

				session.setAttribute("session", u.getId());
				session.setMaxInactiveInterval(3 * 60);

				response.setStatus(HttpServletResponse.SC_ACCEPTED);
				break;
			} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void submitLogout(HttpSession session, HttpServletResponse response) {
		session.removeAttribute("session");
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void createUser(@Valid @RequestBody User user, HttpServletResponse response, BindingResult result) {
		if (!userService.isUserExists(user)) {
			if (result.hasErrors()) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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
	public void modifyUser(User user, HttpSession session) {
		// validate

		// after validation
		Integer userloggedin = (Integer) session.getAttribute("session");
		User modifiedUser = userService.getUser(userloggedin);
		modifiedUser.setBirthDate(user.getBirthDate());
		modifiedUser.setEmailAddress(user.getEmailAddress());
		modifiedUser.setFirstName(user.getFirstName());
		modifiedUser.setLastName(user.getLastName());
		modifiedUser.setPassword(Password.hashPassword(user.getPassword()));
		modifiedUser.setUserName(user.getUserName());
		modifiedUser.setGender(user.getGender());
		modifiedUser.setPhoneNumber(user.getPhoneNumber());
		modifiedUser.setCountry(user.getCountry());
		modifiedUser.setCity(user.getCity());
		modifiedUser.setAddress(user.getAddress());
		modifiedUser.setZipcode(user.getZipcode());
		modifiedUser.setImage(user.getImage());
		userService.modify(modifiedUser);
	}

	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public void deleteUser(User user, HttpSession session) {
		// validate

		// after validation
		Integer userloggedin = (Integer) session.getAttribute("session");
		userService.delete(userloggedin);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getUser(User user, HttpSession session, HttpServletResponse response) {
		// validate

		// after validation

		try {
			Integer userloggedin = (Integer) session.getAttribute("session");
			System.out.println(session.getId());
			List<User> userList = userService.getAllUsers();
			for (User u : userList) {
				if (userloggedin.equals(u.getId())) {

					user = userService.getUser(userloggedin);
					response.setStatus(HttpServletResponse.SC_FOUND);
					return user;
				}
			}
		} catch (NullPointerException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		return null;

	}
}
