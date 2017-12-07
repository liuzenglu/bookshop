package com.xiaotan.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaotan.webshop.bean.BookType;



@Repository
public class BookTypeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public BookType select(String type_name){
		Session session = sessionFactory.getCurrentSession();	
		System.out.println(type_name);
		String hql = "from BookType where type_name=?";
		Query query = session.createQuery(hql);
		query.setString(0, type_name);
		BookType bookType = (BookType) query.uniqueResult();
		return bookType;
	}
	public List<BookType> findAllType(){
		Session session = sessionFactory.getCurrentSession();	
		Query query = session.createQuery("from BookType");
		List<BookType> list = query.list();
		return list;
	}
	public boolean addBookType(String book_type_name) {
		System.out.println(book_type_name);
		Session session = sessionFactory.getCurrentSession();	
		BookType bookType = new BookType();
		bookType.setType_name(book_type_name);
		session.save(bookType);
		return true;
	}
	public BookType someOneBookType(Integer type_id) {
		Session session = sessionFactory.openSession();
		BookType bookType = session.load(BookType.class, type_id);
		return bookType;
	}
//	public boolean insert(Users user) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		session.save(user);
//		return true;
//	}

}
