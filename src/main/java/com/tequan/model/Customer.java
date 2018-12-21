package com.tequan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String location; // TODO: update with a GPSCoordinates Class
	
	public Customer() {}
	
	public Customer(long id, String name, String email, String location) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.location = location;
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id 
				+ ", name=" + name 
				+ ", email=" + email 
				+ ", location=" + location + "]";
	}
	
}
