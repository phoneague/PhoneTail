package com.miniproject.phonetail.controller.action.report;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ReportDAO;
import com.miniproject.phonetail.DTO.ReportDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReportViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reseq = Integer.parseInt( request.getParameter("reseq"));
		
		ReportDAO rdao = ReportDAO.getInstace();
		ReportDTO rdto = rdao.getReport(reseq);
		request.setAttribute("reportDTO", rdto);
		request.getRequestDispatcher("report/reportView.jsp").forward(request, response);
	}

}
