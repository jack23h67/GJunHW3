package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	//create
	void add(Order o);//inject 
		
	//read
	List<Order> selectAll();//查全部
	List<Order> selectById(int id);//用id找一筆
	String getNo();
	
	//update
	void update(Order o);
	
	//delete
	void deleteById(int id);
}
