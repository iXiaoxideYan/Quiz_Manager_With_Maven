package fr.epita.quiz.tests;

import java.util.List;

import javax.inject.Inject;

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
	
	@Inject
	QuestionDAO dao;
	
	@Test
	public void testCreateMethod() {
		Question question = new Question();
		dao.create(question);
		
		Assert.assertNotEquals(0l, question.getId().longValue());
	}
	
	@Test
	public void testUpdateMethod() {
		Question question = new Question();
		question.setId(1l);
		dao.create(question);
		
		question.setId(10l);
		dao.update(question);
		
		Assert.assertEquals(10l, question.getId().longValue());
	}
	
	@Test
	public void testDeleteMethod() {
		Question question = new Question();
		question.setId(2l);
		dao.create(question);
		
		dao.delete(question);
		Assert.assertEquals(0, dao.getById(question.getId()).size());
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
		Question question = new Question();
		question.setId(testid);
		dao.create(question);
		
		List<Question> list = dao.getById(testid);
		Assert.assertNotNull(list);
	}
}
