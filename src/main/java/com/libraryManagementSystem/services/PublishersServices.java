package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.model.Publishers;

public interface PublishersServices {
	public List<Publishers> listAll();
	public void save(Publishers publisher);
	public Publishers getById(Integer publisherId);
	public void delete(Integer publisherId);
}
