package com.mphasis.CoinProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="CartC")
	public class Cart {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int cartID;
		private int productID;
		private int buyerID;
		private String productname;
		private int quantity;
		private double price;
		private int sellerId;
		
		public int getBuyerID() {
			return buyerID;
		}
		public void setBuyerID(int buyerID) {
			this.buyerID = buyerID;
		}
		public int getSellerId() {
			return sellerId;
		}
		public void setSellerId(int sellerId) {
			this.sellerId = sellerId;
		}
		public int getCartID() {
			return cartID;
		}
		public void setCartID(int cartID) {
			this.cartID = cartID;
		}
		public int getProductID() {
			return productID;
		}
		public void setProductID(int productID) {
			this.productID = productID;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Cart(int cartID, int productID, int buyerID, String productname, int quantity, double price,
				int sellerId) {
			super();
			this.cartID = cartID;
			this.productID = productID;
			this.buyerID = buyerID;
			this.productname = productname;
			this.quantity = quantity;
			this.price = price;
			this.sellerId = sellerId;
		}
		public Cart() {
			super();
		}
		@Override
		public String toString() {
			return "Cart [cartID=" + cartID + ", productID=" + productID + ", buyerID=" + buyerID + ", productname="
					+ productname + ", quantity=" + quantity + ", price=" + price + ", sellerId=" + sellerId + "]";
		}
		
			
}
