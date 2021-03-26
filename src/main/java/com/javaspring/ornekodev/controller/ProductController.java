package com.javaspring.ornekodev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.ornekodev.entity.Product;
import com.javaspring.ornekodev.repository.ProductRepository;
import com.spring.ornekodev.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping
	public List<Product> getAllProduct(){
		return (List<Product>) this.productRepository.findAll();
	}
	
	@PostMapping
	public Product createProducts(@RequestBody Product product) {
			return this.productRepository.save(product);
	}
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable ("id") long productId) {
		Product existingProduct = this.productRepository.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Bu id ile ürün bulunamadı:"+ productId));
		existingProduct.setProductName(product.getProductName());
		existingProduct.setProductType(product.getProductType());;
		return this.productRepository.save(existingProduct);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable ("id") long productId){
		Product existingProduct = this.productRepository.findById(productId)
				.orElseThrow(()-> new ResourceNotFoundException("Bu id ile ürün bulunamadı:"+ productId));
		this.productRepository.delete(existingProduct);
		return ResponseEntity.ok().build();
	}
}

