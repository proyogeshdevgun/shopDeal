package com.yogesh.shoponlineback.daoimpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogesh.shoponlineback.dao.UserDAO;
import com.yogesh.shoponlineback.model.User;

@Service
@Repository()
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	UserDAO userDAO;
    
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<User> list() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public User get(String username) {
		return (User) sessionFactory.getCurrentSession().get(User.class, username);
	}
	
	@Transactional
	public  User validate(String username, String password) {
		String hql = "from User WHERE username ='" + username + "' and password='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (User)query.uniqueResult();
	}

	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
