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

import com.libraryManagementSystem.model.Fines;
import com.libraryManagementSystem.services.FinesServices;

@RestController
@RequestMapping("admin/fines")
public class FinesController {

	@Autowired
	FinesServices fineServices;

	@GetMapping
	public List<Fines> listFines() {
		return fineServices.listAll();
	}

	@GetMapping("/getByFineId/{fineId}")
	public ResponseEntity<Fines> getFine(@PathVariable Integer fineId) {
		try {
			Fines fine = fineServices.getById(fineId);
			return new ResponseEntity<Fines>(fine, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Fines>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/fineAdd")
	public void addFine(@RequestBody Fines fine) {
		fineServices.save(fine);
	}

	@PutMapping("/updateFine/{fineId}")
	public ResponseEntity<Fines> updateFine(@RequestBody Fines fine, @PathVariable Integer fineId) {
		try {
			Fines existingFine = fineServices.getById(fineId);
			fine.setFineId(existingFine.getFineId());
			fineServices.save(fine);
			return new ResponseEntity<Fines>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Fines>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteFine/{fineId}")
	public void deleteFine(@PathVariable Integer fineId) {
		fineServices.delete(fineId);
	}
}
