package com.project.ApiGateway.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ApiGateway.Dao.RoleDao;
import com.project.ApiGateway.Dao.UserDao;
import com.project.ApiGateway.model.SaveUserDto;
import com.project.ApiGateway.model.User;

@Service
public class UserDetailServiceImplementation implements UserDetailsService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User myUser = userDao.findByUsername(username);
		if(myUser == null) 
			throw new UsernameNotFoundException("User 404");
		
		return new UserDetailImplementation(myUser);
	}
	
	public void saveUser(SaveUserDto saveUserDto) {
		userDao.save(new User(saveUserDto.getId(), saveUserDto.getUsername(), bcryptEncoder.encode(saveUserDto.getPassword()), roleDao.getOne(saveUserDto.getRoleId())));
	}
	
	public List<User> getAll() {
		return userDao.findAll();
	}
}
