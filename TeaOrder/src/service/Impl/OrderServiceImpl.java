package service.Impl;

import java.util.List;

import dao.Impl.OrderDaoImpl;
import model.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static OrderDaoImpl sdi = new OrderDaoImpl();

	@Override
	public void addOrder(Order o) {
		String no = sdi.getNo();
		o.setOrderno(no);
		sdi.add(o);
	}

	@Override
	public List<Order> findAll() {
		return sdi.selectAll();
	}

	@Override
	public boolean updateOrder(int orderid, String orderno, String customerno, double amount, double discount,
			double freight, double osum, String ordertime) {
		List<Order> l = sdi.selectById(orderid);
		if(l.size()>0)
		{
			Order o =l.get(0);
			o.setOrderno(orderno);
			o.setCustomerno(customerno);
			o.setAmount(amount);
			o.setDiscount(discount);
			o.setFreight(freight);
			o.setOsum(osum);
			o.setOrdertime(ordertime);

			sdi.update(o);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteOrder(int id) {
		if(sdi.selectById(id).size()>0)
		{
			sdi.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean checkHasThisId(int id) {
		if(sdi.selectById(id).size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
