package com.codecool.fightclub.dao;

import java.util.List;

import com.codecool.fightclub.model.User;

public interface UserDao {
	void insert(User user);

	void modify(User user);

	void delete(int id);

	User getUser(int id);

	List<User> getAllUsers();

	boolean isUserExists(User user);
}
