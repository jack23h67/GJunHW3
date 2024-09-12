package service.Impl;

import java.util.List;

import dao.Impl.CustomerDaoImpl;
import model.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static CustomerDaoImpl sdi = new CustomerDaoImpl();
	@Override
	public void addCustomer(Customer c) {
		String no = sdi.getNo();
		c.setCustomerno(no);
		sdi.add(c);	
	}

	@Override
	public List<Customer> findAll() {
		return sdi.selectAll();
	}

	@Override
	public boolean updateCustomer(int customerid, String customerno, String customerusername, String custmerpassword,
			String customername, String customerphone, String customeraddress, int customerlevel) {
		List<Customer> l = sdi.selectById(customerid);
		if(l.size()>0)
		{
			Customer c =l.get(0);
			c.setCustomerno(customerno);
			c.setCustomerusername(customerusername);
			c.setCustomerpassword(custmerpassword);
			c.setCustomername(customername);
			c.setCustomerphone(customerphone);
			c.setCustomeraddress(customeraddress);
			c.setCustomerlevel(customerlevel);
			
			sdi.update(c);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(int id) {
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

	@Override
	public Customer login(String username, String password) {
		List<Customer> l=sdi.selectByUsernameAndPassword(username, password);	
		Customer m=null;
		if(l.size()!=0)
		{
			m=l.get(0);
		}
		
		return m;
	}

	@Override
	public boolean findByUsername(String username) {
		if(sdi.selectByUsername(username).size()>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
