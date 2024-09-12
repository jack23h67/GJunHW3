package model;

import java.io.Serializable;

public class Order  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer orderid;
	private String  orderno;
	private String  customerno;
	private Double	amount;
	private Double	discount;
	private Double	freight;
	private Double  osum;
	private String  ordertime;
	private String  info;
	public Order() {
		super();
	}
	public Order(String customerno, Double amount, Double discount, Double freight,
			Double osum, String ordertime,String info) {
		super();
		this.customerno = customerno;
		this.amount = amount;
		this.discount = discount;
		this.freight = freight;
		this.osum = osum;
		this.ordertime = ordertime;
		this.info = info;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getCustomerno() {
		return customerno;
	}
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Double getOsum() {
		return osum;
	}
	public void setOsum(Double osum) {
		this.osum = osum;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	
	
}
