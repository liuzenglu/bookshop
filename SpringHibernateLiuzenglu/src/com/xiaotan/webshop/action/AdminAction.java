package com.xiaotan.webshop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaotan.webshop.bean.admin;
import com.xiaotan.webshop.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminAction {
	@Autowired
	private AdminService adminService;
	
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	@RequestMapping("allAdminlist")
	public String allAdminList(Model model) {
		List<admin> adminList  = adminService.allAdminList();
		model.addAttribute("adminList",adminList);
		return "BackEnd/index";
	}
	@RequestMapping("/register")
	public String register() {
		System.out.println("register");
		return "";
	}
	//==============================================================================
	@RequestMapping("login")
	public String login(String username,String password,HttpServletRequest request,Model model) {
		System.out.println("login");
		admin admin = adminService.login(username,password);
		if(admin != null) {
			request.getSession().setAttribute("admin", admin);
			return "BackEnd/index";
		}else {
			model.addAttribute("errormsg", "管理登入出错");
			return "redirect:../AdminLogin/index.html";
		}
	}
	//=======================================================================
	@RequestMapping("updatePasswordAddAttribute")
	public String updateAttribute(Model model) {
		model.addAttribute("updatePassword","admin");
		return "BackEnd/index";
	}
	
	@RequestMapping("updatePassword")
	public String update(HttpServletRequest request,String password,Model model) {
		System.out.println("updatePassword");
		admin admin1 = (admin) request.getSession().getAttribute("admin");
		boolean b = adminService.updatePassword(admin1.getAdmin_id(),password);
		if(b) {
			model.addAttribute("updatetrue","更新密码成功");
			return "BackEnd/index";
		}else {
			model.addAttribute("errormsg","更新密码失败");
			return "";
		}
	}
	//=================================================================================
	@RequestMapping("delete")
	public boolean delete() {
		System.out.println("delete");
		return true;
	}
}
