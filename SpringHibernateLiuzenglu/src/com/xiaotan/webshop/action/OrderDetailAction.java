package com.xiaotan.webshop.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.bean.BookType;
import com.xiaotan.webshop.bean.Order_detail;
import com.xiaotan.webshop.bean.Orders;
import com.xiaotan.webshop.service.BookService;
import com.xiaotan.webshop.service.BookTypeService;
import com.xiaotan.webshop.service.OrderDetailService;
import com.xiaotan.webshop.service.OrderService;

@Controller
public class OrderDetailAction {
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping("/orderdetail")
	public String userlist(Model model,Integer order_id) {
		System.out.println("jion orderDetaillist");
		List<Order_detail> list = orderDetailService.findAll(order_id);
		model.addAttribute("orderDetaillist",list);
		return "BackEnd/index";
	}
//	//=======删除一本书=================================================================
//	@RequestMapping("/deleteOneBook")
//	public String deleteBook(Integer book_id) {
//		System.out.println(book_id);
//		boolean b = bookService.deleteBook(book_id);
//		if(b) {
//			return "redirect:booklist.do";
//		}else {
//			return "";
//		}
//	}
//	//==========================================================
//	@RequestMapping("addBookAddAttribute")
//	public String updateAttribute(Model model) {
//		model.addAttribute("addBook","addBook");
//		return "BackEnd/index";
//	}
//	@RequestMapping("/addBook")
//	public String addBook(Model model, HttpServletRequest request, String book_name,
//			String book_author,String book_description,String book_publisher,
//			Double book_price,String type_name, 
//			@RequestParam MultipartFile book_imgurl)throws IOException {
//		System.out.println("join AddBook");
//		ServletContext context = request.getServletContext();	
//		Book book = new Book();
//		if (book_imgurl != null) {
//			String realPath = context.getRealPath("/uploadimg");
//			String filename = book_imgurl.getOriginalFilename();
//			File file = new File(realPath + "/" + filename);			
//			book.setBook_imgurl("uploadimg/" + filename);
//			byte[] bytes = book_imgurl.getBytes();
//			FileOutputStream fos = new FileOutputStream(file);
//			fos.write(bytes);
//			fos.flush();
//			fos.close();
//		}
//		book.setBook_name(book_name);
//		book.setBook_author(book_author);
//		book.setBook_description(book_description);
//		book.setBook_publisher(book_publisher);
//		book.setBook_price(book_price);
//		BookType bookType = bookTypeService.select(type_name);
//		book.setBookType(bookType);		
//		boolean b = bookService.addBook(book);
//		if(b) {
//			model.addAttribute("addBooktrue","增加图书成功");
//			return "BackEnd/index";
//		}else {
//			return "error";
//		}
//			
//	}
//	//==============查询一本书之后会更新==================================================
//	@RequestMapping("/selectOneBookUpdate")
//	public String selectOneBook(Integer book_id,Model model) {
//		System.out.println(book_id+"更新");
//		Book book = bookService.selectBook(book_id);
//		if(book != null) {
//			model.addAttribute("book",book);
//			return "BackEnd/index";
//		}else {
//			return "";
//		}
//	}
//	
//	@RequestMapping("/updateBook")
//	public String updateBook(Model model, HttpServletRequest request,Integer book_id, String book_name,
//			String book_author,String book_description,String book_publisher,
//			Double book_price,String type_name, 
//			@RequestParam MultipartFile book_imgurl)throws IOException {
//		System.out.println("join updateBook");
//		System.out.println(book_name+
//			book_author+book_description+book_publisher+book_price+type_name);
//		ServletContext context = request.getServletContext();	
//		Book book = new Book();
//		if (book_imgurl != null) {
//			String realPath = context.getRealPath("/uploadimg");
//			String filename = book_imgurl.getOriginalFilename();
//			File file = new File(realPath + "/" + filename);			
//			book.setBook_imgurl("uploadimg/" + filename);
//			byte[] bytes = book_imgurl.getBytes();
//			FileOutputStream fos = new FileOutputStream(file);
//			fos.write(bytes);
//			fos.flush();
//			fos.close();
//		}
//		book.setBook_id(book_id);
//		book.setBook_name(book_name);
//		book.setBook_author(book_author);
//		book.setBook_description(book_description);
//		book.setBook_publisher(book_publisher);
//		book.setBook_price(book_price);
//		BookType bookType = bookTypeService.select(type_name);
//		book.setBookType(bookType);
//				
//		boolean b = bookService.updateBook(book);
//		if(b) {
//			model.addAttribute("updateBooktrue","修改图书成功");
//			return "BackEnd/index";
//		}else {
//			return "error";
//		}
//			
//	}
//	@RequestMapping("/register")
//	public String register(Users user,Model model) {
//		boolean result = userService.register(user);
//		if(result) {
//			return "redirect:userlist.do";
//		}else {
//			model.addAttribute("errormsg", "ע��ʧ��");
//			return "register";
//		}
//		
//	}

}
