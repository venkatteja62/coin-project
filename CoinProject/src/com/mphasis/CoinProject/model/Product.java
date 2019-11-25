package com.mphasis.CoinProject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product1")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productID;
	
	private String category;
	private double price;
	private String productName;
	private String description;
	private String stock;
	private String period;
	private String Company;
	private int quantity;
	private int userId;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Product(int productID, String category, double price, String productName, String description, String stock,
			String period, String company, int quantity, int userId) {
		super();
		this.productID = productID;
		this.category = category;
		this.price = price;
		this.productName = productName;
		this.description = description;
		this.stock = stock;
		this.period = period;
		Company = company;
		this.quantity = quantity;
		this.userId = userId;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", category=" + category + ", price=" + price + ", productName="
				+ productName + ", description=" + description + ", stock=" + stock + ", period=" + period
				+ ", Company=" + Company + ", quantity=" + quantity + ", userId=" + userId + "]";
	}
	
	
}
