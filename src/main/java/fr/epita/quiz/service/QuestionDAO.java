package fr.epita.quiz.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import fr.epita.quiz.data.model.Question;

public class QuestionDAO extends GerneralDAO<Question, Long> {

	@Override
	public Question getById(Long id) {
		Question question = em.find(Question.class, id);
		if (question == null)
            throw new EntityNotFoundException("Can't find Artist for ID " + id);
		return question;
	}

	@Override
	public List<Question> search(Question criteria) {
		String titleParam = criteria.getQuestion();
		
		Query searchQuery = em.createQuery("from Question where question = :pTitle");
		searchQuery.setParameter("pTitle", titleParam);
		@SuppressWarnings("unchecked")
		List<Question> resultList = searchQuery.getResultList();
		return resultList;
	}
}
