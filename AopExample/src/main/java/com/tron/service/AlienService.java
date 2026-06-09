package com.tron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tron.model.Alien;
import com.tron.repo.IAlienRepo;

@Service
public class AlienService implements IAlienService 
{
	@Autowired
	private IAlienRepo repo;
	
	@Override
	public Alien registerAlien(Alien alien) {
		return repo.save(alien);
	}

	@Override
	public List<Alien> getAllAlienInfo() {
		return repo.findAll();
	}

}
