package service;

import java.util.List;
import model.OrderDetail;

public interface OrderDetailService {
	void addOrder(OrderDetail od);
	List<OrderDetail> findAll();
	boolean updateOrder(int orderdetailid,String orderno,String orderdetailno,String productno,
			double productprice,double amount);
	boolean deleteOrder(int id);
	boolean checkHasThisId(int id);
}
