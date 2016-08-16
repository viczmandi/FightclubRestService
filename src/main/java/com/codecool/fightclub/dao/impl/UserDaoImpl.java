package com.codecool.fightclub.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	public User getUserByEmail(String emailAddress) {
		Criteria criteria = session.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("emailAddress", emailAddress));
		if (criteria.list().size() > 0) {
			return (User) criteria.list().get(0);
		}
		return null;
	}
//		return (User) session.getCurrentSession().get(User.class,emailAddress);


	public List<User> getAllUsers() {
		return session.getCurrentSession().createQuery("from User").list();
	}

	public List<String> getAllUsersEmail() {
		return session.getCurrentSession().createQuery("select emailAddress from User").list();

	}

	public boolean isUserExists(User user) {
		return session.getCurrentSession().createQuery("select emailAddress from User").list()
				.contains(user.getEmailAddress());
	}

}
