package com.xiaotan.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.Order_detail;
import com.xiaotan.webshop.bean.Orders;
import com.xiaotan.webshop.dao.OrderDao;
import com.xiaotan.webshop.dao.OrderDetailDao;



@Service
@Transactional
public class OrderDetailService {
	@Autowired
	private OrderDetailDao orderDetailDao;
	public List<Order_detail> findAll(Integer order_id){
		return orderDetailDao.select(order_id);
	}

}
