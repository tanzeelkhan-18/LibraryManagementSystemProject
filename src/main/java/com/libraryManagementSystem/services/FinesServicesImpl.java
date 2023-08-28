package com.libraryManagementSystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.FinesDao;
import com.libraryManagementSystem.model.Fines;

@Service
@Transactional
public class FinesServicesImpl implements FinesServices {

	@Autowired
	private FinesDao finesDao;

	@Override
	public List<Fines> listAll() {
		return finesDao.findAll();
	}

	@Override
	public void save(Fines fine) {
		finesDao.save(fine);
	}

	@Override
	public Fines getById(Integer fineId) {
		return finesDao.findById(fineId).get();
	}

	@Override
	public void delete(Integer fineId) {
		finesDao.deleteById(fineId);
	}

}
