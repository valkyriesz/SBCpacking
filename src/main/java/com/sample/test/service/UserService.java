package com.sample.test.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sample.test.model.User;

public interface UserService {
	
	public String getNumberOfUsers();
	public void adduser(User user);
	public List<User> getAllUsers();
	public List<User> searchUsers(String userName, String passWord);
	public boolean login(String userName, String passWord, User user, HttpSession session);
}
