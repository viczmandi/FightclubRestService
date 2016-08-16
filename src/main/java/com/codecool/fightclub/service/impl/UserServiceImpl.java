package com.codecool.fightclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codecool.fightclub.dao.UserDao;
import com.codecool.fightclub.model.User;
import com.codecool.fightclub.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Transactional
	public void insert(User user) {
		userDao.insert(user);
	}

	@Transactional
	public void modify(User user) {
		userDao.modify(user);
	}

	@Transactional
	public void delete(int id) {
		userDao.delete(id);
	}

	@Transactional
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Transactional
	public User getUserByEmail(String emailAddress) {
		return userDao.getUserByEmail(emailAddress);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Transactional
	public List<String> getAllUsersEmail() {
		return userDao.getAllUsersEmail();
	}

	@Transactional
	public boolean isUserExists(User user) {
		return userDao.isUserExists(user);
	}




}
