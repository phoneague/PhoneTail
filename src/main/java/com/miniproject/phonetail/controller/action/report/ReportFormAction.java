package com.miniproject.phonetail.controller.action.report;

import java.io.IOException;

import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReportFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		
		request.setAttribute("pseq", pseq);
		request.getRequestDispatcher("report/reportForm.jsp").forward(request, response);
		
	}

}
