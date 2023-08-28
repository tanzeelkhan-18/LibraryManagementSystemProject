package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.model.Books;

public interface BooksServices {
	public List<Books> listAll();
	public void save(Books book);
	public Books getById(Integer bookId);
	public void delete(Integer bookId);

}
