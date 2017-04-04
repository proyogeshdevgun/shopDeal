package com.yogesh.shoponlineback.dao;

import java.util.List;

import com.yogesh.shoponlineback.model.User;

public interface UserDAO {


	public List<User> list();

	public User get(String username);

	public User validate(String username, String password);

	public boolean save(User user);

	public boolean update(User user);
}
