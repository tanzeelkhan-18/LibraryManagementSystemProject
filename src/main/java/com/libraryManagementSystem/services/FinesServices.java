package com.libraryManagementSystem.services;

import java.util.List;

import com.libraryManagementSystem.model.Fines;

public interface FinesServices {
	public List<Fines> listAll();
	public void save(Fines fine);
	public Fines getById(Integer fineId);
	public void delete(Integer fineId);
}
