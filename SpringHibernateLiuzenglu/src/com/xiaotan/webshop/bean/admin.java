package com.xiaotan.webshop.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer admin_id;
	@Column(name = "admin_username")
	private String admin_username;
	@Column(name = "admin_password")
	private String admin_password;
	@Column(name = "admin_realname")
	private String admin_realname;

	// =================================================
	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_realname() {
		return admin_realname;
	}

	public void setAdmin_realname(String admin_realname) {
		this.admin_realname = admin_realname;
	}

}
