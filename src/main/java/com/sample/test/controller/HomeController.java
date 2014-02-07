package com.sample.test.controller;

//import java.text.DateFormat;
//import java.util.Date;
import java.util.List;
//import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.test.service.UserService;
import com.sample.test.model.User;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		
		/*Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );	
		
		String numberOfUsers = userService.getNumberOfUsers();
		logger.info("numberOfUsers : " + numberOfUsers);		
		model.addAttribute("numberOfUsers", numberOfUsers );
		
		List <User> allUsers = userService.getAllUsers();
		logger.info("allUsers : " + allUsers);		
		model.addAttribute("allUsers", allUsers );*/
		logger.info("Home!");	
		return "index";
	}
	
	/*@RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute ("user") User user) {
		
		user.getUsername();
		user.getPassword();	
		userService.adduser(user);		
		return "home";		
		
    }*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute ("user") User user, HttpSession session) {
	boolean Con; 
		String userName = user.getUsername();
		String passWord = user.getPassword();			
		Con = (boolean) userService.login(userName, passWord, user, session);
		logger.info("Con:" + Con);	
		if(Con == true)
		{
			return "login";
		}
		else
		{
			return "redirect:/";
		}
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session){
	if(session.getAttribute("username")!=null){
		logger.info("not null");	
		return "login";
		}
	else{
		return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public void userList(User user, Model model){
		List <User> allUsers = userService.getAllUsers();
		logger.info("allUsers : " + allUsers);		
		model.addAttribute("allUsers", allUsers );
	}
	
	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	public void userList(@ModelAttribute ("user") User user, Model model, HttpSession session){
		String userName = user.getUsername();
		String passWord = user.getUsername();
		List <User> allUsers = userService.searchUsers(userName, passWord);
		logger.info("allUsers : " + allUsers);		
		model.addAttribute("allUsers", allUsers );
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}