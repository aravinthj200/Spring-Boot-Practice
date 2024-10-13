package com.javaexpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.entities.User;
import com.javaexpress.exception.ResourceNotFoundException;
import com.javaexpress.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User cretateNewUser(User user) {
		User dbUser = userRepository.save(user);
		return dbUser;
	}

	public User findUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Userss not found"));
	}

	public List<User> findAllUser() {
		return userRepository.findAll();
	}

//	public List<User> findAllUserAnsSort(User user) {
//		List<User> users = userRepository.findAll();
//		users.stream().filter().
//		
//	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public User updateUser(Long userId, User user) {
		User dbUser = findUserById(userId);
		dbUser.setEmailId(user.getEmailId());
		dbUser.setPassword(user.getPassword());
		dbUser.setEmailId(user.getEmailId());
		userRepository.save(dbUser);
		return dbUser;
	}

}
