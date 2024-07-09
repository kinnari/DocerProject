package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repositary.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	public List<Product> listAll() {
			return repo.findAll();
	}
	
	public Product findOne(long id) {
		return repo.findById(id).get();
	}
	
	public void save(Product product) {
		 repo.save(product);
	}
	public void delete(long id) {
        repo.deleteById(id);
    }
	
	
	
}
