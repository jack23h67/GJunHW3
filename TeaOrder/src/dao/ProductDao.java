package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	//create
	void add(Product p);//inject 
		
	//read
	List<Product> selectAll();//查全部
	List<Product> selectById(int id);//用id找一筆
	String getNo();
	
	//update
	void update(Product p);
	
	//delete
	void deleteById(int id);
}
