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

import com.libraryManagementSystem.model.Authors;
import com.libraryManagementSystem.model.Books;
import com.libraryManagementSystem.model.Publishers;
import com.libraryManagementSystem.services.AuthorsServices;
import com.libraryManagementSystem.services.BooksServices;
import com.libraryManagementSystem.services.PublishersServices;

@RestController
@RequestMapping("admin/books")
public class BooksController {

	@Autowired
	BooksServices bookServices;
	@Autowired
	AuthorsServices authorServices;
	@Autowired
	PublishersServices publisherServices;

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Books> listBooks() {
		return bookServices.listAll();
	}

	@GetMapping("/getByBookId/{bookId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Books> getBook(@PathVariable Integer bookId) {
		try {
			Books book = bookServices.getById(bookId);
			return new ResponseEntity<Books>(book, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addBook")
	@PreAuthorize("hasAuthority('books:write')")
	public void addBook(@RequestBody Books book) {
		Authors author = new Authors();
		author.setAuthorName(book.getAuthor().getAuthorName());
		Publishers publisher = new Publishers();
		publisher.setPublisherName(book.getPublisher().getPublisherName());
		authorServices.save(author);
		publisherServices.save(publisher);
		bookServices.save(book);
	}

	@PutMapping("/updateBook/{bookId}")
	@PreAuthorize("hasAuthority('books:write')")
	public ResponseEntity<Books> updateBook(@RequestBody Books book, @PathVariable Integer bookId) {
		try {
			Books existingBook = bookServices.getById(bookId);
			book.setBookId(existingBook.getBookId());
			bookServices.save(book);
			return new ResponseEntity<Books>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteBook/{bookId}")
	@PreAuthorize("hasAuthority('books:write')")
	public void deleteBook(@PathVariable Integer bookId) {
		bookServices.delete(bookId);
	}
}
