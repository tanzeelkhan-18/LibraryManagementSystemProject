package com.libraryManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libraryManagementSystem.model.Users;

@Repository
public class UserAuthenticatorDaoImpl implements UserAuthenticatorDao {

	@Autowired
	UsersDao usersDao;

	@Override
	public Optional<Users> selectApplicationUserByUsername(String userName) {
		return getApplicationUsers()
				.stream()
				.filter(applicationUser -> userName.equals(applicationUser.getUserName()))
				.findFirst();
	}

	private List<Users> getApplicationUsers(){
		List<Users> applicationUsers = usersDao.findAll();
		return applicationUsers;
	}

}
