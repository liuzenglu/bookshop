package com.xiaotan.webshop.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.bean.BookState;
import com.xiaotan.webshop.bean.BookType;
import com.xiaotan.webshop.bean.Users;
import com.xiaotan.webshop.service.BookService;
import com.xiaotan.webshop.service.BookStateService;
import com.xiaotan.webshop.service.BookTypeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

@Controller
@RequestMapping("/book")
public class BookAction {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookTypeService bookTypeService;
	@Autowired
	private BookStateService bookStateService;

	@RequestMapping("/booklist")
	public String booklist(Model model,Integer pages) {
		System.out.println("jion booklist");

		Integer totalpages = bookService.selectTotalpages();
		if (pages == null) { 
	        pages = 1;
	    } else {
	        if (pages < 1){
	            pages = 1;
	        }
	        if (pages > totalpages){
	            pages = totalpages;
	        }                            
	    }
		List<Book> list = bookService.findAll(pages);
		model.addAttribute("totalpages",totalpages);
		model.addAttribute("pages",pages);
		model.addAttribute("allbooklist", list);
		return "BackEnd/index";
	}

	// =======删除一本书=================================================================
	@RequestMapping("/deleteOneBook")
	public String deleteBook(Integer book_id) {
		System.out.println(book_id);
		boolean b = bookService.deleteBook(book_id);
		if (b) {
			return "redirect:booklist.do";
		} else {
			return "";
		}
	}

	// ==========================================================
	@RequestMapping("addBookAddAttribute")
	public String updateAttribute(Model model) {
		List<BookType> addBookAndDisplayBookType = bookTypeService.findAllType();
		model.addAttribute("addBookAndDisplayBookType", addBookAndDisplayBookType);
		List<BookState> addBookAndDisplayBookState = bookStateService.findAllState();
		model.addAttribute("addBookAndDisplayBookState", addBookAndDisplayBookState);
		return "BackEnd/index";
	}

	@RequestMapping("/addBook")
	public String addBook(Model model, HttpServletRequest request, String book_name, String book_author,
			String book_description, String book_publisher, Double book_price, String type_name,
			String[] bookState_name, @RequestParam MultipartFile book_imgurl) throws IOException {
		System.out.println("join AddBook");
		System.out.println(bookState_name.toString());
		ServletContext context = request.getServletContext();
		Book book = new Book();
		if (book_imgurl != null) {
			String realPath = context.getRealPath("/uploadimg");
			String filename = book_imgurl.getOriginalFilename();
			File file = new File(realPath + "/" + filename);
			book.setBook_imgurl("uploadimg/" + filename);
			byte[] bytes = book_imgurl.getBytes();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);
			fos.flush();
			fos.close();
		}
		book.setBook_name(book_name);
		book.setBook_author(book_author);
		book.setBook_description(book_description);
		book.setBook_publisher(book_publisher);
		book.setBook_price(book_price);
		BookType bookType = bookTypeService.select(type_name);
		book.setBookType(bookType);
		List<BookState> bookStateList = new ArrayList<BookState>();
		for (int i = 0; i < bookState_name.length; i++) {
			BookState bookState = bookStateService.select(bookState_name[i]);
			bookStateList.add(bookState);
		}
		book.setBookStateList(bookStateList);
		// BookState bookState = BookStateService.
		boolean b = bookService.addBook(book);
		if (b) {
			model.addAttribute("addBooktrue", "增加图书成功");
			return "BackEnd/index";
		} else {
			return "error";
		}

	}

	// ==============查询一本书之后会更新==================================================
	@RequestMapping("/selectOneBookUpdate")
	public String selectOneBook(Integer book_id, Model model) {
		System.out.println(book_id + "更新");
		Book book = bookService.selectBook(book_id);
		List<BookState> onebookState1  = book.getBookStateList();
		
		List<BookType> bookTypelist = bookTypeService.findAllType();
		List<String> bookTypeName = new ArrayList<String>();
		for (BookType i : bookTypelist) {
			bookTypeName.add(i.getType_name().toString());
		}

		List<BookState> allbookState2 = bookStateService.findAllState();
		model.addAttribute("allbookState2", allbookState2);
		model.addAttribute("book", book);
		model.addAttribute("bookTypelist", bookTypeName);
		model.addAttribute("onebookState1", onebookState1);
		System.out.println(onebookState1.size()+"---------------");
		System.out.println();
		return "BackEnd/index";
		
	}

	@RequestMapping("/updateBook")
	public String updateBook(Model model, HttpServletRequest request, Integer book_id, String book_name,
			String book_author, String book_description, String book_publisher, 
			Double book_price,Integer [] bookState_id,
			@RequestParam MultipartFile book_imgurl) throws IOException {
		System.out.println("join updateBook");
		 for(Integer t: bookState_id){  
	            System.out.println(t+"afhkafjklajflajflkafjalffffffffffffffffff");  
	        }  
		
		String type_name = request.getParameter("bookType.type_name");
		System.out.println(
				book_name + book_author + book_description + book_publisher + book_price + book_imgurl + type_name);
		ServletContext context = request.getServletContext();
		Book book = new Book();
		if (book_imgurl != null) {
			String realPath = context.getRealPath("/uploadimg");
			String filename = book_imgurl.getOriginalFilename();
			File file = new File(realPath + "/" + filename);
			book.setBook_imgurl("uploadimg/" + filename);
			byte[] bytes = book_imgurl.getBytes();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);
			fos.flush();
			fos.close();
		}
		book.setBook_id(book_id);
		book.setBook_name(book_name);
		book.setBook_author(book_author);
		book.setBook_description(book_description);
		book.setBook_publisher(book_publisher);
		book.setBook_price(book_price);
		BookType bookType = bookTypeService.select(type_name);
		book.setBookType(bookType);
		List<BookState> bookStateList = new ArrayList<BookState>();
		for(Integer i :bookState_id) {
			System.out.println(i);
			BookState bookState= bookStateService.findOneState(i);
			bookStateList.add(bookState);
		}
		book.setBookStateList(bookStateList);
		boolean b = bookService.updateBook(book);
		if (b) {
			model.addAttribute("updateBooktrue", "修改图书成功");
			return "BackEnd/index";
		} else {
			return "error";
		}

	}
//===========================================================================================
	/**
	 * 前台的一些操作
	 */
//===========================================================================================
	
	@RequestMapping("/someBooklist")
	public String someBooklist(Model model,HttpServletRequest request) {
		System.out.println("jion someBooklist");
		List<Book> characteristicBookList = bookService.findCharacteristicBook();
		model.addAttribute("characteristicBookList", characteristicBookList);
		List<Book> newBookList = bookService.findNewBook();
		model.addAttribute("newBookList", newBookList);	
		List<Book> commendBookList = bookService.findCommendBook();
		request.getSession().setAttribute("commendBookList", commendBookList);
		//model.addAttribute("commendBookList", commendBookList);	
		List<BookType> bookTypeList = bookTypeService.findAllType();
		request.getSession().setAttribute("bookTypeList", bookTypeList);
		//model.addAttribute("bookTypeList",bookTypeList);	
		return "BookStore/index";
	}
	
//	@RequestMapping("/commendBookList")
//	public void commendBookList(Model model,Integer bookState_id,HttpServletResponse response) throws IOException {
//		System.out.println("111");
//		System.out.println(bookState_id);
//		List<Book> commendBookList = bookService.findCommendBook(bookState_id);
//		//model.addAttribute("commendBookList", commendBookList);	
//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//		JSONArray json =JSONArray.fromObject(commendBookList, jsonConfig);
//		System.out.println(json);
//		PrintWriter out = response.getWriter();
//		out.write(json.toString());
//		
//	}
	@RequestMapping("/details")
	public String oneBookDetail(Model model,Integer book_id) {
		Book book  = bookService.selectBook(book_id);
		model.addAttribute("book",book);
		Set<Book> bookSet = book.getBookType().getBookSet();
		model.addAttribute("bookSet",bookSet);
		return "BookStore/index";
	}
	
	
	
	@RequestMapping("/characteristicBookList")
	public String specialsbookList(Model model) {
		
		List<Book> characteristicBookList = bookService.findCharacteristicBook();
		model.addAttribute("characteristicBookList", characteristicBookList);
		model.addAttribute("onclick","onclick");
		return "BookStore/index";
	}
	@RequestMapping("/allbooklist")
	public String allbooklist(Model model,Integer pages) {
		System.out.println("jion allbooklist");
		
		Integer totalpages = bookService.selectTotalpages();
		if (pages == null) { 
	        pages = 1;
	    } else {
	        if (pages < 1){
	            pages = 1;
	        }
	        if (pages > totalpages){
	            pages = totalpages;
	        }                            
	    }
		List<Book> list = bookService.findAll(pages);
		model.addAttribute("totalpages",totalpages);
		model.addAttribute("pages",pages);
		model.addAttribute("allbooklist", list);

		return "BookStore/index";
	}
	Integer count = 0;
	Double sum = 0.0;
	@RequestMapping("/addCart")
	public String addCart(Integer book_id,Model model,HttpServletRequest request) {
	
		Users user = (Users) request.getSession().getAttribute("user");
		if(user == null) {
			return "BookStore/myaccount";
		}else {
			Book book = bookService.findOneBook(book_id);
			if(book != null) {
				count++;
				sum+=book.getBook_price();
				request.getSession().setAttribute("sum", sum);
				request.getSession().setAttribute("count", count);
			}
			List<Book> cartbooklist = (List<Book>) request.getSession().getAttribute("cartbooklist");
			if(cartbooklist == null) {
				cartbooklist = new ArrayList<Book>();
				cartbooklist.add(book);
				request.getSession().setAttribute("cartbooklist", cartbooklist);
			}else {
				cartbooklist.add(book);
				request.getSession().setAttribute("cartbooklist", cartbooklist);
			}
			return "redirect:someBooklist.do";
		}
	}
}
