package com.libraryManagementSystem.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryManagementSystem.model.Authors;
import com.libraryManagementSystem.services.AuthorsServices;

@RestController
@RequestMapping("admin/authors")
public class AuthorsController {

	@Autowired
	AuthorsServices authorServices;

	@GetMapping
	public List<Authors> listAuthors() {
		return authorServices.listAll();
	}

	@GetMapping("/getByAuthorId/{authorId}")
	public ResponseEntity<Authors> getAuthor(@PathVariable Integer authorId) {
		try {
			Authors author = authorServices.getById(authorId);
			return new ResponseEntity<Authors>(author, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/authorAdd")
	public void addAuthor(@RequestBody Authors author) {
		authorServices.save(author);
	}

	@PutMapping("/updateAuthor/{authorId}")
	public ResponseEntity<Authors> updateAuthor(@RequestBody Authors author, @PathVariable Integer authorId) {
		try {
			Authors existingAuthor = authorServices.getById(authorId);
			author.setAuthorId(existingAuthor.getAuthorId());
			authorServices.save(author);
			return new ResponseEntity<Authors>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Authors>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteAuthor/{authorId}")
	public void deleteAuthor(@PathVariable Integer authorId) {
		authorServices.delete(authorId);
	}
}
