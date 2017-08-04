package com.mindworx.dao;

import java.util.List;

import com.mindworx.model.User;

public interface UserDao {
	public List<User> getAll();	
	public boolean create(User user);
	public boolean update(User user);
	public User getByLoginId(String custLogin);
	public User getByCustId(int custId);
}
