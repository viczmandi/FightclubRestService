package com.codecool.fightclub.service;

import java.util.List;

import com.codecool.fightclub.model.User;

public interface UserService {
	void insert(User user);

	void modify(User user);

	void delete(int id);

	User getUser(int id);

	User getUserByEmail(String emailAddress);

	List<User> getAllUsers();

	List<String> getAllUsersEmail();

	boolean isUserExists(User user);


}
