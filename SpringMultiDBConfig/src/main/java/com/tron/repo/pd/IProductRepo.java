package com.tron.repo.pd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tron.model.pd.Product;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {

}
