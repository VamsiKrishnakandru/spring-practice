package com.tron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Users;

@Repository
public interface IUserRepo extends JpaRepository<Users, String> 
{
	Users findByName(String userName);
}
