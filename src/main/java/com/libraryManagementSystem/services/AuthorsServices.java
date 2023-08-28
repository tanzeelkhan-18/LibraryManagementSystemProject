package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.model.Authors;

public interface AuthorsServices {
	public List<Authors> listAll();
	public void save(Authors author);
	public Authors getById(Integer authorId);
	public void delete(Integer authorId);
}
