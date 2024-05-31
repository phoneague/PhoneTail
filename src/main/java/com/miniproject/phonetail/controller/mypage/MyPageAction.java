package com.miniproject.phonetail.controller.mypage;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		
		if( mdto == null) {
			response.sendRedirect("phonetail.do?command=loginForm");
		}else {
			request.setAttribute("loginUserName", mdto.getName());
			RequestDispatcher rd = request.getRequestDispatcher("mypage/mypage.jsp");
			rd.forward(request, response);
		}
	}
}
