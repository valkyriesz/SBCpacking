package com.sample.test.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.sample.test.model.User;
import com.sample.test.repos.UserRepos;

import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;


//import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserServiceImp implements UserService{
	
	@Resource
	private UserRepos userRepos;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

	public String getNumberOfUsers(){
		long numberOfUsers = userRepos.count();
		return String.valueOf(numberOfUsers);
	}

	public void adduser(User user){
		userRepos.save(user);
	}
	
	public List<User> getAllUsers(){
		List<User> allUsers = userRepos.findAll();
		return allUsers;
	}
	
	public boolean login(String userName, String passWord, User user, HttpSession session){		
		boolean Indicator = false;
		user = userRepos.findByUsernameAndPassword(userName, passWord);
		if(user != null)
		{
			session.setAttribute( "ID", user.getUserID());
			session.setAttribute( "username", user.getUsername());
			logger.info("UserID : " + user.getUserID());			
			Indicator = true;
			logger.info("Indicator : " + Indicator);
			return Indicator;
		}
		else
			return Indicator;
	}

	public List<User> searchUsers(String userName, String passWord) {
		String userName1 = userName;
		String passWord1 = passWord;
		String userName11 = userName;
		String passWord11 = passWord;
		String userName111 = userName;
		String passWord111 = passWord;
		String userName1111 = userName;
		String passWord1111 = passWord;
		List<User> allUsers = userRepos.findByUsernameOrPasswordOrUsernameLikeOrPasswordLikeOrUsernameStartingWithOrPasswordStartingWithOrUsernameEndingWithOrPasswordEndingWithOrUsernameContainingOrPasswordContaining(userName, passWord, userName1 , passWord1, userName11, passWord11, userName111, passWord111, userName1111, passWord1111);
		logger.info("Found : " + allUsers);
		/*allUsers.addAll(userRepos.findByUsernameOrPasswordContaining(userName, passWord));
		allUsers.addAll(userRepos.findByUsernameOrPasswordEndingWith(userName, passWord));
		allUsers.addAll(userRepos.findByUsernameOrPasswordLike(userName, passWord));
		allUsers.addAll(userRepos.findByUsernameOrPassword(userName, passWord));*/		
		return allUsers;
	}
}
