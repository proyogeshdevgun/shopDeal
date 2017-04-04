package com.yogesh.shoponlineback;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yogesh.shoponlineback.dao.UserDAO;
import com.yogesh.shoponlineback.daoimpl.UserDAOImpl;
import com.yogesh.shoponlineback.model.User;

import junit.framework.Assert;

public class TestUserDAOManual {
	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	@Autowired
	UserDAOImpl userDAOImpl;

	@Autowired
	AnnotationConfigApplicationContext context;

	public TestUserDAOManual() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.yogesh.shoponlineback");
		context.refresh();
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAOImpl");
	}

	public void entryInTable() {
		user.setUsername("devgun4you");
		user.setName("yogesh");
		user.setPassword("devgun");
		user.setMobile("989898989");
		user.setRole("ROLE_USER");
		Assert.assertEquals("entryInTable", true, userDAO.save(user));

	}

	public boolean validate(String username, String pwd) {

		if (userDAO.validate(username, pwd) == null) 
		{
			System.out.println("User does not exist");
			return false;
		} 
		else 
		{
			System.out.println("user exists with this credentials");
			return true;
		}
	}

	public static void main(String[] args) {

		System.out.print("in main funcrtion");
		TestUserDAOManual t = new TestUserDAOManual();
/*		t.entryInTable();
*/		t.validate("devgun4you", "devgun");
	}

}
