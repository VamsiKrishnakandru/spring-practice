package com.tron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tron.model.Users;
import com.tron.repo.IUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Users user = repo.findByName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("uer not found 404");
		}
		return new UserPrincipal(user);
	}
}
