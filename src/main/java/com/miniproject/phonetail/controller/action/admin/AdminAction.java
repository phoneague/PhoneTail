package com.miniproject.phonetail.controller.action.admin;

import java.io.IOException;

import com.miniproject.phonetail.DTO.AdminDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminDTO adto = (AdminDTO) session.getAttribute("adminUser");
		if (adto == null) {
			request.getRequestDispatcher("admin/adminLogin.jsp").forward(request, response);
		} else {
			response.sendRedirect("phonetail.do?command=adminReportList");
		}
	}

}
