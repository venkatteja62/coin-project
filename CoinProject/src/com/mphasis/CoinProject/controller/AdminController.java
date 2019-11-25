package com.mphasis.CoinProject.controller;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.CoinProject.Bo.ProductBo;
import com.mphasis.CoinProject.Bo.UserBo;
import com.mphasis.CoinProject.model.Product;
import com.mphasis.CoinProject.model.User;

@RestController
public class AdminController {
	
	@Autowired
	UserBo ub;
	
	@Autowired
	ProductBo pb;
	@RequestMapping("addadminproducts")
	public ModelAndView addproductfirstMethod(HttpServletRequest req)
	{
		HttpSession us = req.getSession();
		Integer id =  (Integer) us.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			HttpSession s1 = req.getSession(true);
			 
			 ModelAndView mv=null;
			String s=ub.getcString();
			System.out.println(s);
			 s1.setAttribute("s",s);
			 
			mv=new ModelAndView("login");
		
			return mv;
		}
		
		return new ModelAndView("addadminproduct");
	}
	@RequestMapping("logout")
	public ModelAndView logoutmethod(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		session.invalidate();
		return new ModelAndView("index");
	}
	

	@RequestMapping(value="insertadminproduct",method=RequestMethod.POST)
	public ModelAndView insertproductmethod(HttpServletRequest req)
	{
		String c = req.getParameter("pcategory");
		
		double price = Double.parseDouble(req.getParameter("pprice"));
		String pname = req.getParameter("pname");
		String pd = req.getParameter("pdescription");
		String ps = req.getParameter("pstock");
		String pp = req.getParameter("pperiod");
		String pm = req.getParameter("pmaterial");
		int pq =Integer.parseInt( req.getParameter("pquantity"));
		System.out.println(c+" "+price+" "+pname+" "+pd+" "+ps+" "+pp+" "+pm+" "+pq);
		int id=Integer.parseInt( req.getParameter("id"));
		System.out.println(id);
		@SuppressWarnings("unused")
		boolean b=false;
		@SuppressWarnings("unused")
		String utype="Product";
		Product p=new Product(0,c,price,pname,pd,ps,pp,pm,pq,id);
		b=pb.insertProduct(p);
		if(b=true) {
		return new ModelAndView("adminpage");
		}
		else {
			return new ModelAndView("error");
		}
	}
	
	
		@RequestMapping("viewuser")
		public ModelAndView firstMethod(HttpServletRequest req)
		{
			ModelAndView mv=new ModelAndView("viewuser");
			HttpSession us = req.getSession();
			Integer id =  (Integer) us.getAttribute("id");
			if(id==null) {

				HttpSession s1 = req.getSession(true);
				String s=ub.getcString();
				System.out.println(s);
				 s1.setAttribute("s",s);
				 
				mv=new ModelAndView("login");
			
				return mv;
			}
			List<User> li=ub.getUserbyId(id);
			for(User u:li) {
			System.out.println(u);}
			mv.addObject("li", li);
			return mv;
		}
		
		@RequestMapping("viewusers")
		public ModelAndView firtMethod(HttpServletRequest req)
		{
			ModelAndView mv=new ModelAndView("viewuserAdmin");
			HttpSession us = req.getSession();
			Integer id =  (Integer) us.getAttribute("id");
			System.out.println(id);
			if(id==null) {
				HttpSession s1 = req.getSession(true);
				String s=ub.getcString();
				System.out.println(s);
				 s1.setAttribute("s",s);
				 
				mv=new ModelAndView("login");
			
				return mv;
			}
			List<User> li=ub.getAllUser();
			for(User u:li) {
			System.out.println(u);}
			mv.addObject("li", li);
			return mv;
		}
		
		
		@RequestMapping(value="updateuser" , method = RequestMethod.POST)
		public ModelAndView thirdMethod(HttpServletRequest req) {
			int uid=Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("uname");
			System.out.println(name);
			String pass = req.getParameter("upass");
			String cpass = req.getParameter("ucpass");
			String mobile = req.getParameter("umobile");
			String city = req.getParameter("ucity");
			String email = req.getParameter("uemail");
			String gender = req.getParameter("ugender");
			String dob = req.getParameter("udob");
			String squestion = req.getParameter("usecurity");
			String answer = req.getParameter("uanswer");
			DateTimeFormatter f1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate udob=LocalDate.parse(dob, f1);
			
			
			
			
			
			@SuppressWarnings("unused")
			String utype="User";
			if(pass.equals(cpass)) {
			User u=new User(uid,name,email,mobile,pass,cpass,udob,gender,squestion,answer,city);
			ub.updateUser(u);
			List<User> li=ub.getAllUser();
			ModelAndView mv= new ModelAndView("viewuser");
			mv.addObject("li", li);
			return mv;
			}
			else
			{
				return new ModelAndView("error");
			}
		}
		
		
		
		@SuppressWarnings("unused")
		@RequestMapping("viewproduct")
		public ModelAndView secondMethodA(HttpServletRequest req) {
			ModelAndView mv=new ModelAndView("viewproductA");
			Integer uid=Integer.parseInt(req.getParameter("uid"));
			if(uid==null) {
				HttpSession s1 = req.getSession(true);
				 
				String s=ub.getcString();
				System.out.println(s);
				 s1.setAttribute("s",s);
				 
				mv=new ModelAndView("login");
			
				return mv;
			}
			List<Product> li=pb.getproductbyuid(uid);
			mv.addObject("li", li);
			return mv;
		}
		
		@RequestMapping("editadminu")
		public ModelAndView editUserAdminMethod(HttpServletRequest req) {
			ModelAndView mv=new ModelAndView("edituser");
			
			List<User> li=ub.getAllUser();
			mv.addObject("li", li);
			System.out.println(li);
			return mv;
		}
		
		@RequestMapping("editAdminp")
		public ModelAndView editProductAdminMethod(HttpServletRequest req) {
			ModelAndView mv=new ModelAndView("editproduct");
			int pid=Integer.parseInt(req.getParameter("pid"));
			List<Product> li=pb.getProductbypid(pid);
			System.out.println(li);
			mv.addObject("li", li);
			return mv;
		}
		
		@RequestMapping(value="deletep",method=RequestMethod.POST)
		public ModelAndView deleteuser(HttpServletRequest req) {
			ModelAndView mv=new ModelAndView("viewproductA");
			int productid=Integer.parseInt(req.getParameter("pid"));
			pb.deleteProduct(productid);
			int uid=Integer.parseInt(req.getParameter("uid"));
			List<Product> li=pb.getproductbyuid(uid);
			mv.addObject("li", li);
			return mv;
		}
		
		
}
