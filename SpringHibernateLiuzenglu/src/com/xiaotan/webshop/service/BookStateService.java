package com.xiaotan.webshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.BookState;
import com.xiaotan.webshop.bean.BookType;
import com.xiaotan.webshop.dao.BookStateDao;
import com.xiaotan.webshop.dao.BookTypeDao;



@Service
@Transactional
public class BookStateService {
	@Autowired
	private BookStateDao bookStateDao;
	public BookState select(String book_State) {
		return bookStateDao.select(book_State);
	}
	public List<BookState>  findAllState(){
		return bookStateDao.findAllState();
	}
	public BookState findOneState(Integer bookState_id) {
		return bookStateDao.findOneState(bookState_id);
	}
//	public boolean addBookType(String book_type_name){
//		return bookTypeDao.addBookType(book_type_name);
//	}
//	public boolean register(Users user) {
//		// TODO Auto-generated method stub
//		
//		return userDao.insert(user);
//	}
	public BookStateDao getBookStateDao() {
		return bookStateDao;
	}
	public void setBookStateDao(BookStateDao bookStateDao) {
		this.bookStateDao = bookStateDao;
	}
}
