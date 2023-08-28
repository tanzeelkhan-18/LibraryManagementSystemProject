package com.libraryManagementSystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.dao.UserAuthenticatorDao;
import com.libraryManagementSystem.dao.UsersDao;
import com.libraryManagementSystem.model.Users;
import com.libraryManagementSystem.security.ApplicationUserRole;

@Service
@Transactional
public class UsersServicesImpl implements UsersServices, UserDetailsService {

	@Autowired
	private UsersDao userDao;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Autowired
	private UserAuthenticatorDao userAuthenticatorDao;

	@Override
	public List<Users> listAll() {
		return userDao.findAll();
	}

	@Override
	public void save(Users user) {
		userDao.save(user);
	}

	@Override
	public Users getById(Integer userId) {
		return userDao.findById(userId).get();
	}

	@Override
	public void delete(Integer userId) {
		userDao.deleteById(userId);
	}

	@Override
	public Users findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUser = userAuthenticatorDao.selectApplicationUserByUsername(username);
		Users user = optionalUser.get();
		if (user == null) {
			throw new UsernameNotFoundException(String.format("User %s not found", username));
		}
		return new User(user.getUserName(), passwordEncoder().encode(user.getPassword()), ApplicationUserRole.ADMIN.getGrantedAuthorities());
	}
}
