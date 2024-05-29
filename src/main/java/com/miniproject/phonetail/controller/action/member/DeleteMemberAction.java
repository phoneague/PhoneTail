package com.miniproject.phonetail.controller.action.member;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		MemberDAO mdao = MemberDAO.getInstance();
		
		if(mdto==null) {
			request.setAttribute("message", "회원탈퇴를 하려면 먼저 로그인해야 합니다");

		} else {
			
			int result = mdao.deleteMember( mdto.getUserid() );
			
			session.invalidate();

			if(result==1) {
				request.setAttribute("message", "회원정보가 정상적으로 삭제되었습니다");
			}else {
				request.setAttribute("message", "회원탈퇴가 정상적으로 완료되지 못했습니다. 다음에 다시 시도하세요");
			}	
		}

		request.getRequestDispatcher("member/loginForm.jsp").forward(request, response);
	}


}
