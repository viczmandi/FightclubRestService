package com.codecool.fightclub.dao;

import java.util.List;

import com.codecool.fightclub.model.User;

public interface UserDao {
	public void insert(User user);

	public void modify(User user);

	public void delete(int id);

	public User getUser(int id);

	public List<User> getAllUsers();
}
