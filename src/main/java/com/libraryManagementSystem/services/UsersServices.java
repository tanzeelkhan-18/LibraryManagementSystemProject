package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.model.Users;

public interface UsersServices {
	public List<Users> listAll();
	public void save(Users user);
	public Users getById(Integer userId);
	public void delete(Integer userId);
	public Users findByUserName(String userName);
}
