package fr.epita.quiz.tests;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.data.model.Question;
import fr.epita.quiz.service.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestQuestionDAO {
	
	private static final Logger LOGGER = LogManager.getLogger(Question.class);

	@Inject
	QuestionDAO dao;
	
	@Test
	public void testCreateMethod() {
		Question question = new Question();
		dao.create(question);
		
		Assert.assertNotEquals(0l, question.getId().longValue());
		LOGGER.info("get question {}", question.getId());
		
	}
	
	@Test
	public void testUpdateMethod() {
		Question question = new Question();
		question.setId(1l);
		question.setQuestion(null);
		dao.update(question);
		
		Question q = dao.getById(1l);
		Assert.assertEquals(null, q.getQuestion());
		
		question.setQuestion("who are you?");	
		dao.update(question);
		q = dao.getById(1l);
		
		Assert.assertEquals("who are you?", q.getQuestion());
		
	}
	
	@Test
	public void testDeleteMethod() {
		Question question = new Question();
		question.setId(2l);
		dao.create(question);
		
		dao.delete(question);
		Assert.assertEquals(null, dao.getById(question.getId()));
	}
	
	@Test
	public void testSearch() {
		dao.create(new Question());
		List<Question> list = dao.search();

		Assert.assertNotNull(list);
	}
	
	@Test
	public void testGetById() {
		Long testid = 2l;
		String testquestion = "who are you?";
		Question question = new Question();
		question.setId(testid);
		question.setQuestion(testquestion);
		dao.create(question);
		
		Question q = dao.getById(testid);
		Assert.assertNotNull(q);
		LOGGER.info("---------- {}", q.getId());
		LOGGER.info("---------- {}", q.getQuestion());
		Assert.assertEquals(testid, q.getId());
		Assert.assertEquals(testquestion, q.getQuestion());
	}
}
