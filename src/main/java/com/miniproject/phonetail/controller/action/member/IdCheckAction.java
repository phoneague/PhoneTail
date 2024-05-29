package com.miniproject.phonetail.controller.action.member;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터로 전달된 userid 를 체크합니다.
		String userid = request.getParameter("userid");
		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO mdto = mdao.getMember(userid);
				
		if( mdto == null) request.setAttribute("result", "-1");
		else request.setAttribute("result", "1");
				
		request.setAttribute("userid", userid);
		RequestDispatcher rd = request.getRequestDispatcher("member/idcheck.jsp");
		rd.forward(request, response);
	}

}
