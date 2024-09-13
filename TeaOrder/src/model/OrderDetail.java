package model;

import java.io.Serializable;

public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer orderdetailid;
	private String 	orderno;
	private String  orderdetailno;
	private String  productno;
	private String  productname;
	private Double  productprice;
	private Double  amount;
	public OrderDetail() {
		super();
	}
	public OrderDetail(String orderno, String orderdetailno, String productno,
			String productname, Double productprice, Double amount) {
		super();
		this.orderno = orderno;
		this.orderdetailno = orderdetailno;
		this.productno = productno;
		this.productname = productname;
		this.productprice = productprice;
		this.amount = amount;
	}
	public Integer getOrderdetailid() {
		return orderdetailid;
	}
	public void setOrderdetailid(Integer orderdetailid) {
		this.orderdetailid = orderdetailid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getOrderdetailno() {
		return orderdetailno;
	}
	public void setOrderdetailno(String orderdetailno) {
		this.orderdetailno = orderdetailno;
	}
	public String getProductno() {
		return productno;
	}
	public void setProductno(String productno) {
		this.productno = productno;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Double getProductprice() {
		return productprice;
	}
	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
