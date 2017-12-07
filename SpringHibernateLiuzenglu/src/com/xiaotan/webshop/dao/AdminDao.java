package com.xiaotan.webshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaotan.webshop.bean.admin;

@Repository
public class AdminDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<admin> allAdminList(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from admin");
		List<admin> adminList = query.list();
		return adminList;
	}
	
	public admin login(String username,String password){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from admin where admin_username=? and admin_password=?");
		query.setString(0, username);  
		query.setString(1, password);  
        admin admin = (admin)query.uniqueResult(); 
        return admin;
	}
	public boolean updatePassword(Integer admin_id,String password) {
		Session session = sessionFactory.getCurrentSession();	
		Query queryupdate=session.createQuery("update admin set admin_password=? where admin_id=?");
		queryupdate.setString(0, password);
		queryupdate.setInteger(1, admin_id);		
		int ret=queryupdate.executeUpdate();
		if(ret > 0) {
			return true;
		}else {
			return false;
		}
			
	}
//	public boolean insert(User user) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.getCurrentSession();
//		session.save(user);
//		return true;
//	}

}
