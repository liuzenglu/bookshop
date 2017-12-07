package com.xiaotan.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.OrderState;
import com.xiaotan.webshop.dao.OrderStateDao;



@Service
@Transactional
public class OrderStateService {
	@Autowired
	private OrderStateDao orderStateDao;
	
	public OrderState selectIdIsOne(){
		return orderStateDao.selectIdIsOne();
	}
	
	
	public OrderStateDao getOrderStateDao() {
		return orderStateDao;
	}
	public void setOrderStateDao(OrderStateDao orderStateDao) {
		this.orderStateDao = orderStateDao;
	}

}
