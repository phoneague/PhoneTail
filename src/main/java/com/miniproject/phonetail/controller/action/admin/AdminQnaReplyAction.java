package com.miniproject.phonetail.controller.action.admin;

import java.io.IOException;

import com.miniproject.phonetail.DAO.AdminDAO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminQnaReplyAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qseq = Integer.parseInt(request.getParameter("qseq"));
		String qreply = request.getParameter("qreply");
		AdminDAO adao = AdminDAO.getInstance();
		adao.questionReply(qseq, qreply);
		
		response.sendRedirect("phonetail.do?command=qnaView&qseq=" + qseq);
		}
	}
	
