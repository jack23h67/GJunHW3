package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrderDao;
import model.Order;

public class OrderDaoImpl implements OrderDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Order o) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into order1(orderno,customerno,amount,discount,freight,osum,ordertime,info) "
				+ "values(?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, o.getOrderno());
			ps.setString(2, o.getCustomerno());
			ps.setDouble(3, o.getAmount());
			ps.setDouble(4, o.getDiscount());
			ps.setDouble(5, o.getFreight());
			ps.setDouble(6, o.getOsum());
			ps.setString(7, o.getOrdertime());
			ps.setString(8, o.getInfo());

			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Order> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from order1";
		List<Order> mlist = new ArrayList<Order>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Order o = new Order();
				o.setOrderid(rs.getInt("orderid"));
				o.setOrderno(rs.getString("orderno"));
				o.setCustomerno(rs.getString("customerno"));
				o.setAmount(rs.getDouble("amount"));
				o.setDiscount(rs.getDouble("discount"));
				o.setFreight(rs.getDouble("freight"));
				o.setOsum(rs.getDouble("osum"));
				o.setOrdertime(rs.getString("ordertime"));
				o.setInfo(rs.getString("info"));
								
				mlist.add(o);				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return mlist;
	}

	@Override
	public List<Order> selectById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from order1 where orderid=?";
		List<Order> mlist = new ArrayList<Order>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();

			Order o = new Order();
			o.setOrderid(rs.getInt("orderid"));
			o.setOrderno(rs.getString("orderno"));
			o.setCustomerno(rs.getString("customerno"));
			o.setAmount(rs.getDouble("amount"));
			o.setDiscount(rs.getDouble("discount"));
			o.setFreight(rs.getDouble("freight"));
			o.setOsum(rs.getDouble("osum"));
			o.setOrdertime(rs.getString("ordertime"));
			o.setInfo(rs.getString("info"));
							
			mlist.add(o);						
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return mlist;
	}

	@Override
	public String getNo() {
		Connection conn=DbConnection.getDb();
		String SQL="select MAX(orderid) as no from order1";
		String No = "O";
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
	public void update(Order o) {
		Connection conn=DbConnection.getDb();
		String SQL="update order1 set orderno=?,customerno=?,amount=?,discount=?,freight=?,osum=?,ordertime=?,info=?  WHERE orderid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			
			ps.setString(1, o.getOrderno());
			ps.setString(2, o.getCustomerno());
			ps.setDouble(3, o.getAmount());
			ps.setDouble(4, o.getDiscount());
			ps.setDouble(5, o.getFreight());
			ps.setDouble(6, o.getOsum());
			ps.setString(7, o.getOrdertime());
			ps.setString(8, o.getInfo());
			ps.setInt(   9, o.getOrderid());
			
			
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from order1 where storeid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
		
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
