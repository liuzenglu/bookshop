package com.xiaotan.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaotan.webshop.bean.admin;
import com.xiaotan.webshop.dao.AdminDao;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public List<admin> allAdminList(){
		return adminDao.allAdminList();
	}
	public admin login(String username,String password) {
		return adminDao.login(username,password);
	}
	public boolean updatePassword(Integer admin_id,String password) {
		return adminDao.updatePassword(admin_id,password);
	}
	

}
