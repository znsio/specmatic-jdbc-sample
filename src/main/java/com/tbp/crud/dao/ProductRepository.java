package com.tbp.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbp.crud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
