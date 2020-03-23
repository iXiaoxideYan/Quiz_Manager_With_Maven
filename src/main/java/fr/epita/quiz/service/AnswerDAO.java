package fr.epita.quiz.service;

import java.util.List;

import javax.persistence.Query;

import fr.epita.quiz.data.model.Answer;
import fr.epita.quiz.data.model.Exam;
import fr.epita.quiz.data.model.User;

public class AnswerDAO extends GerneralDAO<Answer, Long>{

	@Override
	public List<Answer> search(Answer criteria) {
		User userParam = criteria.getUser();
		Exam examParam = criteria.getExam();
		
		Query searchQuery = em.createQuery("from Answer where title = :pTitle And pUser");
		searchQuery.setParameter("pTitle", examParam);
		searchQuery.setParameter("pUser", userParam);
		@SuppressWarnings("unchecked")
		List<Answer> resultList = searchQuery.getResultList();
		return resultList;
	}

	@Override
	public Answer getById(Long id) {
		return em.find(Answer.class, id);
	}
}
