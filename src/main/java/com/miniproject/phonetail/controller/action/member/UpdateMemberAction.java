package com.miniproject.phonetail.controller.action.member;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UpdateMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO mdto = new MemberDTO();
		mdto.setUserid(request.getParameter("userid"));
		mdto.setName(request.getParameter("name"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setAddress1(request.getParameter("address1"));
		mdto.setAddress2(request.getParameter("address2"));
		
		MemberDAO mdao = MemberDAO.getInstance();
		int result = mdao.updateMember(mdto);
		
		
		if( result == 1) {// 수정된 정보로 세션의  login으로 수정 업데이트 합니다
			HttpSession session = request.getSession();
			session.setAttribute("login", mdto);
		}
		RequestDispatcher dp = request.getRequestDispatcher("phonetail.do?command=main");
		dp.forward(request, response);
	}
}

