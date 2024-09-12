package service;

import java.util.List;

import model.Customer;

public interface CustomerService {
	void addCustomer(Customer c);
	List<Customer> findAll();
	boolean updateCustomer(int customerid,String customerno,String customerusername,String custmerpassword,String customername,
			String customerphone,String customeraddress,int customerlevel);
	boolean deleteCustomer(int id);
	boolean checkHasThisId(int id);
	
	Customer login(String username, String password);
	boolean findByUsername(String username);
}
