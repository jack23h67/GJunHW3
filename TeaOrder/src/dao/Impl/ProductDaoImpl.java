package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.ProductDao;
import model.Product;

public class ProductDaoImpl implements ProductDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Product p) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into product(productno,productname,productprice,productimgpath) "
				+ "values(?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, p.getProductno());
			ps.setString(2, p.getProductname());
			ps.setDouble(3, p.getProductprice());
			ps.setString(2, p.getProductimgpath());
			
			ps.executeUpdate();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	@Override
	public List<Product> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from product";
		List<Product> mlist = new ArrayList<Product>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p = new Product();
				p.setProductid(rs.getInt("productid"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setProductprice(rs.getDouble("productprice"));
				p.setProductimgpath(rs.getString("productimgpath"));
				
				mlist.add(p);				
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return mlist;
	}

	@Override
	public List<Product> selectById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from product where productid=?";
		List<Product> mlist = new ArrayList<Product>();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p = new Product();
				p.setProductid(rs.getInt("productid"));
				p.setProductno(rs.getString("productno"));
				p.setProductname(rs.getString("productname"));
				p.setProductprice(rs.getDouble("productprice"));
				p.setProductimgpath(rs.getString("productimgpath"));
				
				mlist.add(p);				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return mlist;
	}

	@Override
	public String getNo() {
		Connection conn=DbConnection.getDb();
		String SQL="select MAX(productid) as no from product";
		String No = "P";
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
	public void update(Product p) {
		Connection conn=DbConnection.getDb();
		String SQL="update product set productno=?,productname=?,productprice=?,productimgpath=? WHERE productid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
						
			ps.setString(1, p.getProductno());
			ps.setString(2, p.getProductname());
			ps.setDouble(3, p.getProductprice());
			ps.setString(4, p.getProductimgpath());
			ps.setInt(   5, p.getProductid());
			
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from product where productid=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
		
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
