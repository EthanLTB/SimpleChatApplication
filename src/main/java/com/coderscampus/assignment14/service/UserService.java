package com.coderscampus.assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repo.UserRepository;
@Service
public class UserService {
@Autowired
private UserRepository userRepo;
	public  void save(User user) {
		userRepo.save(user);
		
	}
	public User findByName(String name) {
	
		return userRepo.findByName(name);
	}

}
