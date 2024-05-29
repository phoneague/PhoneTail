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
	    MemberDTO mdto = (MemberDTO) session.getAttribute("login");
	    if (mdto == null) {
	        response.sendRedirect("phonetail.do?command=loginForm");
	    } else {
	        // 여기서부터 페이지 분할 관련 내용
	        int page = 1; // 첫 페이지 시작 번호 설정
	        if (request.getParameter("page") != null) { // 받은 페이지가 없다면
	            page = Integer.parseInt(request.getParameter("page")); // 페이지를 입력하고
	            session.setAttribute("page", page); // 세션에 페이지를 저장
	        } else if (session.getAttribute("page") != null) { // 받은 페이지가 있으면
	            page = (Integer) session.getAttribute("page"); // 바로 세션에다가 투입
	        }

	        // 질문 목록을 가져오는 코드 추가
	        ArrayList<QuestionDTO> questionList = new ArrayList<>();
	        QuestionDAO qdao = QuestionDAO.getInstance();
	        questionList = qdao.getAllQuestions(); // 모든 질문을 가져옵니다. 이에 따른 메서드명은 적절히 변경해주세요.

	        // 가져온 질문 목록을 request에 attribute로 저장합니다.
	        request.setAttribute("questionList", questionList);

	        // JSP 파일로 forward 합니다.
	        request.getRequestDispatcher("customer/qnaList.jsp").forward(request, response);
	    }
	    
	}
	}


