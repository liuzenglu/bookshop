package com.xiaotan.webshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiaotan.webshop.bean.OrderState;

@Repository
public class OrderStateDao {
	@Autowired
	private SessionFactory sessionFactory;
	public OrderState selectIdIsOne(){
		System.out.println("进入selectIdIdOne");
		Session session = sessionFactory.getCurrentSession();	
		OrderState orderState = session.get(OrderState.class, 1);
		return orderState;
//		Query query = session.createQuery("from OrderState where orderState_id=?");
//		query.setInteger(0, orderState_id);
//		OrderState orderState = (OrderState) query.uniqueResult();
//		System.out.println("orderStateDao"+orderState.getOrderState_id());
//		return orderState;
	}
}
