package com.libraryManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.model.Authors;

public interface AuthorsDao extends JpaRepository<Authors, Integer> {

}
