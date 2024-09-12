package service;

import java.util.List;

import model.Order;

public interface OrderService {
	void addOrder(Order o);
	List<Order> findAll();
	boolean updateOrder(int orderid,String orderno,String customerno,double amount,double discount,double freight,double osum,String ordertime);
	boolean deleteOrder(int id);
	boolean checkHasThisId(int id);
}
