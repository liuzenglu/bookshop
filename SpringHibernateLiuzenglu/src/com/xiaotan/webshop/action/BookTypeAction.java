package com.xiaotan.webshop.action;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.bean.BookType;
import com.xiaotan.webshop.service.BookTypeService;

@Controller
@RequestMapping("/bookType")
public class BookTypeAction {
	
	@Autowired
	private BookTypeService bookTypeService;

	public BookTypeService getBookTypeService() {
		return bookTypeService;
	}

	public void setBookTypeService(BookTypeService bookTypeService) {
		this.bookTypeService = bookTypeService;
	}
	@RequestMapping("/addBookTypeAddAttribute")
	public String addBookTypeAddAttribute(Model model) {
		List<BookType> bookTypeList = bookTypeService.findAllType();
		model.addAttribute("bookTypeListEnd",bookTypeList);				
		return "BackEnd/index";
	}
	
	@RequestMapping("/addBookType")
	public String addBookType(Model model,String book_type_name) {
		boolean  b = bookTypeService.addBookType(book_type_name);
		if(b) {
			return "redirect:addBookTypeAddAttribute.do";
		}else {
			return "";
		}
	}
	
	@RequestMapping("/someOneBookType")
	public String someOneBookType(Integer type_id,Model model) {
		BookType bookType = bookTypeService.someOneBookType(type_id);
		Set<Book> oneBookTypeBook = bookType.getBookSet();
		model.addAttribute("oneBookTypeBook",oneBookTypeBook);
		model.addAttribute("oneBookType",bookType.getType_name());
		return "BookStore/index";
	}
	
}
