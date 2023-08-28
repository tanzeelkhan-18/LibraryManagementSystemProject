package com.libraryManagementSystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.AuthorsDao;
import com.libraryManagementSystem.model.Authors;

@Service
@Transactional
public class AuthorsServicesImpl implements AuthorsServices {

	@Autowired
	private AuthorsDao authorsDao;

	@Override
	public List<Authors> listAll() {
		return authorsDao.findAll();
	}

	@Override
	public void save(Authors author) {
		authorsDao.save(author);
	}

	@Override
	public Authors getById(Integer authorId) {
		return authorsDao.findById(authorId).get();
	}

	@Override
	public void delete(Integer authorId) {
		authorsDao.deleteById(authorId);
	}

}
