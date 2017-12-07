package com.xiaotan.webshop.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.Orders;
import com.xiaotan.webshop.bean.Users;
import com.xiaotan.webshop.dao.OrderDao;



@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	public List<Orders> findAll(){
		return orderDao.select();
	}
	
	public  boolean insertOrder(Orders order) {
		return orderDao.insertOrder(order);
	}
	public boolean deleteOrder(Integer order_id) {
		return orderDao.deleteOrder(order_id);
	}
	
	public boolean payOrder(Integer order_id) {
		return orderDao.payOrder(order_id);
	}
//	public Book selectBook(Integer book_id) {
//		return bookDao.selectBook(book_id);		
//	}
//	public boolean register(Users user) {
//		// TODO Auto-generated method stub
//		
//		return userDao.insert(user);
//	}
}
