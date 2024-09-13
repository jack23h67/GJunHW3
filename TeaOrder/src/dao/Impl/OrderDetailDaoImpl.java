package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrderDetailDao;
import model.Order;
import model.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(OrderDetail od) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into order_detail(orderno,orderdetailno,productno,productname,productprice,amount) "
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, od.getOrderno());
			ps.setString(2, od.getOrderdetailno());
			ps.setString(3, od.getProductno());
			ps.setString(4, od.getProductname());
			ps.setDouble(5, od.getProductprice());
			ps.setDouble(6, od.getAmount());
			

			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<OrderDetail> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from order_detail";
		List<OrderDetail> mlist = new ArrayList<OrderDetail>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				OrderDetail od = new OrderDetail();
				od.setOrderdetailid(rs.getInt("orderdetailid"));
				od.setOrderno(rs.getString("orderno"));
				od.setOrderdetailno(rs.getString("orderdetailno"));
				od.setProductno(rs.getString("productno"));
				od.setProductname(rs.getString("productname"));
				od.setProductprice(rs.getDouble("productprice"));
				od.setAmount(rs.getDouble("amount"));
								
				mlist.add(od);				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return mlist;
	}

	@Override
	public List<OrderDetail> selectById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from order_detail where orderdetailid=?";
		List<OrderDetail> mlist = new ArrayList<OrderDetail>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			OrderDetail od = new OrderDetail();
			od.setOrderdetailid(rs.getInt("orderdetailid"));
			od.setOrderno(rs.getString("orderno"));
			od.setOrderdetailno(rs.getString("orderdetailno"));
			od.setProductno(rs.getString("productno"));
			od.setProductname(rs.getString("productname"));
			od.setProductprice(rs.getDouble("productprice"));
			od.setAmount(rs.getDouble("amount"));
							
			mlist.add(od);				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return mlist;
	}

	@Override
	public String getNo() {
		Connection conn=DbConnection.getDb();
		String SQL="select MAX(orderdetailid) as no from order_detail";
		String No = "OD";
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
	public void update(OrderDetail od) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from order_detail where orderdetailid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
		
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
