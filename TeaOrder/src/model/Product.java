package model;

import java.io.Serializable;

public class Product  implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer	productid;
	private String	productno;
	private String	productname;
	private Double	productprice;
	private String	productimgpath;
	
	public Product() {
		super();
	}
	public Product(String productno, String productname, Double productprice, String productimgpath) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.productprice = productprice;
		this.productimgpath = productimgpath;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
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
	public String getProductimgpath() {
		return productimgpath;
	}
	public void setProductimgpath(String productimgpath) {
		this.productimgpath = productimgpath;
	}
	
	
	
}
