package fr.epita.quiz.service;

import java.util.List;

import fr.epita.quiz.data.model.Question;

public interface IQuestionDAO {
	public void create(Question question);
	
	public void update(Question question);

	public void delete(Question question);
	
	public List<Question> search();
	
	public Question getById(Long id);
}
