package com.mphasis.CoinProject.Bo;


import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mphasis.CoinProject.model.User;

@Repository
public class UserBo {
	
	
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		public Boolean insertUser(User u) {
			
					Session s=sf.openSession();
					Transaction t1=s.beginTransaction();
					s.save(u);
					t1.commit();
					s.close();
					
					
			return true;
		}

		public List<User> getAllUser() {
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			@SuppressWarnings("unchecked")
			List <User> li=s.createQuery("From User").list();
			t1.commit();
			s.close();
			
			return li;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<User> getUser(String mob){
			System.out.println(mob);
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			Query q=s.createQuery("From User where userMobile=:id");  
			q.setParameter("id", mob);
			List<User> list=q.list();
			
            t1.commit();
            s.close();
           
            return list;	
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<User> getUserbyId(int id){
			System.out.println(id);
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			Query q=s.createQuery("From User where userId=:id");  
			q.setParameter("id",id);
			List<User> list=q.list();
			
            t1.commit();
            s.close();
           
            return list;	
		}
		
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public List<User> getUserbymail(String email){
			System.out.println(email);
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			Query q=s.createQuery("From User where userEmail=:id");  
			q.setParameter("id", email);
			List<User> list=q.list();
			
            t1.commit();
            s.close();
           
            return list;	
		}
		
		
		public Boolean updatepass(String pass,int id) {
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			//s.save(pass,id);
			String hql = "UPDATE User SET password=:pass WHERE userId = :id";

			@SuppressWarnings("rawtypes")
			Query query = s.createQuery(hql);
			query.setParameter("pass", pass);
			query.setParameter("id", id);
			int rr = query.executeUpdate();

			t1.commit();
			s.close();

			if (rr != 0) {
			    return true;
			} else {
			    return false;
			}
			
		}
		
		
		public int mailver(String email) {
			int i=0;
			
			
			
			return i;
		}
		
		public String getcString() {
	        String sc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
	        StringBuilder s = new StringBuilder();
	        Random rnd = new Random();
	        while (s.length() < 5) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * sc.length());
	            s.append(sc.charAt(index));
	        }
	        String str = s.toString();
	        return str;

	    }

		public void updateUser(User u) {
			Session s=sf.openSession();
			Transaction t1=s.beginTransaction();
			s.merge(u);
			t1.commit();
			s.close();
			
			
		}
		
		
		
		
		

}
