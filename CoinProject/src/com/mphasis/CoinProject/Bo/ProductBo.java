package com.mphasis.CoinProject.Bo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mphasis.CoinProject.model.Product;

@Repository
public class ProductBo {
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public Boolean insertProduct(Product p) {
		
				Session s=sf.openSession();
				Transaction t1=s.beginTransaction();
				s.save(p);
				t1.commit();
				s.close();
				
				
		return true;
	}
	
	public List<Product> getAllProducts() {
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		@SuppressWarnings("unchecked")
		List <Product> li=s.createQuery("From Product").list();
		t1.commit();
		s.close();
		
		return li;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List <Product> insertOrder(int id)
	{
		
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q=s.createQuery("From Product where productID=:id");  
		q.setParameter("id", id);
		List<Product> list=q.list();
		
		t1.commit();
		s.close();
		return list;
	}
	
	
	public List<Product> getAllProduct() 
	{
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> li=s.createQuery("From Product").list();
		t1.commit();
		s.close();
		return li;
	}
	
public Boolean updateProduct(Product p){
		
		
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		s.merge(p);
		t1.commit();
		s.close();
		
		return false;
	}
	
//	public List<Product> getsilverproducts() {
//		Session s=sf.openSession();
//		Transaction t1=s.beginTransaction();
//		@SuppressWarnings("unchecked")
//		List <Product> li=s.createQuery("From Product where category='silver' ").list();
//		t1.commit();
//		s.close();
//		
//		return li;
//	
//	
//}
//	
//	public List<Product> getoldproducts() {
//		Session s=sf.openSession();
//		Transaction t1=s.beginTransaction();
//		@SuppressWarnings("unchecked")
//		List <Product> li=s.createQuery("From Product where category='Old Currencies' ").list();
//		t1.commit();
//		s.close();
//		
//		return li;
//	
//	
//}
//	
//	public List<Product> getforeignproducts() {
//		Session s=sf.openSession();
//		Transaction t1=s.beginTransaction();
//		@SuppressWarnings("unchecked")
//		List <Product> li=s.createQuery("From Product where category='Foreign Currency' ").list();
//		t1.commit();
//		s.close();
//		
//		return li;
//	
//	
//}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Product> getproductbyuid(int uid) {
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q=s.createQuery("From Product where userID=:id");  
		q.setParameter("id", uid);
		List<Product> list=q.list();
		
		t1.commit();
		s.close();
		return list;
	
	
}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Product> getproductnotbyuid(int uid) {
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q=s.createQuery("From Product where userID!=:id");  
		q.setParameter("id", uid);
		List<Product> list=q.list();
		
		t1.commit();
		s.close();
		return list;
	
	
}
	
	@SuppressWarnings("rawtypes")
	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q = s.createQuery("delete Product where productId=:pid ");
		q.setParameter("pid", pid);
		q.executeUpdate();
		
		t1.commit();
		s.close();
		
		return true;
	}
	
//	public List<Product> getProductById(int b ) {
//		Session s=sf.openSession();
//		Transaction t1=s.beginTransaction();
//		
//		@SuppressWarnings("unchecked")
//		List <Product> li=s.createQuery("From Product where productID='Foreign Currency' ").list();
//		t1.commit();
//		s.close();
//		
//		return li;
//}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List <Product> getProductbypid(int id)
	{
		
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q=s.createQuery("From Product where productID=:id");  
		q.setParameter("id", id);
		List<Product> list=q.list();
		
		t1.commit();
		s.close();
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int getProductqbypid(int id)
	{
		
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q=s.createQuery("From Product where productID=:id");  
		q.setParameter("id", id);
		List<Product> list=q.list();
		int quntity = 0;
		for(Product p:list) {
			quntity=p.getQuantity();
		}
		t1.commit();
		s.close();
		return quntity;
	}


}
