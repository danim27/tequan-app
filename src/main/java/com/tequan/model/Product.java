package com.tequan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private long id;
	@Column(nullable = false, unique = true)
	private String name;
	@ManyToOne
    @JoinColumn(name="store_id", nullable=false)
	private Store store;
	private int stock = 0;
	private Date startDate;
	private Date endDate;
	
	public Product() {}
	
	public Product(String name, Store store, int stock, Date startDate, Date endDate) {
		this.setName(name);
		this.setStore(store);
		this.setStock(stock);
		this.setEndDate(startDate);
		this.setStartDate(startDate);
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
		this.name =  name;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}
	
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {

        return "Product{" +
        		"id=" + id +
        		", name='" + name + '\'' +
        		", stock='" + stock + '\'' +
        		", store='" + store + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';

    }
	
}
