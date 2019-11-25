package com.mphasis.CoinProject.Bo;
	

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mphasis.CoinProject.model.Orders;

	@Repository
	public class OrdersBo {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		public boolean insertO(Orders o)
		{
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			s.save(o);
			t.commit();
			s.close();
			return true;
		}
		
		public Boolean updateorder(Orders o){
			
			
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			s.merge(o);
			t1.commit();
			s.close();
			
			return false;
		}
		
		public List<Orders> getAllProduct() 
		{
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Orders> li=s.createQuery("From Orders").list();
			t1.commit();
			s.close();
			return li;
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Orders> getorderbyuid(int uid) {
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			Query q=s.createQuery("From Orders where buyer=:id");  
			q.setParameter("id", uid);
			List<Orders> list=q.list();
			
			t1.commit();
			s.close();
			return list;
		
		
	}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<Orders> getorder() {
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			Query q=s.createQuery("From Orders");  
			List<Orders> list=q.list();
			
			t1.commit();
			s.close();
			return list;
		
		
	}
		
		
	}
