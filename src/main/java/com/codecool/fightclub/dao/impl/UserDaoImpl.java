package com.codecool.fightclub.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codecool.fightclub.dao.UserDao;
import com.codecool.fightclub.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory session;

	public void insert(User user) {
		session.getCurrentSession().save(user);
	}

	public void modify(User user) {
		session.getCurrentSession().update(user);
	}

	public void delete(int id) {
		session.getCurrentSession().delete(getUser(id));
	}

	public User getUser(int id) {
		return (User) session.getCurrentSession().get(User.class, id);
	}

	public List<User> getAllUsers() {
		return session.getCurrentSession().createQuery("from User").list();
	}

	public boolean isUserExists(User user) {
		return session.getCurrentSession().createQuery("select emailAddress from User").list()
				.contains(user.getEmailAddress());
	}
}
