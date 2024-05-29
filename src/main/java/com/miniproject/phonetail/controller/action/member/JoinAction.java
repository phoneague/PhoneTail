package com.miniproject.phonetail.controller.action.member;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDTO mdto = new MemberDTO();
		
		mdto.setUserid(request.getParameter("userid"));
		mdto.setName(request.getParameter("name"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAddress1(request.getParameter("address1"));
		mdto.setAddress2(request.getParameter("address2"));
		mdto.setZip_num(request.getParameter("zip_num"));
		
		MemberDAO mdao = MemberDAO.getInstance();
		int result = mdao.insertMember( mdto );
		
		String message = "";
		if( result==1) message = "회원가입이 완료되었습니다. 로그인하세요";
		else message = "회원가입이 실패했습니다. 관리자에게 문의하세요";
		
		HttpSession session = request.getSession();
		session.setAttribute("message", message);
		
		// 모든 기능중에 레코드를 추가하는 기능에는  마지막 명령으로  forward 를 쓰지 않습니다
		// forward 를 쓸경우 "새로고침" 누를 시에   회원가입을 위해서 입력한 내용부터 다시 실행되서 
		// 중복레코드를 추가하려고 시도합니다. 
		// 이때 기본키 오류가 발생
		response.sendRedirect( "phonetail.do?command=loginForm" );

	}


}
