package com.tequan.model;

import java.util.Date;
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
import javax.persistence.Table;

@Entity
@Table(name="food_order")
public class FoodOrder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_order_id")
	private long id;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
	private Store store;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
	private Customer customer;
	private Date date;
	@OneToMany(mappedBy="foodOrder")
	private Set<OrderDetail> items;

	public FoodOrder() {}


	public FoodOrder(long id, Store store, Customer customer, Date date, Set<OrderDetail> items) {
		super();
		this.id = id;
		this.store = store;
		this.customer = customer;
		this.date = date;
		this.items = new HashSet<OrderDetail>();
	}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Set<OrderDetail> getItems() {
		return items;
	}


	public void setItems(HashSet<OrderDetail> items) {
		this.items = items;
	}


	@Override
	public String toString() {

        return "Order{" +
        		"id=" + id +
        		", store='" + this.store + '\'' +
        		", customer='" + this.customer + '\'' +
                ", date='" + this.date + '\'' +
                ", items='" + this.items + '\'' +
                '}';

    }
	
}
