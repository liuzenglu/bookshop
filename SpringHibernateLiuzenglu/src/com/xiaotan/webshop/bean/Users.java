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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;




@Entity
@Table(name = "users")
@Lazy(false)
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	@Column(name = "user_username")
	private String user_username;
	@Column(name = "user_password")
	private String user_password;
	@Column(name = "user_email")
	private String user_email;
	@Column(name = "user_telephone")
	private String user_telephone;
	@Column(name = "user_address")
	private String user_address;
	@Column(name = "posttime")
	private Date posttime;
	@OneToMany(mappedBy="user", targetEntity=Orders.class, 
            cascade=CascadeType.ALL)
	private Set<Orders> ordersSet =  new HashSet<Orders>();
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_telephone() {
		return user_telephone;
	}
	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public Set<Orders> getOrdersSet() {
		return ordersSet;
	}
	public void setOrdersSet(Set<Orders> ordersSet) {
		this.ordersSet = ordersSet;
	}


	
}
