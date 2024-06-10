package com.miniproject.phonetail.controller.action.member;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindIdAciton implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");

     
        MemberDAO mdao = MemberDAO.getInstance();
        String userid = mdao.findId(name, email);

        // 결과 JSP로 전달
        request.setAttribute("userid", userid);
        String url = "/member/findIdResult.jsp";

        // 결과 페이지로 이동
        request.getRequestDispatcher(url).forward(request, response);
    }

}
