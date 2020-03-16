package fr.epita.quiz.service;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.quiz.data.model.User;


public class StudentDAO implements IUserDAO{
	@Inject
	SessionFactory sessionFactory;
	
	public void create(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);

	}

	public void update(User user) {
		Session session = sessionFactory.openSession();
		session.update(user);

	}

	public void delete(User user) {
		Session session = sessionFactory.openSession();
		session.delete(user);

	}
}
