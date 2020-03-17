package fr.epita.quiz.service;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.data.model.Question;

@Repository("IQuestionDAO")
public class QuestionDAO implements IQuestionDAO {

	@Inject
	SessionFactory sFactory;

	public void create(Question question) {
		Session session = sFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(question);
		transaction.commit();

	}

	public void update(Question question) {
		Session session = sFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.update(question);
		transaction.commit();

	}

	public void delete(Question question) {
		Session session = sFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.delete(question);
		transaction.commit();

	}

	public List<Question> search() {
		List<Question> list = null;
		Session session = sFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		list = session.createQuery("from Question", Question.class).list();
		transaction.commit();
		return list;
	}

	public Question getById(Long id) {
		Session session = sFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Question question = (Question) session.get(Question.class, id);
		transaction.commit();
		return question;
	}
}
