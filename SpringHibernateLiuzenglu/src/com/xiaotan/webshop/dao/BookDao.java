package com.xiaotan.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaotan.webshop.bean.Book;
import com.xiaotan.webshop.bean.BookState;

@Repository
public class BookDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	Integer limit  = 2;
	public Integer selectTotalpages() {
		Session session = sessionFactory.openSession();
		Query querycount = session.createQuery("select count(*) from Book");
		
		Long count =  (Long) querycount.uniqueResult();
		Integer totalpages;
		if(count == 0) {
			totalpages = 0;	
		}else {	
			if(count%limit == 0) {
				totalpages = (int) (count/limit);
			}else {
				totalpages = (int) (count/limit)+1;
			}
		}
		return totalpages;
	}
	public List<Book> select(Integer pages) {
		Session session = sessionFactory.openSession();
	
		Query queryBook = session.createQuery("from Book order by book_id asc");
		queryBook.setFirstResult((pages - 1) * limit);
		queryBook.setMaxResults(limit);
		List<Book> list = queryBook.list();
//		Query query = session.createQuery("from Book");
//		List<Book> list = query.list();
//		System.out.println(list.get(0).getBookType().getType_name());
		return list;
	}

	public boolean addBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		int ret = (int) session.save(book);
		if (ret > 0) {
			return true;
		} else {
			return false;
		}

	}

	// =====================================================================
	public boolean updatebook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(book.getBook_name() + book.getBook_author() + book.getBook_description()
				+ book.getBook_publisher() + book.getBook_price() + book.getBook_imgurl() + book.getBookType()
				+ book.getBook_id() + "llllllllllllll" + book.getBookStateList().size());
		session.update(book);
		return true;

	}

	public boolean deleteBook(Integer book_id) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(book_id);
		String hql = "delete from Book where book_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, book_id);
		int ret = query.executeUpdate();
		if (ret == 1) {
			return true;
		} else {
			return false;
		}
	}

	public Book selectBook(Integer book_id) {
		Session session = sessionFactory.openSession();
		System.out.println(book_id);
		String hql = "from Book where book_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, book_id);
		Book book = (Book) query.uniqueResult();
		return book;
	}
	
//====================================================================================
	
	public List<Book> findCharacteristicBook(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BookState where bookState_id=?");
		query.setInteger(0, 3);
		BookState bookState = (BookState) query.uniqueResult();
		List<Book> characteristicBook= bookState.getBookList();
		return characteristicBook;
	}
	public List<Book> findNewBook(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BookState where bookState_id=?");
		query.setInteger(0, 2);
		BookState bookState = (BookState) query.uniqueResult();
		List<Book> newBook= bookState.getBookList();
		return newBook;
	}
	
	public List<Book> findCommendBook(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BookState where bookState_id=?");
		query.setInteger(0, 4);
		BookState bookState = (BookState) query.uniqueResult();
		List<Book> commendBook= bookState.getBookList();
		return commendBook;
	}
	
	public Book findOneBook(Integer book_id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Book where book_id=?");
		query.setInteger(0, book_id);
		Book book = (Book) query.uniqueResult();
		return book;
	}
}
