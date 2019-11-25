package com.mphasis.CoinProject.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Orders2")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderid;
	
	private int productid;
	
	private double price;
	private String productN;
	private String buydate;
	private int buyer;
	private int seller;
	private String comments;
	private String status;
	private String paymentmode;
	private int quantity;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductN() {
		return productN;
	}
	public void setProductN(String productN) {
		this.productN = productN;
	}
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	public int getBuyer() {
		return buyer;
	}
	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}
	public int getSeller() {
		return seller;
	}
	public void setSeller(int seller) {
		this.seller = seller;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Orders(int orderid, int productid, double price, String productN, String buydate, int buyer, int seller,
			String comments, String status, String paymentmode, int quantity) {
		super();
		this.orderid = orderid;
		this.productid = productid;
		this.price = price;
		this.productN = productN;
		this.buydate = buydate;
		this.buyer = buyer;
		this.seller = seller;
		this.comments = comments;
		this.status = status;
		this.paymentmode = paymentmode;
		this.quantity = quantity;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", productid=" + productid + ", price=" + price + ", productN=" + productN
				+ ", buydate=" + buydate + ", buyer=" + buyer + ", seller=" + seller + ", comments=" + comments
				+ ", status=" + status + ", paymentmode=" + paymentmode + ", quantity=" + quantity + "]";
	}
		
}
