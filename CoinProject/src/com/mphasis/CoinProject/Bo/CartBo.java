package com.mphasis.CoinProject.Bo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mphasis.CoinProject.model.Cart;

@Repository
public class CartBo {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public boolean insertO(Cart c)
	{
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
		return true;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Cart> getproductbyuid(int uid) {
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q=s.createQuery("From Cart where buyerID=:id");  
		q.setParameter("id", uid);
		List<Cart> list=q.list();
		
		t1.commit();
		s.close();
		return list;
	
	
}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Cart> getallcart() {
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q=s.createQuery("From Cart");  
		List<Cart> list=q.list();
		
		t1.commit();
		s.close();
		return list;
	
	
}
	
	@SuppressWarnings("rawtypes")
	public boolean deletecart(int cid) {
		// TODO Auto-generated method stub
		Session s=sf.openSession();
		Transaction t1=s.beginTransaction();
		Query q = s.createQuery("delete Cart where cartID=:cid ");
		q.setParameter("cid", cid);
		q.executeUpdate();
		
		t1.commit();
		s.close();
		
		return true;
	}

}
