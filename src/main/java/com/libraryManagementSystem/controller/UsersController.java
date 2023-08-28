package com.libraryManagementSystem.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagementSystem.model.Users;
import com.libraryManagementSystem.services.UsersServices;

@RestController
@RequestMapping("admin/users")
public class UsersController {

	@Autowired
	UsersServices userServices;

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Users> listUsers() {
		return userServices.listAll();
	}

	@GetMapping("/getByUserId/{userId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Users> getUser(@PathVariable Integer userId) {
		try {
			Users user = userServices.getById(userId);
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addUser")
	@PreAuthorize("hasAuthority('users:write')")
	public void addUser(@RequestBody Users user) {
		userServices.save(user);
	}

	@PutMapping("/updateUser/{userId}")
	@PreAuthorize("hasAuthority('users:write')")
	public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable Integer userId) {
		try {
			Users existingUser = userServices.getById(userId);
			user.setUserId(existingUser.getUserId());
			userServices.save(user);
			return new ResponseEntity<Users>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteUser/{userId}")
	@PreAuthorize("hasAuthority('users:write')")
	public void deleteUser(@PathVariable Integer userId) {
		userServices.delete(userId);
	}
}
