package com.tequan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private long id;
	private int quantity = 0;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
    @JoinColumn(name="food_order_id", nullable=false)
	private FoodOrder foodOrder;
	
	public OrderDetail() {}
	
	public OrderDetail(long id, int quantity, Product product) {  
		this.setId(id);
		this.setQuantity(quantity);
		this.setProduct(product);
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {

        return "Order{" +
        		"id=" + id +
        		", quantity='" + quantity + '\'' +
                '}';

    }
	
}
