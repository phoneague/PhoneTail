package com.miniproject.phonetail.controller.action.admin;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DTO.AdminDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminUserStateChangeBtoYACtion implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
    	AdminDTO adto = (AdminDTO) session.getAttribute("adminUser");
    	if (adto == null) 
			response.sendRedirect("phonetail.do?command=admin");
		else {
			MemberDAO mdao = MemberDAO.getInstance();
			String [] userstate = request.getParameterValues("userstate");
	    	for(String userid : userstate) {
	    		mdao.stateChangeBtoY(userid);
	    	}
	    	response.sendRedirect("phonetail.do?command=adminMemberList");
		}
    }
}
