package service;

import java.util.List;

import model.Product;

public interface ProductService {
	void addProduct(Product p);
	List<Product> findAll();
	boolean updateProduct(int productid,String productno,String productname,double productprice,String productimgpath);
	boolean deleteProduct(int id);
	boolean checkHasThisId(int id);
}
