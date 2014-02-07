package com.sample.test.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.test.model.User;

public interface UserRepos extends JpaRepository<User, Long>
{
	// Login
	public User findByUsernameAndPassword(String userName, String passWord);
	
	//Search
	public List<User> findByUsernameOrPasswordOrUsernameLikeOrPasswordLikeOrUsernameStartingWithOrPasswordStartingWithOrUsernameEndingWithOrPasswordEndingWithOrUsernameContainingOrPasswordContaining
	(String userName, String passWord, String userName1, String passWord1, String userName11, 
	 String passWord11, String userName111, String passWord111, String userName1111, String passWord1111);
	public List<User> findByUsernameOrPasswordLike(String userName, String passWord);
	/*public List<User> findByUsernameStartingWith(String userName);
	public List<User> findByUsernameOrPasswordEndingWith(String userName, String passWord);
	public List<User> findByUsernameOrPasswordContaining(String userName, String passWord);*/

}
