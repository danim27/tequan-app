package com.tequan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tequan.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	    
}
