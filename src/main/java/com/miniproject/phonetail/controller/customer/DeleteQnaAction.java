package com.miniproject.phonetail.controller.customer;

import java.io.IOException;

import com.miniproject.phonetail.DAO.QuestionDAO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    int qseq = Integer.parseInt(request.getParameter("qseq"));
		    
		    QuestionDAO qdao = QuestionDAO.getInstance();
		    qdao.deleteQna(qseq);

		    response.sendRedirect("phonetail.do?command=qnaList");
	}
}
