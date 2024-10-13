package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.User;
import com.javaexpress.service.UserClientService;

@RestController
@RequestMapping("/api/v1/users/consumer")
public class UserClientController {

	@Autowired
	private UserClientService userClientService;

	@PostMapping
	public User createNewUser(@RequestBody User user) throws Exception {
		
		return userClientService.createUser(user);

	}
	@GetMapping
	public List<User> fethcAllUsersFromDb(User user) throws Exception{
		
		return userClientService.fetchAllUsers();
	}
	@GetMapping("{id}")
	public User fethcUserById(@PathVariable Long id) {
		return userClientService.fetchUseById(id);		
	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable Long id) {
		userClientService.deleteUsers(id);
	}
}
