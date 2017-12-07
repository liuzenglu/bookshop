package com.xiaotan.webshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.bean.Orders;
import com.xiaotan.webshop.bean.Users;
import com.xiaotan.webshop.service.BookService;
import com.xiaotan.webshop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@RequestMapping("/userlist")
	public String userlist(Model model) {
		System.out.println("jion userlist");
		List<Users> list = userService.findAll();
		model.addAttribute("userlist", list);
		System.out.println(list.get(0).getUser_username());
		return "BackEnd/index";
	}

	@RequestMapping("/deleteUser")
	public String deleteBook(Integer user_id) {
		System.out.println(user_id);
		boolean b = userService.deleteUser(user_id);
		if (b) {
			return "redirect:userlist.do";
		} else {
			return "";
		}
	}

	@RequestMapping("/selectUser")
	public String someOnelist(Model model, String user) {
		System.out.println(user);
		List<Users> userlist = userService.findUserOrder(user);
		System.out.println();
		List<Orders> list = new ArrayList<Orders>();
		for (int i = 0; i < userlist.size(); i++) {
			userlist.get(i).getUser_username();
			Iterator<Orders> it = userlist.get(i).getOrdersSet().iterator();
			while (it.hasNext()) {
				list.add(it.next());
			}
		}

		model.addAttribute("orderlist", list);

		return "BackEnd/index";
	}
	
	
	@RequestMapping("/login")
	public String willLogin(Model model,String username,String password,HttpServletRequest request) {
		System.out.println(username+password);
		Users user = userService.login(username,password);
		if(user != null) {
			request.getSession().setAttribute("user", user);
			return "redirect:../book/someBooklist.do";
		}else {
			return "error";
		}
	}
	
	
	@RequestMapping("/loginUsername")
	public void loginUsername(Model model,String user_username,HttpServletResponse response) throws IOException {
		System.out.println(user_username);
		boolean b = userService.loginUsername(user_username);
		String result = null;
		if(b) {
			result = "<font color='red'>该用户名已经被使用</font>";
		}else {
			result = "<font color='green'>该用户名可以被使用</font>";
		}
		response.setContentType("text/html");
		response.getWriter().print(result);
	}
	// ========================================================================
	 @RequestMapping("/register")
	 public String register(Users user,Model model) {
		 user.setPosttime(new Date());
		 boolean result = userService.register(user);
		 if(result) {
			 model.addAttribute("registeruser",user);
			 return "BookStore/register";
		 }else {
			 model.addAttribute("errormsg", "ע��ʧ��");
			 return "register";
		 }
		
	 }

}
