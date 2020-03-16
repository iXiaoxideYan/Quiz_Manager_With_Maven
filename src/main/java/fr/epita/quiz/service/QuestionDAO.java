package fr.epita.quiz.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.data.model.Question;

@Repository("IQuestionDAO")
public class QuestionDAO implements IQuestionDAO {

	@Inject
	SessionFactory sFactory;

	public void create(Question question) {
		Session session = sFactory.openSession();
		session.save(question);

	}

	public void update(Question question) {
		Session session = sFactory.openSession();
		session.update(question);

	}

	public void delete(Question question) {
		Session session = sFactory.openSession();
		session.delete(question);

	}

	public List<Question> search() {
		List<Question> list = null;
		Session session = sFactory.openSession();
		list = session.createQuery("from Question", Question.class).list();
		return list;
	}

	public List<Question> getById(Long id) {
		List<Question> list = null;
		Session session = sFactory.openSession();
		list = session.createQuery("FROM Question q where q.id = :id", Question.class).setParameter("id", id).list();
		return list;

	}
}
