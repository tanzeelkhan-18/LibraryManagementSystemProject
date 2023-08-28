package com.libraryManagementSystem.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.PublishersDao;
import com.libraryManagementSystem.model.Publishers;

@Service
@Transactional
public class PublishersServicesImpl implements PublishersServices {

	@Autowired
	private PublishersDao publishersDao;

	@Override
	public List<Publishers> listAll() {
		return publishersDao.findAll();
	}

	@Override
	public void save(Publishers publisher) {
		publishersDao.save(publisher);
	}

	@Override
	public Publishers getById(Integer publisherId) {
		return publishersDao.findById(publisherId).get();
	}

	@Override
	public void delete(Integer publisherId) {
		publishersDao.deleteById(publisherId);
	}

}
