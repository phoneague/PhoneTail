package com.miniproject.phonetail.controller.customer;

import java.io.IOException;

import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WriteQnaFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		
		if( mdto == null) {
			response.sendRedirect("phonetail.do?command=loginForm");
		} else {
			request.setAttribute("loginUser", mdto.getUserid());
		}
		request.getRequestDispatcher("customer/writeQnaForm.jsp").forward(request, response);

	}

}
