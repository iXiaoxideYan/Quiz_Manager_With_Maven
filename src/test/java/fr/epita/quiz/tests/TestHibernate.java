package fr.epita.quiz.tests;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.data.model.Question;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestHibernate {
	
	@Inject
	SessionFactory sf;
	
	@Test
	public void testFirstSessionFactory() {
		Session openSession = sf.openSession();
		Question question = new Question();
		question.setQuestion("What is a dependency?");
		question.setId(1l);
		openSession.save(question);
		
		Assert.assertNotEquals(0l, question.getId().longValue());
	}

}

