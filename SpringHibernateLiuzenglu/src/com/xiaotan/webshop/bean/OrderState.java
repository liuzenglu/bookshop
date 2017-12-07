package com.xiaotan.webshop.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "orderState")
public class OrderState {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderState_id")	
	private Integer orderState_id;
	@Column(name = "orderState")	
	private String order_State;
	
	@OneToMany(mappedBy="orderstate", targetEntity=Orders.class, 
            cascade=CascadeType.ALL)
	private Set<Orders> orderSet =  new HashSet<Orders>();

	public Integer getOrderState_id() {
		return orderState_id;
	}

	public void setOrderState_id(Integer orderState_id) {
		this.orderState_id = orderState_id;
	}



	public Set<Orders> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}

	public String getOrder_State() {
		return order_State;
	}

	public void setOrder_State(String order_State) {
		this.order_State = order_State;
	}
}
