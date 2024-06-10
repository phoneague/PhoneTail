package com.miniproject.phonetail.controller.action.member;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자 입력 받기
        String userid = request.getParameter("userid");
        String email = request.getParameter("email");

        // DAO 호출
        MemberDAO mdao = MemberDAO.getInstance();
        String pwd = mdao.findPw(userid, email);

        // 결과 JSP로 전달
        request.setAttribute("pwd", pwd);
        String url = "/member/findPwResult.jsp";

        // 결과 페이지로 이동
        request.getRequestDispatcher(url).forward(request, response);
    }

}
