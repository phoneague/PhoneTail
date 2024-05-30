package com.miniproject.phonetail.controller.action.report;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ReportDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.ReportDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ReportAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("login");
		String id = mdto.getUserid();
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		ReportDTO rdto = new ReportDTO();
		rdto.setPseq(pseq);
		rdto.setRecontent(request.getParameter("recontent"));
		rdto.setUserid(id);
		rdto.setRetype(Integer.parseInt(request.getParameter("retype")));
		System.out.println(rdto.toString());;
		ReportDAO rdao = ReportDAO.getInstace();
		rdao.insertReport(rdto);
		response.sendRedirect("report/reportResult.jsp");
	}

}
