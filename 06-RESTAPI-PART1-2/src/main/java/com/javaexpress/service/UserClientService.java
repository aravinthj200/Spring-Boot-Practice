package com.javaexpress.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javaexpress.dto.User;

@Service
public class UserClientService {
	@Autowired
	private RestTemplate restTemplate;

	public User createUser(User user) throws Exception {
		try {

			String url = "http://localhost:8080/users/create";
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "application/json");
			headers.set("Accept", "application/json");

			HttpEntity<User> entity = new HttpEntity<>(user, headers);

			ResponseEntity<User> reposneEntity = restTemplate.postForEntity(url, entity, User.class);
			if (reposneEntity.getStatusCode() == HttpStatus.OK) {
				return reposneEntity.getBody();
			} else {

				throw new RuntimeException("Failed to crate user");

			}
		} catch (Exception e) {
			throw new Exception("There is some problem with yhou  code please check");
		}
	}

	/*
	 * public List<User> fetchAllUsers(User user) throws Exception { try { String
	 * url = "http://localhost:8080/users"; ResponseEntity<List<User>> reponseEntity
	 * = restT emplate.getForEntity(url, User.class) } catch (Exception e) { throw
	 * new Exception("Thers is some problem in the code"); } return null; }
	 */

	public List<User> fetchAllUsers() {

		String url = "http://localhost:8080/users";
		ResponseEntity<User[]> reponseEntity = restTemplate.getForEntity(url, User[].class);
		return Arrays.asList(reponseEntity.getBody());
	}

	public User fetchUseById(Long id) {
		String url = "http://localhost:8080/users/" + id;
		ResponseEntity<User> reponseEntity = restTemplate.getForEntity(url, User.class);
		return reponseEntity.getBody();
	}

	public void deleteUsers(Long id) {
		String url  = "http://localhost:8080/users/"+id;
		 restTemplate.delete(url);
		
	}
}
