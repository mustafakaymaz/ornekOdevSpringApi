package com.javaspring.ornekodev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	
	@Column(name = "ProductName")
	private String productName;
	
	@Column(name = "ProductType")
	private String productType;

	
	public long getProductId() {
		return id;
	}

	
	public void setProductId(long productId) {
		this.id = id;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}


	public Product(long id, String productName, String productType) {
		super();
		this.id = id;
		this.productName = productName;
		this.productType = productType;
	}


	public Product() {
		
	}


	@Override
	public String toString() {
		return "Product [productId=" + id + ", productName=" + productName + ", productType=" + productType
				+ "]";
	}
	
}


		