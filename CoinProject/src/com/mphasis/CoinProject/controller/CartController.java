package com.mphasis.CoinProject.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.CoinProject.Bo.CartBo;
import com.mphasis.CoinProject.Bo.OrdersBo;
import com.mphasis.CoinProject.Bo.ProductBo;
import com.mphasis.CoinProject.Bo.UserBo;
import com.mphasis.CoinProject.model.Cart;
import com.mphasis.CoinProject.model.Orders;
import com.mphasis.CoinProject.model.Product;
import com.mphasis.CoinProject.model.User;


@RestController
public class CartController {
	
	@Autowired
	CartBo cb;
	
	@Autowired
	OrdersBo ob;
	
	@Autowired
	ProductBo pb;
	
	@Autowired
	UserBo ub;
	
	@RequestMapping("/paymentsuccess")
	public ModelAndView raMethod()
	{
		return new ModelAndView("vieworders");
	}
	
	@RequestMapping("/cart")
	public ModelAndView randomMethod()
	{
		return new ModelAndView("cart");
	}
	
	@RequestMapping("/buy")
	public ModelAndView buyMethod()
	{
		return new ModelAndView("buy");
	}
	
	@RequestMapping(value="insertcart",method=RequestMethod.POST)
	public ModelAndView cartMethod(HttpServletRequest req)
	{
		int pid=Integer.parseInt(req.getParameter("pid"));
		ModelAndView mv=new ModelAndView("viewcart");
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
		List <Cart> li=cb.getallcart();
		for(Cart c:li) {
			if((c.getBuyerID()==(id))&&(c.getProductID()==(pid))) {
				List<Cart> li1=cb.getproductbyuid(id);
				for(Cart p:li1) {
					System.out.println(p);
				}
				 mv=new ModelAndView("viewcart");
				mv.addObject("li", li1);
				return mv;
			}
		}
		return new ModelAndView("cart");
	}
	
	@RequestMapping(value="editquantity",method=RequestMethod.POST)
	public ModelAndView cartqMethod(HttpServletRequest req)
	{
		return new ModelAndView("cart");
	}
	
	@RequestMapping(value="insertintocart", method=RequestMethod.POST)
	public ModelAndView secondMethod(HttpServletRequest request) 
	{

		ModelAndView mv1= null;
		String productName = request.getParameter("productname");
		int sellerId = Integer.parseInt(request.getParameter("sellerid"));
		int productId= Integer.parseInt(request.getParameter("productid"));
		int buyerId = Integer.parseInt(request.getParameter("buyerid"));
		int quantity= Integer.parseInt(request.getParameter("quantity"));
		double price = Double.parseDouble(request.getParameter("productprice"));
		price=(double)price*quantity;
		System.out.println(productName+" "+sellerId+" "+productId+" "+buyerId+" "+quantity+" "+price);
		Cart c=new Cart(100,productId,buyerId,productName,quantity,price,sellerId);
		cb.insertO(c);
		List <User>li=ub.getUserbyId(buyerId);
		for(User u:li) {
		if(u.getUserEmail().equals("harshavasireddy66@gmail.com")) {
			mv1= new ModelAndView("adminpage");
			return mv1;
		}
		}
		mv1= new ModelAndView("loginsuccess");
	return mv1;

	}
	
	@RequestMapping("/viewcart")
	public ModelAndView viewExams(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("viewcart");
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
		List<Cart> li=cb.getproductbyuid(id);
		for(Cart p:li) {
			System.out.println(p);
		}
		mv.addObject("li", li);
		return mv;
	}
	@RequestMapping(value="deletecart",method=RequestMethod.POST)
	public ModelAndView deletecart(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("viewcart");
		int cartid=Integer.parseInt(req.getParameter("cartid"));
		cb.deletecart(cartid);
		int uid=Integer.parseInt(req.getParameter("uid"));
		List<Cart> li=cb.getproductbyuid(uid);
		mv.addObject("li", li);
		return mv;
	}
	
	@RequestMapping(value="buycoin",method=RequestMethod.POST)
	public ModelAndView buycart(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("payment");		
		int uid=Integer.parseInt(req.getParameter("uid"));
		List<Cart> li=cb.getproductbyuid(uid);
		double d=0;
		for(Cart c:li) {

			d=d+c.getPrice();
			System.out.println(d);
		}
		System.out.println(d);
		mv.addObject("d", d);
		
		return mv;
	}
	
	@RequestMapping(value="paymentsuccess",method=RequestMethod.POST)
	public ModelAndView paymentsuccess(HttpServletRequest req) {
		ModelAndView mv=new ModelAndView("viewordersuser");
		HttpSession s1 = req.getSession();
		int uid =  (int) s1.getAttribute("id");
		List<Cart> lic=cb.getproductbyuid(uid);
		for(Cart c:lic) {
			int pid=c.getProductID();
			List<Product> lip=pb.getProductbypid(pid);
			for(Product p:lip) {
				LocalDate no = LocalDate.now();
				String date=no.toString();
				double price=p.getPrice();
				String pn=c.getProductname();
				int sid=p.getUserId();
				String com="good";
				String st="start";
				String pm="tran no";
				int q=c.getQuantity();
				System.out.println(pid+" "+price+" "+pn+" "+date+" "+uid+" "+sid+" "+com+" "+st+" "+pm+" "+q);
				Orders o=new Orders(1,pid,price,pn,date,uid,sid,com,st,pm,q);
				ob.insertO(o);
				
				String category=p.getCategory();
				String description=p.getDescription();
				String stock=p.getStock();
				String period=p.getPeriod();
				String company=p.getCompany();
				int qu=p.getQuantity();
				qu=qu-q;
				System.out.println(qu);
				Product pc=new Product(pid,category,price,pn,description,stock,period,company,qu,sid);
				pb.updateProduct(pc);
			
				}
			int cd=c.getCartID();
			cb.deletecart(cd);
			
		}
		return mv;
		
	}
	
}
