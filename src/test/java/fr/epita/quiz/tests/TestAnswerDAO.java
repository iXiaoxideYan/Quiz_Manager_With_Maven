package fr.epita.quiz.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.data.model.Answer;
import fr.epita.quiz.service.GerneralDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestAnswerDAO {
	
	@Autowired
	GerneralDAO<Answer, Long> dao;
	
	@Test
	public void testSearch() {
		Answer answer = new Answer();
		dao.create(answer);
		List<Answer> list = dao.search(answer);

		Assert.assertNotNull(list);
	}
}
