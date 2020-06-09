package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class MyUserDetailsService {
	
	@Autowired
	private UserRepo userRepo;


	public User getuserByUserName(String userName) {
		return userRepo.findByUsername(userName);
		}
	
	public void saveuserName(User user) {
		userRepo.save(user);
	}

}
