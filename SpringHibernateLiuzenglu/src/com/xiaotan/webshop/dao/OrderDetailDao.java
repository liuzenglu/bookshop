package com.xiaotan.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.bean.Order_detail;
import com.xiaotan.webshop.bean.Orders;



@Repository
public class OrderDetailDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<Order_detail> select(Integer order_id){
		Session session = sessionFactory.getCurrentSession();		
		Query query = session.createQuery("from Order_detail where order_id=?");
		query.setInteger(0, order_id);
		List<Order_detail> list = query.list();
		return list;
	}
	
//	public boolean addBook(Book book) {
//		Session session = sessionFactory.getCurrentSession();		
//		int ret = (int) session.save(book);
//		if(ret > 0) {
//			return true;
//		}else {
//			return false;
//		}
//				
//	}
//	//=====================================================================
//	public boolean updatebook(Book book) {	
//		Session session = sessionFactory.getCurrentSession();	
//		System.out.println(book.getBook_name()+book.getBook_author()+book.getBook_description()+
//				book.getBook_publisher()+book.getBook_price()+book.getBook_imgurl()+
//				 book.getBookType().getType_id()+book.getBook_id());
//		Query query = session.createQuery("update Book set book_name=?,book_author=?,"
//				+ "book_description=?,book_publisher=?,book_price=?,"
//				+ "book_imgurl=?,type_id=? where book_id=?");
//		query.setString(0, book.getBook_name());
//		query.setString(1, book.getBook_author());
//		query.setString(2, book.getBook_description());
//		query.setString(3, book.getBook_publisher());
//		query.setDouble(4, book.getBook_price());
//		query.setString(5, book.getBook_imgurl());
//		query.setInteger(6, book.getBookType().getType_id());
//		query.setInteger(7,book.getBook_id());
//		
//		int ret = query.executeUpdate();
//		if(ret > 0) {
//			return true;
//		}else {
//			return false;
//		}
//				
//	}
//	public boolean deleteBook(Integer book_id) {
//		Session session = sessionFactory.getCurrentSession();	
//		System.out.println(book_id);
//		String hql = "delete from Book where book_id=?";
//		Query query = session.createQuery(hql);
//		query.setInteger(0, book_id);
//		int ret = query.executeUpdate();
//		if(ret == 1) {
//			return true;
//		}else {
//			return false;
//		}
//	}
//	public Book selectBook(Integer book_id) {
//		Session session = sessionFactory.getCurrentSession();	
//		System.out.println(book_id);
//		String hql = "from Book where book_id=?";
//		Query query = session.createQuery(hql);
//		query.setInteger(0, book_id);
//		Book book = (Book) query.uniqueResult();
//		return book;
//	}
//	public boolean insert(Users user) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		session.save(user);
//		return true;
//	}

}
