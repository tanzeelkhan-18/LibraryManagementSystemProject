package com.libraryManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.model.Books;

public interface BooksDao extends JpaRepository<Books, Integer> {

}
