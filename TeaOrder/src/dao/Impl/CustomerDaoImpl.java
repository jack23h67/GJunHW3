package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import dao.DbConnection;
import model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Customer c) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into customer(customerno,customerusername,customername,customerpassword,customerphone,customerlevel,customeraddress,customerlevel) "
				+ "values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, c.getCustomerno());
			ps.setString(2, c.getCustomerusername());
			ps.setString(3, c.getCustomerpassword());
			ps.setString(4, c.getCustomername());
			ps.setString(5, c.getCustomerphone());
			ps.setString(6, c.getCustomeraddress());
			ps.setInt(   7, c.getCustomerlevel());
			
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from customer";
		List<Customer> mlist = new ArrayList<Customer>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerid(rs.getInt("customerid"));
				c.setCustomerno(rs.getString("customerno"));
				c.setCustomerusername(rs.getString("customerusername"));
				c.setCustomerpassword(rs.getString("customerpassword"));
				c.setCustomername(rs.getString("customername"));
				c.setCustomerphone(rs.getString("customerphone"));
				c.setCustomeraddress(rs.getString("customeraddress"));
				c.setCustomerlevel(rs.getInt("customerlevel"));

				mlist.add(c);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mlist;
	}

	@Override
	public List<Customer> selectById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from customer where customerid=?";
		List<Customer> mlist = new ArrayList<Customer>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerid(rs.getInt("customerid"));
				c.setCustomerno(rs.getString("customerno"));
				c.setCustomerusername(rs.getString("customerusername"));
				c.setCustomerpassword(rs.getString("customerpassword"));
				c.setCustomername(rs.getString("customername"));
				c.setCustomerphone(rs.getString("customerphone"));
				c.setCustomeraddress(rs.getString("customeraddress"));
				c.setCustomerlevel(rs.getInt("customerlevel"));
				
				mlist.add(c);			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mlist;
	}

	@Override
	public List<Customer> selectByUsername(String username) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from customer where customername=?";
		List<Customer> mlist = new ArrayList<Customer>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerid(rs.getInt("customerid"));
				c.setCustomerno(rs.getString("customerno"));
				c.setCustomerusername(rs.getString("customerusername"));
				c.setCustomerpassword(rs.getString("customerpassword"));
				c.setCustomername(rs.getString("customername"));
				c.setCustomerphone(rs.getString("customerphone"));
				c.setCustomeraddress(rs.getString("customeraddress"));
				c.setCustomerlevel(rs.getInt("customerlevel"));
				
				mlist.add(c);			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mlist;
	}

	@Override
	public List<Customer> selectByUsernameAndPassword(String username, String password) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from customer where customerusername=? and customerpassword=?";
		List<Customer> mlist = new ArrayList<Customer>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setCustomerid(rs.getInt("customerid"));
				c.setCustomerno(rs.getString("customerno"));
				c.setCustomerusername(rs.getString("customerusername"));
				c.setCustomerpassword(rs.getString("customerpassword"));
				c.setCustomername(rs.getString("customername"));
				c.setCustomerphone(rs.getString("customerphone"));
				c.setCustomeraddress(rs.getString("customeraddress"));
				c.setCustomerlevel(rs.getInt("customerlevel"));
				
				mlist.add(c);			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mlist;
	}

	@Override
	public String getNo() {
		Connection conn=DbConnection.getDb();
		String SQL="select MAX(customerid) as no from customer";
		String No = "C";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int iNo = rs.getInt("no")+1;
				
				No+=iNo;			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return No;
	}

	@Override
	public void update(Customer c) {
		Connection conn=DbConnection.getDb();
		String SQL="update customer set customerno=?,customerusername=?,customerpassword=?,customername=?,customerphone=?,customeraddress=?,customerlevel=?  WHERE customerid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			
			
			ps.setString(1, c.getCustomerno());
			ps.setString(2, c.getCustomerusername());
			ps.setString(3, c.getCustomerpassword());
			ps.setString(4, c.getCustomername());
			ps.setString(5, c.getCustomerphone());
			ps.setString(6, c.getCustomeraddress());
			ps.setInt(   7, c.getCustomerlevel());
			
			ps.setInt(   8, c.getCustomerid());
					
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from customer where customerid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
		
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
