package dao;

import java.util.List;

import model.Customer;

public interface CustomerDao {
	//create
	void add(Customer c);//inject 
		
	//read
	List<Customer> selectAll();//查全部
	List<Customer> selectById(int id);//用id找一筆
	List<Customer> selectByUsername(String username);
	List<Customer> selectByUsernameAndPassword(String username,String password);
	String getNo();
	
	
	//update
	void update(Customer c);
	
	//delete
	void deleteById(int id);
}
