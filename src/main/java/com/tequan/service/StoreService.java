package com.tequan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tequan.model.Product;
import com.tequan.model.Store;
import com.tequan.repository.ProductRepository;
import com.tequan.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;

	public List<Store> findAll() {
		List<Store> stores = (List<Store>) storeRepository.findAll();
		return stores;
	}

	public Store getStoreById(long storeId) {
		return storeRepository.findById(storeId).get();

	}

}
