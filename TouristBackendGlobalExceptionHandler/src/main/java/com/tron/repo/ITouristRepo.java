package com.tron.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.Tourist;

@Repository
public interface ITouristRepo extends JpaRepository<Tourist, Integer>{
}
