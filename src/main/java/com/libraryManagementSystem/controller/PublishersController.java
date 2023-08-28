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

import com.libraryManagementSystem.model.Publishers;
import com.libraryManagementSystem.services.PublishersServices;

@RestController
@RequestMapping("admin/publishers")
public class PublishersController {

	@Autowired
	PublishersServices publisherServices;

	@GetMapping
	public List<Publishers> listPublishers() {
		return publisherServices.listAll();
	}

	@GetMapping("/getByPublisherId/{publisherId}")
	public ResponseEntity<Publishers> getPublisher(@PathVariable Integer publisherId) {
		try {
			Publishers publisher = publisherServices.getById(publisherId);
			return new ResponseEntity<Publishers>(publisher, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Publishers>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/publisherAdd")
	public void addPublisher(@RequestBody Publishers publisher) {
		publisherServices.save(publisher);
	}

	@PutMapping("/updatePublisher/{publisherId}")
	public ResponseEntity<Publishers> updatePublisher(@RequestBody Publishers publisher, @PathVariable Integer publisherId) {
		try {
			Publishers existingPublisher = publisherServices.getById(publisherId);
			publisher.setPublisherId(existingPublisher.getPublisherId());
			publisherServices.save(publisher);
			return new ResponseEntity<Publishers>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Publishers>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletePublisher/{publisherId}")
	public void deletePublisher(@PathVariable Integer publisherId) {
		publisherServices.delete(publisherId);
	}
}
