package com.xiaotan.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.Users;
import com.xiaotan.webshop.dao.UserDao;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<Users> findAll() {
		List<Users> list = userDao.select();
		return list;
	}

	public boolean deleteUser(Integer user_id) {
		return userDao.deleteUser(user_id);
	}

	public List<Users> findUserOrder(String user) {
		return userDao.findUserOrder(user);
	}
	public Users login(String username,String password) {
		return userDao.login(username, password);
		
	}
	public boolean loginUsername(String user_username) {
		return userDao.loginUsername(user_username);
	}
	 public boolean register(Users user) {
		 return userDao.insert(user);
	 }
}
