package com.tequan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Store {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "store_id")
	protected long id;
	private String name;
	private int phoneNumber;
	private String location; 
	
	@OneToMany(mappedBy="store", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Product> products;
	
	public Store() {}
	
	public Store(long id, String name, int phoneNumber, String location) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.products = new HashSet<Product>();
	}


	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(HashSet<Product> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Store [id=" + id 
				+ ", name=" + name 
				+ ", phoneNumber=" + phoneNumber 
				+ ", location=" + location
				+ ", products=" + products + "]";
	}

	
	
}
