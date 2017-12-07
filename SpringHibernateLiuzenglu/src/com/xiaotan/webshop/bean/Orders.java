package com.xiaotan.webshop.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")	
	private Integer order_id;
	@Column(name = "order_time")	
	private Date order_time;
	@ManyToOne()
	@JoinColumn(name = "orderState_id")	
	private OrderState orderstate;
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Users user;
	@OneToMany(mappedBy="order", targetEntity=Order_detail.class, 
            cascade=CascadeType.ALL)
	private Set<Order_detail> orderDetailsSet =  new HashSet<Order_detail>();
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Set<Order_detail> getOrderDetailsSet() {
		return orderDetailsSet;
	}
	public void setOrderDetailsSet(Set<Order_detail> orderDetailsSet) {
		this.orderDetailsSet = orderDetailsSet;
	}
	public OrderState getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(OrderState orderstate) {
		this.orderstate = orderstate;
	}

	

	
}
