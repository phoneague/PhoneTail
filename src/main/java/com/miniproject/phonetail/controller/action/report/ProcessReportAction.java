package com.miniproject.phonetail.controller.action.report;

import java.io.IOException;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DAO.ReportDAO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProcessReportAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restate = request.getParameter("newRestate");
//		System.out.println(restate);
		int reseq = Integer.parseInt(request.getParameter("reseq"));
		if(restate.equals("Y")) {
			String pid = request.getParameter("pid");
//			System.out.println(pid+"을 블랙리스트에 추가합니다");
			MemberDAO mdao = MemberDAO.getInstance();
			mdao.stateChangeYtoB(pid);
		}
		ReportDAO rdao =ReportDAO.getInstace();
		rdao.updateReport(restate,reseq);
		response.sendRedirect("phonetail.do?command=reportView&reseq="+reseq);
	}

}
