package dao;

import java.util.List;
import model.OrderDetail;

public interface OrderDetailDao {
	//create
	void add(OrderDetail od);//inject 
		
	//read
	List<OrderDetail> selectAll();//查全部
	List<OrderDetail> selectById(int id);//用id找一筆
	String getNo();
	
	//update
	void update(OrderDetail od);
	
	//delete
	void deleteById(int id);
}
