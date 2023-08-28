package com.libraryManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryManagementSystem.model.Fines;

public interface FinesDao extends JpaRepository<Fines, Integer> {

}
