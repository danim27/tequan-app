package com.tequan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tequan.model.Product;
import com.tequan.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	public Product getProductById(long productId) {
		return productRepository.findById(productId).get();

	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}
	
	
    public List<Product> findAllByStore(long storeId) {
        List<Product> products = productRepository.findProductsByStore(storeId);
        return products;
    }

}
