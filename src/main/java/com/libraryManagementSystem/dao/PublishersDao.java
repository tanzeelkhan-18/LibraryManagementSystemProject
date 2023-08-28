package com.libraryManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.model.Publishers;

public interface PublishersDao extends JpaRepository<Publishers, Integer> {

}
