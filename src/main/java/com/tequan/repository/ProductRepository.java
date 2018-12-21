package com.tequan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tequan.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p JOIN p.store st WHERE st.id = :storeId ") 
	List<Product> findProductsByStore(@Param("storeId") long storeId);
	
	    
}
