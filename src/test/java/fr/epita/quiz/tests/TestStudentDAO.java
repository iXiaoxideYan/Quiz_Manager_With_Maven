package fr.epita.quiz.tests;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.data.model.User;
import fr.epita.quiz.service.StudentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestStudentDAO {
	@Inject
	StudentDAO studentDAO;
	
	@Test
	public void testCreateMethod() {
		User user = new User();
		studentDAO.create(user);
		
		Assert.assertNotEquals(0l, user.getId().longValue());
	}
	
	@Test
	public void testUpdateMethod() {
		User user = new User();
		user.setId(1l);
		studentDAO.create(user);
		
		user.setId(10l);
		studentDAO.update(user);
		
		Assert.assertEquals(10l, user.getId().longValue());
	}
	
	@Test
	public void testDeleteMethod() {
		User user = new User();
		user.setId(2l);
		studentDAO.create(user);
		
		studentDAO.delete(user);
		
	}
}
