package com.libraryManagementSystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.BooksDao;
import com.libraryManagementSystem.model.Books;

@Service
@Transactional
public class BooksServicesImpl implements BooksServices {

	@Autowired
	private BooksDao booksDao;

	@Override
	public List<Books> listAll() {
		return booksDao.findAll();
	}

	@Override
	public void save(Books book) {
		booksDao.save(book);
	}

	@Override
	public Books getById(Integer bookId) {
		return booksDao.findById(bookId).get();
	}

	@Override
	public void delete(Integer bookId) {
		booksDao.deleteById(bookId);
	}

}
