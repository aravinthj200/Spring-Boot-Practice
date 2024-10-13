package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entities.User;
import com.javaexpress.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
//	@PostMapping("/create")
//	public User createNewUser1(@RequestBody User user) {
//								//If two method has the same URL it results in the ambigious problem
//		User newUser = userService.cretateNewUser(user);
//		return newUser;}
	
	@PostMapping("/create")
	public User createNewUser(@RequestBody User user) {
		
		User newUser = userService.cretateNewUser(user);
		return newUser;
		
	}
	@GetMapping
	public List<User> fetchAllUsers() {
		return userService.findAllUser();
	}
	
	@GetMapping("{id}")
	public User fetchUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}
	
	@DeleteMapping("{id}")
	public void updateUsers(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("update/{id}")
	public User updateUserDetails(@PathVariable Long id,@RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	
	
//	@DeleteMapping("deletes")
//	public void deleteUserDataByRequestParam(@RequestParam Long id) {
//		userService.deleteUser(id);
//	}


}
