package com.javaspring.ornekodev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.ornekodev.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product>findByProductName(String productName);
}
