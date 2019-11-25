package com.mphasis.CoinProject.controller;

import java.io.IOException;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class UserController {
	
	@Autowired
	UserBo ub;
	
	@Autowired
	ProductBo pb;

	
	@RequestMapping("/")
	public ModelAndView firstMethod()
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping("home")
	public ModelAndView some() {
		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/register")
	public ModelAndView secondMethod()
	{
		return new ModelAndView("register");
	}
	
	@RequestMapping("/login")
	public ModelAndView loginmethod(HttpServletRequest req)
	{
		HttpSession s1 = req.getSession(true);
		 
		 ModelAndView mv=null;
		String s=ub.getcString();
		System.out.println(s);
		 s1.setAttribute("s",s);
		 
		mv=new ModelAndView("login");
	
		return mv;
	}
	/*
	@RequestMapping(value="insertuser" , method = RequestMethod.POST)
	public ModelAndView thirdMethod(HttpServletRequest req) {
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
		DateTimeFormatter f1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate udob=LocalDate.parse(dob, f1);
		
		
		
		
		
		@SuppressWarnings("unused")
		String utype="User";
		if(pass.equals(cpass)) {
		User u=new User(0,name,email,mobile,pass,cpass,udob,gender,squestion,answer,city);
		ub.insertUser(u);
		return new ModelAndView("registersuccess");
		}
		else
		{
			return new ModelAndView("error");
		}
	}*/
	
	
	@RequestMapping(value = "insertuser", method =RequestMethod.POST)
    public ModelAndView thirdmethod(HttpServletRequest req)
    {
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
		DateTimeFormatter f1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate udob=LocalDate.parse(dob, f1);
	 
	
	  HttpSession s1 = req.getSession(true);
	  s1.setAttribute("name",name);
	  s1.setAttribute("email",email);
	  s1.setAttribute("pass",pass);
	  s1.setAttribute("mobile",mobile);
	  s1.setAttribute("cpass",cpass);
	  s1.setAttribute("dob",udob);
	  s1.setAttribute("gender",gender);
	  s1.setAttribute("squestion",squestion);
	  s1.setAttribute("answer",answer);
	  s1.setAttribute("city",city);
	 
	
		Random ran = new Random();
		int maxrange = 654321 , minrange =123456;
		int ramvalue = ran.nextInt(maxrange - minrange)+minrange;
		String otp = Integer.toString(ramvalue);
		s1.setAttribute("otp",otp);
		try 
		{
			String fromEmail="harshavasireddy66@gmail.com"; //sender's mail id.
			String pwd="9581810860";		//sender's mail pwd.
			String toEmail=email;  //reciever's mail id.
			String subject="DO NOT REPLY:  Otp for email Verification"; // mail subject line
			String msg="Hi "+name+" your otp is : "+otp; //mail body		
			//Creating Session Object
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
					return new PasswordAuthentication(fromEmail, pwd);
				}
			});
			//Composing the Mail
			MimeMessage mesg = new MimeMessage(session);
			mesg.setFrom(new InternetAddress(fromEmail));
			mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			mesg.setSubject(subject);  
			mesg.setText(msg);  	
			//Sending the Mail
			Transport.send(mesg);
			System.out.println("sent!!!");
			return new ModelAndView("otpform");
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ModelAndView("error");
		}	
		
		
    }
 
    @RequestMapping(value = "/otpconfirm", method =RequestMethod.POST)
    public ModelAndView fourthmethod(HttpServletRequest request , HttpServletResponse response) throws IOException
    {

		String s = request.getParameter("s");
		HttpSession s1 = request.getSession();
		String s2 =  (String) s1.getAttribute("otp");
		String v1 =  (String) s1.getAttribute("name");
		String v2 =  (String) s1.getAttribute("email");
		String v3 =  (String) s1.getAttribute("mobile");
		String v4 =  (String) s1.getAttribute("pass");
		String v5 =  (String) s1.getAttribute("cpass");
		LocalDate v6 =  (LocalDate)s1.getAttribute("dob");
		String v7 =  (String) s1.getAttribute("gender");
		String v8 =  (String) s1.getAttribute("squestion");
		String v9 =  (String) s1.getAttribute("answer");
		String v10 =  (String) s1.getAttribute("city");
		
		System.out.println(s+" "+s2);
		
		System.out.println(v4+" "+v5);
		
		
		if (s.equals(s2))
		{
			
			User u = new User(0,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10);
			ub.insertUser(u);
			return new ModelAndView("registersuccess");
			
		} 
		return new ModelAndView("error");
		
    }
    
    @RequestMapping(value="forgotemail",method=RequestMethod.POST)
    public ModelAndView forgotEmailMethod(HttpServletRequest req) {
    	
    	String email=req.getParameter("id");
    	HttpSession s1 = req.getSession(true);
    	
    	List<User>li=ub.getUserbymail(email);
    	System.out.println(li);
    	for(User u:li) {
    		if(email.equals(u.getUserEmail())) {
    			
    	
    	int id=u.getUserID();
    	Random ran = new Random();
		int maxrange = 654321 , minrange =123456;
		int ramvalue = ran.nextInt(maxrange - minrange)+minrange;
		String otp = Integer.toString(ramvalue);
		s1.setAttribute("otp",otp);
		s1.setAttribute("id",id);
		try 
		{
			String fromEmail="harshavasireddy66@gmail.com"; //sender's mail id.
			String pwd="9581810860";		//sender's mail pwd.
			String toEmail=email;  //reciever's mail id.
			String subject="DO NOT REPLY:  Otp for email Verification"; // mail subject line
			String msg="Password Reset otp is : "+otp; //mail body		
			//Creating Session Object
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", 587);
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
			{
				protected PasswordAuthentication getPasswordAuthentication()
				{
					//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
					return new PasswordAuthentication(fromEmail, pwd);
				}
			});
			//Composing the Mail
			MimeMessage mesg = new MimeMessage(session);
			mesg.setFrom(new InternetAddress(fromEmail));
			mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
			mesg.setSubject(subject);  
			mesg.setText(msg);  	
			//Sending the Mail
			Transport.send(mesg);
			System.out.println("sent!!!");
			return new ModelAndView("forgototp");
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return new ModelAndView("error");
		}	
    		}
    		    			
    		
    	}
    	return new ModelAndView("error");
    	
    	
    }
    
    
    @RequestMapping(value="forgototpconfirm" , method = RequestMethod.POST)
	public ModelAndView confirmotpMethod(HttpServletRequest req) {
    	
    	String s = req.getParameter("s");
		HttpSession s1 = req.getSession();
		String s2 =  (String) s1.getAttribute("otp");
		System.out.println(s+" "+s2);
    	if(s.equals(s2)) {
    	return new ModelAndView("updatepass");
    	}
    	return new ModelAndView("error");
    	}
	
	
	@RequestMapping(value="loginuser" , method = RequestMethod.POST)
	public ModelAndView fourthMethod(HttpServletRequest req) {
		HttpSession s1 = req.getSession();
		String s2 =  (String) s1.getAttribute("s");
		System.out.println(s2);
		String username=req.getParameter("uname");
		System.out.println(username);
		String upass=req.getParameter("upass");
		System.out.println(upass);
		String s=req.getParameter("s");
		System.out.println(s);
		
		if(s.equals(s2)) {
		List <User> li=ub.getAllUser();
		
		for(User u:li)
		{
			if(u.getUserMobile().equals(username)||u.getUserEmail().equals(username)) {
				if(u.getPassword().equals(upass)) {
					HttpSession us = req.getSession(true);
					int id=u.getUserID();
					us.setAttribute("id", id);
					String name=u.getUserName();
					us.setAttribute("name", name);
					if(username.equals("thenickel1122@gmail.com") && upass.equals("thenickel")) {
						return new ModelAndView("adminpage");
					}
					return new ModelAndView("loginsuccess");
				}
			}
		}
		}
		return new ModelAndView("error");
		
	}
	
	@RequestMapping("/forgot")
	public ModelAndView forgotmethod()
	{
		return new ModelAndView("forgot");
	}
	
	@RequestMapping(value="ForgotServlet", method=RequestMethod.POST)
	public ModelAndView forgotsmethod(HttpServletRequest req)
	{
		String username=req.getParameter("id");
		List <User> li=ub.getAllUser();
		for(User u:li)
		{
			if(u.getUserMobile().equals(username)||u.getUserEmail().equals(username)) {
					
					return new ModelAndView("forgot1");
				
			}
		}
		
		
		return new ModelAndView("errorpage");
	}
	
	@RequestMapping(value="Forgot1Servlet" , method = RequestMethod.POST)
	public ModelAndView forgot1method(HttpServletRequest req)
	{
		HttpSession s1 = req.getSession(true);
		
		String mob=req.getParameter("id");
		String dob=req.getParameter("name");
		String ans=req.getParameter("name1");
		
		List <User>li=ub.getUser(mob);
		
		for(User u:li) {
		String dob1=u.getUserDOB().toString();
		if((dob1.equals(dob))&&(u.getAnswer().equals(ans))) {
			int id=u.getUserID();
			s1.setAttribute("id", id);
			
			return new ModelAndView("updatepass");
		}
			else {
				return new ModelAndView("error");
			}
		}
		return new ModelAndView("error");
		
			
		
	}
	
	@RequestMapping(value="updatesuccess",method=RequestMethod.POST)
	public ModelAndView updatepass(HttpServletRequest req) {
		HttpSession s1 = req.getSession();
		int id =  (Integer) s1.getAttribute("id");
		String pass=req.getParameter("pass");
		String pass1=req.getParameter("pass1");
		//String mob=req.getParameter("id");
		System.out.println(id);
		@SuppressWarnings("unused")
		boolean b=false;
		if(pass.equals(pass1)) {
			b=ub.updatepass(pass,id);
			if(b=true) {
				return new ModelAndView("updatesuccess");
			}
		}
		return new ModelAndView("errorpage");
		
	}
	
	
	@RequestMapping("editu")
	public ModelAndView editUserMethod(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("edituser");
		Integer id=Integer.parseInt(req.getParameter("uid"));
		if(id.equals(null)) {
		HttpSession ss = req.getSession();
		 id =  (Integer) ss.getAttribute("id");}
		List<User> li=ub.getUserbyId(id);
		mv.addObject("li", li);
		System.out.println(li);
		return mv;
	}
	
	@RequestMapping("editp")
	public ModelAndView editProductMethod() {
		ModelAndView mv=new ModelAndView("editproduct");
		List<Product> li=pb.getAllProduct();
		System.out.println(li);
		mv.addObject("li", li);
		return mv;
	}
	
	
}
