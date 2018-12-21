package com.tequan.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tequan.model.Product;
import com.tequan.model.Store;
import com.tequan.service.ProductService;
import com.tequan.service.StoreService;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public StoreService storeService;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public Product create(@RequestBody Map<String, String> body){
        String name = body.get("name");
        int stock = Integer.parseInt(body.get("stock"));
        long storeId = Long.parseLong(body.get("storeId"));
        Store store = storeService.getStoreById(storeId);
        // TODO update date with timestamp
        Product product = new Product(name, store, stock, new Date(), new Date());
        
        return productService.save(product);
    }
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Product> all() {
		List<Product> allProducts = productService.findAll();
		return allProducts;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Product find(@PathVariable(value="id") long productId){
        Product product = productService.getProductById(productId);
        return product;
        
    }
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Product update(@PathVariable(value="id") long productId, @RequestBody Map<String, String> body){
        Product product = productService.getProductById(productId);
        product.setStock(Integer.parseInt(body.get("stock")));
        product.setName(body.get("name"));
        Product updatedProduct = productService.save(product);
        return updatedProduct;
        
    }
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> delete(@PathVariable(value="id") long productId){
        Product product = productService.getProductById(productId);
        productService.delete(product);
        return ResponseEntity.ok().build();
        
    }
	
	@RequestMapping(value="/stores/{storeId}", method = RequestMethod.GET)
    public List<Product> findByStore(@PathVariable(value="storeId") long storeId){
		List<Product> products = productService.findAllByStore(storeId);
        return products;
        
    }
	
}
