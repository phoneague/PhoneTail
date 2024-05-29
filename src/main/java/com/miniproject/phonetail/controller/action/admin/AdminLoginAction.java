package com.miniproject.phonetail.controller.action.admin;

import java.io.IOException;

import com.miniproject.phonetail.DAO.AdminDAO;
import com.miniproject.phonetail.DTO.AdminDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid = request.getParameter("adminid");
		String pwd = request.getParameter("pwd");
		System.out.println("adminid : "+adminid);
		System.out.println("pwd : "+pwd);
		AdminDAO adao = AdminDAO.getInstance();
		AdminDTO adto = adao.getMember(adminid);
		
		String url = "admin/adminLogin.jsp";
		if( adto == null ) 
			request.setAttribute("message", "아이디가 없습니다");
		else if( !adto.getPwd().equals(pwd) ) 
			request.setAttribute("message", "패스워드가 틀립니다");
		else if( adto.getPwd().equals(pwd) ) {
			url = "phonetail.do?command=adminReportList";
			HttpSession session = request.getSession();
			session.setAttribute("adminUser", adto);
		}else 
			request.setAttribute("message", "관리자에게 문의하세요");
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
