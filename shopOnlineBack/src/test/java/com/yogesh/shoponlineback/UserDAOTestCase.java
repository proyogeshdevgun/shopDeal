package com.yogesh.shoponlineback;

import org.junit.BeforeClass;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yogesh.shoponlineback.dao.UserDAO;
import com.yogesh.shoponlineback.daoimpl.UserDAOImpl;
import com.yogesh.shoponlineback.model.User;

import junit.framework.Assert;

public class UserDAOTestCase {
	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@Autowired
	static UserDAOImpl userDAOImpl;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass // we can write @BeforeClasses only for the static methods
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.yogesh.shoponlineback");
		context.refresh();
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAOImpl");
	}

	@Test
	public void validateCredentials() {
		user = userDAO.validate("devgun4you", "devgun");
		Assert.assertNotNull("validateCredentials", user);
	}

	@Test
	public void inValidateCredentials() {
		user = userDAO.validate("Vibhav", "Vibhav");
		// Assert.assertNull("inValidateCredentials", user);
		Assert.assertEquals("inValidateCredentials", null, user);
	}

	/*
	 * @Test public void saveTestCase() {
	 * 
	 * // you have create /insert new row in db // provide values for user
	 * 
	 * user.setUsername("hhogesh"); user.setName("Chirutha");
	 * user.setMobile("989898989"); user.setPassword("Chirutha");
	 * user.setRole("ROLE_USER");
	 * 
	 * Assert.assertEquals("saveTestCase", true, userDAO.save(user));
	 * 
	 * }
	 */

	/*
	 * @Test public void updateTestCase() {
	 * 
	 * user = userDAO.get("bhog");
	 * 
	 * user.setMobile("768767876");
	 * 
	 * Assert.assertEquals("updateTestCase", true, userDAO.update(user));
	 * 
	 * }
	 */

	/*
	 * @Test
	 * 
	 * public void getUserTestCase() { user = userDAO.get("niit");
	 * Assert.assertNotNull("getUserTestCase", user); }
	 */

	/*
	 * @Test public void getAllUsersTestCase() { int size =
	 * userDAO.list().size(); Assert.assertEquals(" length check ", 8, size);
	 * 
	 * }
	 */

}
