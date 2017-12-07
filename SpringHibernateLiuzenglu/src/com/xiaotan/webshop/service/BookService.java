package com.xiaotan.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.dao.BookDao;



@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	public Integer selectTotalpages() {
		return bookDao.selectTotalpages();
	}
	public List<Book> findAll(Integer pages){
		 List<Book> list = bookDao.select(pages);
		 return list;
	}
	public boolean addBook(Book book) {
		return bookDao.addBook(book);	
	}
	public boolean updateBook(Book book) {
		return bookDao.updatebook(book);	
	}
	public boolean deleteBook(Integer book_id) {
		boolean b = bookDao.deleteBook(book_id);
		if(b) {
			return true;
		}else {
			
			return false;
		}
	}
	public Book selectBook(Integer book_id) {
		return bookDao.selectBook(book_id);		
	}
//========================================================================
	
	
	
	public List<Book> findCharacteristicBook(){
		return bookDao.findCharacteristicBook();
	}
	
	public List<Book> findNewBook(){
		return bookDao.findNewBook();
	}
	
	public List<Book> findCommendBook(){
		return bookDao.findCommendBook();
	}
	public Book findOneBook(Integer book_id) {
		return bookDao.findOneBook(book_id);
	}
}
