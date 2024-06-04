package com.miniproject.phonetail.controller.customer;

import java.io.IOException;

import com.miniproject.phonetail.DAO.QuestionDAO;
import com.miniproject.phonetail.DTO.QuestionDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class QnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qseq = Integer.parseInt( request.getParameter("qseq"));
		
		QuestionDAO qdao =  QuestionDAO.getInstance();
		qdao.updateReadCount(qseq);
		QuestionDTO qdto  = qdao.getQna(qseq);

		request.setAttribute("QuestionDTO", qdto);
		request.getRequestDispatcher("customer/qnaView.jsp").forward(request, response);
	}
}

