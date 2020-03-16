package fr.epita.quiz.service;

import fr.epita.quiz.data.model.User;

public interface IUserDAO {
	public void create(User user);
	
	public void update(User user);

	public void delete(User user);
}
