package com.tron.service;

import java.util.List;

import com.tron.model.Alien;

public interface IAlienService {
	Alien registerAlien(Alien alien);
	List<Alien> getAllAlienInfo();
}
