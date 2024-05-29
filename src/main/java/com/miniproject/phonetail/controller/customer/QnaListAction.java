package com.miniproject.phonetail.controller.customer;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.QuestionDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.QuestionDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class QnaListAction implements Action {
		
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			MemberDTO mvo = (MemberDTO) session.getAttribute("customer");
			if( mvo==null ) {
				response.sendRedirect("phonetail.do?command=loginForm");
			}else {
				QuestionDAO qdao = QuestionDAO.getInstance();
				
				// 여기서부터 페이지 분할 관련 내용
				
				int page = 1; 			// 첫 페이지 시작 번호 설정
				if(request.getParameter("page")!=null) {				// 받은 페이지가 없다면
					page = Integer.parseInt(request.getParameter("page"));		// 페이지를 입력하고
					session.setAttribute("page", page);											// 세션에 페이지를 저장
				}else if( session.getAttribute("page")!=null) {			// 받은 페이지가 있으면
					page = (Integer)session.getAttribute("page");		// 바로 세션에다가 투입
				}
			
			}
		}

	}

