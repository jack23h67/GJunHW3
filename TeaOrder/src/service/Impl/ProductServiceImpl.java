package service.Impl;

import java.util.List;

import dao.Impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static ProductDaoImpl sdi = new ProductDaoImpl();
	@Override
	public void addProduct(Product p) {
		String no = sdi.getNo();
		p.setProductno(no);
		sdi.add(p);		
	}

	@Override
	public List<Product> findAll() {
		return sdi.selectAll();
	}

	@Override
	public boolean updateProduct(int productid, String productno, String productname, double productprice,
			String productimgpath) {
		List<Product> l = sdi.selectById(productid);
		if(l.size()>0)
		{
			Product p =l.get(0);
			p.setProductno(productno);
			p.setProductname(productname);
			p.setProductprice(productprice);
			p.setProductimgpath(productimgpath);
			
			sdi.update(p);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int id) {
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
