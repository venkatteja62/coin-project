package com.mphasis.CoinProject.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.CoinProject.Bo.ProductBo;
import com.mphasis.CoinProject.Bo.UserBo;
import com.mphasis.CoinProject.model.Product;
import com.mphasis.CoinProject.model.User;

@RestController

public class ProductController {
	
	@Autowired
	ProductBo pb;
	
	@Autowired
	UserBo ub;
	
	
	
	@RequestMapping("addproducts")
	public ModelAndView addproductfirstMethod(HttpServletRequest req)
	{
		HttpSession us = req.getSession();
		Integer id =  (Integer) us.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			HttpSession s1 = req.getSession(true);
			 
			 ModelAndView mv=null;
			 UserBo ub=new UserBo();
			String s=ub.getcString();
			System.out.println(s);
			 s1.setAttribute("s",s);
			 
			mv=new ModelAndView("login");
		
			return mv;
		}
		return new ModelAndView("addproduct");
	}

	@RequestMapping(value="insertproduct",method=RequestMethod.POST)
	public ModelAndView insertproductmethod(HttpServletRequest req)
	{
		String c = req.getParameter("pcategory");
		
		double price = Double.parseDouble(req.getParameter("pprice"));
		String pname = req.getParameter("pname");
		String pd = req.getParameter("pdescription");
		String ps = req.getParameter("pstock");
		String pp = req.getParameter("pperiod");
		String pm = "User Product";
		int pq =Integer.parseInt( req.getParameter("pquantity"));
		System.out.println(c+" "+price+" "+pname+" "+pd+" "+ps+" "+pp+" "+pm+" "+pq);
		int id=Integer.parseInt( req.getParameter("id"));
		System.out.println(id);
		List <User>li=ub.getUserbyId(id);
		for(User u:li) {
		if(u.getUserEmail().equals("harshavasireddy66@gmail.com")) {
			pm="Admin Product";
		}
		}
		
		@SuppressWarnings("unused")
		boolean b=false;
		@SuppressWarnings("unused")
		String utype="Product";
		Product p=new Product(0,c,price,pname,pd,ps,pp,pm,pq,id);
		b=pb.insertProduct(p);
		if(b=true) {
		return new ModelAndView("loginsuccess");
		}
		else {
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("/viewallproduct")
	public ModelAndView viewExams(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("viewallproduct");
		HttpSession us = req.getSession();
		Integer id =  (Integer) us.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			HttpSession s1 = req.getSession(true);
			UserBo ub=new UserBo();
			String s=ub.getcString();
			System.out.println(s);
			 s1.setAttribute("s",s);
			 
			mv=new ModelAndView("login");
		
			return mv;
		}
		System.out.println(id);
		List<Product> li=pb.getproductnotbyuid(id);
		for(Product p:li) {
			System.out.println(p);
		}
		mv.addObject("li", li);
		return mv;
	}
	
	@RequestMapping("/viewallp")
	public ModelAndView viewproducts(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("viewallp");
		List<Product> li=pb.getAllProduct();
		for(Product p:li) {
			System.out.println(p);
		}
		mv.addObject("li", li);
		return mv;
	}
	
	
	
	
	@RequestMapping(value="editproduct",method=RequestMethod.POST)
	public ModelAndView updateproductmethod(HttpServletRequest req)
	{
		String c = req.getParameter("pcategory");
		int  pid =Integer.parseInt( req.getParameter("pid")); 
		double price = Double.parseDouble(req.getParameter("pprice"));
		String pname = req.getParameter("pname");
		String pd = req.getParameter("pdescription");
		String ps = req.getParameter("pstock");
		String pp = req.getParameter("pperiod");
		String pm="User Product";
		int pq =Integer.parseInt( req.getParameter("pquantity"));
		System.out.println(c+" "+price+" "+pname+" "+pd+" "+ps+" "+pp+" "+pm+" "+pq);
		int uid=Integer.parseInt( req.getParameter("uid"));
		System.out.println(uid);
		if(uid==10) {
			pm="Admin Product";
		}
		@SuppressWarnings("unused")
		boolean b=false;
		@SuppressWarnings("unused")
		String utype="Product";
		Product p=new Product(pid,c,price,pname,pd,ps,pp,pm,pq,uid);
		b=pb.updateProduct(p);
		if(b=true) {
		return new ModelAndView("adminpage");
		}
		else {
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping(value="edituproduct",method=RequestMethod.POST)
	public ModelAndView updateproductusermethod(HttpServletRequest req)
	{
		String c = req.getParameter("pcategory");
		int  pid =Integer.parseInt( req.getParameter("pid")); 
		double price = Double.parseDouble(req.getParameter("pprice"));
		String pname = req.getParameter("pname");
		String pd = req.getParameter("pdescription");
		String ps = req.getParameter("pstock");
		String pp = req.getParameter("pperiod");
		String pm = req.getParameter("pmaterial");
		int pq =Integer.parseInt( req.getParameter("pquantity"));
		System.out.println(c+" "+price+" "+pname+" "+pd+" "+ps+" "+pp+" "+pm+" "+pq);
		int uid=Integer.parseInt( req.getParameter("uid"));
		System.out.println(uid);
		@SuppressWarnings("unused")
		boolean b=false;
		@SuppressWarnings("unused")
		String utype="Product";
		Product p=new Product(pid,c,price,pname,pd,ps,pp,pm,pq,uid);
		b=pb.updateProduct(p);
		if(b=true) {
		return new ModelAndView("loginsuccess");
		}
		else {
			return new ModelAndView("error");
		}
	}
	
	
}
