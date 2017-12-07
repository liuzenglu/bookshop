package com.xiaotan.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.BookType;
import com.xiaotan.webshop.dao.BookTypeDao;



@Service
@Transactional
public class BookTypeService {
	@Autowired
	private BookTypeDao bookTypeDao;
	public BookType select(String type_name) {
		return bookTypeDao.select(type_name);
	}
	public List<BookType>  findAllType(){
		return bookTypeDao.findAllType();
	}
	public boolean addBookType(String book_type_name){
		return bookTypeDao.addBookType(book_type_name);
	}
	public BookType someOneBookType(Integer type_id){
		return bookTypeDao.someOneBookType(type_id);
	}
//	public boolean register(Users user) {
//		// TODO Auto-generated method stub
//		
//		return userDao.insert(user);
//	}
}
