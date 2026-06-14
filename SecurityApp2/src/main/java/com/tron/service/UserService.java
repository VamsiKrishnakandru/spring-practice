package com.tron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.model.Users;
import com.tron.repo.IUserRepo;

@Service
public class UserService {
	
	@Autowired
	private IUserRepo repo;
	
	public Users register(Users user)
	{
		return repo.save(user);
	}
}
