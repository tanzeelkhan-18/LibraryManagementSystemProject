package com.libraryManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libraryManagementSystem.model.Users;

public interface UsersDao extends JpaRepository<Users, Integer> {
	@Query("SELECT u FROM Users u WHERE u.userName = :userName")
    public Users findByUserName(@Param("userName") String userName);
}
