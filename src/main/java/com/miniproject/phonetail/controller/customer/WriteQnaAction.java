package com.miniproject.phonetail.controller.customer;

import java.io.IOException;

import com.miniproject.phonetail.DAO.QuestionDAO;
import com.miniproject.phonetail.DTO.QuestionDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionDTO qdto = new QuestionDTO();
		
		qdto.setUserid(request.getParameter("userid"));
		qdto.setTitle(request.getParameter("title"));
		qdto.setContent(request.getParameter("content"));
		
		QuestionDAO qdao = QuestionDAO.getInstance();
		qdao.insertQna(qdto);
		
		response.sendRedirect("phonetail.do?command=qnaList");
	}
}

