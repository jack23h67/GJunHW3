package model;

import java.io.Serializable;

public class Customer  implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer	customerid;
	private String	customerno;
	private String	customerusername;
	private String	customerpassword;
	private String	customername;
	private String	customerphone;
	private String	customeraddress;
	private Integer	customerlevel;
	public Customer() {
		super();
	}
	public Customer(String customerno, String customerusername, String customerpassword, String customername,
			String customerphone, String customeraddress, Integer customerlevel) {
		super();
		this.customerno = customerno;
		this.customerusername = customerusername;
		this.customerpassword = customerpassword;
		this.customername = customername;
		this.customerphone = customerphone;
		this.customeraddress = customeraddress;
		this.customerlevel = customerlevel;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public String getCustomerno() {
		return customerno;
	}
	public void setCustomerno(String customerno) {
		this.customerno = customerno;
	}
	public String getCustomerusername() {
		return customerusername;
	}
	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}
	public String getCustomerpassword() {
		return customerpassword;
	}
	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public Integer getCustomerlevel() {
		return customerlevel;
	}
	public void setCustomerlevel(Integer customerlevel) {
		this.customerlevel = customerlevel;
	}
	
}
