/*********************
* UserController.java
* 06-Sep-2023 
* MACK-WORLD 
**********************/
package com.mack.controllers;

import java.net.URI;
import java.util.List;

import com.mack.erros.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mack.dao.UserDao;
import com.mack.data.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Bhagwat Kolte
 *
 */
@RestController
public class UserController {
	
	private UserDao userDao;
	
	
	
	/**
	 * @param userDao
	 */
	public UserController(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@GetMapping("/user/all")
	public List<User> getAllUsers() {
		return userDao.daGetAllUsers();
	}

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		User user = userDao.daGetUser(id);
		if (user == null){
			throw new UserNotFoundException("ID: " + id);
		}
		return user;
	}

	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		User user1 = userDao.daAddUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{userID}")
				.buildAndExpand(user1.getUserID()).toUri();
		return ResponseEntity.created(location).build();

	}

}
