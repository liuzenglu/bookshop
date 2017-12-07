package com.xiaotan.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.Users;



@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<Users> select(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Users");
		List<Users> list = query.list();
		return list;
	}
	public boolean deleteUser(Integer user_id) {
		Session session = sessionFactory.getCurrentSession();	
		System.out.println(user_id);
		String hql = "delete from Users where user_id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, user_id);
		int ret = query.executeUpdate();
		if(ret == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Users> findUserOrder(String user){
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery("from Users where user_username like'%"+user+"%'");
		List<Users> list = query.list();
		System.out.println(list.get(0).getUser_username());
		return list;
	}
	
	public Users login(String username,String password) {
		Session session = sessionFactory.openSession();		
		Query query = session.createQuery("from Users where user_username=? and user_password=?");
		query.setString(0, username);
		query.setString(1, password);
		Users user = (Users) query.uniqueResult();
		return user;
		
	}
	public boolean loginUsername(String user_username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Users where user_username=?");
		query.setString(0, user_username);
		Users user = (Users) query.uniqueResult();
		if(user != null) {
			return true;
		}
		return false;
	}
	public boolean insert(Users user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

}
