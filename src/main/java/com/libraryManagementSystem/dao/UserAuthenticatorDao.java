package com.libraryManagementSystem.dao;

import java.util.Optional;

import com.libraryManagementSystem.model.Users;

public interface UserAuthenticatorDao {
	Optional<Users> selectApplicationUserByUsername(String userName);
}
