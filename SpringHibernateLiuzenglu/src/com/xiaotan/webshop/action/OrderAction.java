package com.xiaotan.webshop.action;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.bean.OrderState;
import com.xiaotan.webshop.bean.Order_detail;
import com.xiaotan.webshop.bean.Orders;
import com.xiaotan.webshop.bean.Users;
import com.xiaotan.webshop.service.BookService;
import com.xiaotan.webshop.service.OrderService;
import com.xiaotan.webshop.service.OrderStateService;

@Controller
@RequestMapping("/order")
public class OrderAction {
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderStateService orderStateService;
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/orderlist")
	public String orderlist(Model model) {
		System.out.println("jion orderlist");
		List<Orders> list = orderService.findAll();
		model.addAttribute("orderlist",list);
		return "BackEnd/index";
	}
	
	@RequestMapping("/cart")
	public String lookCart(HttpServletRequest request) {
		Users user = (Users) request.getSession().getAttribute("user");
		if(user == null) {
			return "BookStore/myaccount";
		}
		return "BookStore/cart";
	}
	
	@RequestMapping("/addorder")
	public String addorder(Model model,HttpServletRequest request) {
		System.out.println("jion addorder");
		List<Book> booklist  = (List<Book>) request.getSession().getAttribute("cartbooklist");
//		Map<Book,Integer> map = new HashMap<Book, Integer>();
//		for(int i = 0 ; i<booklist.size();i++) {
//			Integer bookCount = 0;
//			map.put(booklist.get(i), bookCount++);
//			if(booklist.get(i) == booklist.get(i+1)) {
//				
//			}
//		}
//		for(Book book: booklist){
//			if(map.containsKey(book)){
//				System.out.println(book.getBook_id()+"一本书的ID");
//				map.put(book, map.get(book).intValue() + 1);
//			}else{
//				System.out.println("增加一本书");
//				map.put(book, 1);
//			}
//		}
//		for (Book book : map.keySet()) {
//			   System.out.println("key= "+ book.getBook_id() + " and value= " + map.get(book));
//			  }
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(Book book: booklist){
			if(map.containsKey(book.getBook_id())){
				//System.out.println(book.getBook_id()+"一本书的ID");
				map.put(book.getBook_id(), map.get(book.getBook_id()).intValue() + 1);
			}else{
				//System.out.println("增加一本书d Id");
				map.put(book.getBook_id(), 1);
			}
		}
//		for (Integer i : map.keySet()) {
//		   System.out.println("key= "+ i + " and value= " + map.get(i));
//		}
		Orders order = new Orders();
		//==============================
		order.setOrder_time(new Date());
		//================================
		Users user = (Users) request.getSession().getAttribute("user");
		order.setUser(user);
		//=====================================
		System.out.println("准备orderstateService");
		OrderState orderstate = orderStateService.selectIdIsOne();
		System.out.println("OrderStateid:"+orderstate.getOrderState_id());
		order.setOrderstate(orderstate);
		//=============================================
		Set<Order_detail> orderDetailsSet =  new HashSet<>();
		for(Integer book_id :map.keySet()) {
			Order_detail order_detail = new Order_detail();
			order_detail.setOrder(order);
			order_detail.setBook(bookService.findOneBook(book_id));
			order_detail.setCount(map.get(book_id));
			orderDetailsSet.add(order_detail);
		}
		model.addAttribute("orderDetailsSet",orderDetailsSet);
		order.setOrderDetailsSet(orderDetailsSet);
		boolean b = orderService.insertOrder(order);
		if(b) {
			model.addAttribute("order_id",order.getOrder_id());
			System.out.println("order_id+::::"+order.getOrder_id());
			return "BookStore/index";
		}
		return "error";
	}

	
	//=======删除一个订单=================================================================
	@RequestMapping("/deleteOrder")
	public String deleteOrder(Integer order_id) {
		System.out.println(order_id);
		boolean b = orderService.deleteOrder(order_id);
		if(b) {
			return "redirect:orderlist.do";
		}else {
			return "";
		}
	}
	@RequestMapping("/deleteOneOrder")
	public String deleteOneOrder(Integer order_id,HttpServletRequest request) {
		request.getSession().removeAttribute("cartbooklist");
		request.getSession().removeAttribute("sum");
		request.getSession().removeAttribute("count");
		System.out.println(order_id);
		boolean b = orderService.deleteOrder(order_id);
		if(b) {
			return "redirect:../book/someBooklist.do";
		}else {
			return "";
		}
	}
	@RequestMapping("/pay")
	public String confirmPay(Integer order_id,HttpServletRequest request,Model model) {
		Double summony  = (Double) request.getSession().getAttribute("sum");
		model.addAttribute("summony",summony);
		request.getSession().removeAttribute("cartbooklist");
		request.getSession().setAttribute("sum", 0.0);
		request.getSession().setAttribute("count", 0);
		System.out.println(order_id);
		boolean b = orderService.payOrder(order_id);
		if(b) {
			return "BookStore/index";
		}else {
			return "";
		}
	}
//	//==========================================================


}
