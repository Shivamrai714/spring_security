package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Services.UserService;
import com.learn.models.User;

@RestController        //data here will be returned in from of json object , but no concepts of html/jsp pages.
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
  //return all user
	@GetMapping("/")
	public List<User> getAllUsers()
	{
		return this.userService.getAllUsers();
	}
	
	//@PreAuthorize("hasRole('ADMIN')")          //does the work of ant,MAtchers()
	//return single user
	@GetMapping("/{username}")
	public User getUser( @PathVariable("username") String username)
	{
		return this.userService.getUser(username);
	}
	
	 // add a user
   @PostMapping("/")
	public User add(@RequestBody User user)  // Json format data converted to User obj useing @RequestBody
	{
		this.userService.addUser(user);
		return user;
	}
	
 
	
}
