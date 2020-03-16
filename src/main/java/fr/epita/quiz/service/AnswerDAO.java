package fr.epita.quiz.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epita.quiz.data.model.Answer;

public class AnswerDAO {
	@Autowired
	SessionFactory sFactory;
	
	public void create(Answer ans) {

	}

	public void update(Answer ans) {
		
	}

	public void delete(Answer ans) {
		
	}
}
