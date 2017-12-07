package com.xiaotan.webshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaotan.webshop.bean.BookState;
import com.xiaotan.webshop.bean.BookType;



@Repository
public class BookStateDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public BookState select(String book_State){
		Session session = sessionFactory.getCurrentSession();	
		System.out.println(book_State);
		String hql = "from BookState where book_State=?";
		Query query = session.createQuery(hql);
		query.setString(0, book_State);
		BookState BookState = (BookState) query.uniqueResult();
		return BookState;
	}
	public List<BookState> findAllState(){
		Session session = sessionFactory.getCurrentSession();	
		Query query = session.createQuery("from BookState");
		List list =  query.list();
		return list;
	}
	public BookState findOneState(Integer bookState_id){
		Session session = sessionFactory.getCurrentSession();	
		Query query = session.createQuery("from BookState where bookState_id=?");
		query.setInteger(0, bookState_id);
		BookState bookState =   (BookState) query.uniqueResult();
		return bookState;
	}
//	public boolean addBookType(String book_type_name) {
//		System.out.println(book_type_name);
//		Session session = sessionFactory.getCurrentSession();	
//		BookType bookType = new BookType();
//		bookType.setType_name(book_type_name);
//		session.save(bookType);
//		return true;
//	}
//	public boolean insert(Users user) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		session.save(user);
//		return true;
//	}

}
