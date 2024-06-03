package com.miniproject.phonetail.controller.mypage;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ReportDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.ReportDTO;
import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyReportListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    MemberDTO mdto = (MemberDTO) session.getAttribute("login");
	    if (mdto == null) {
	        response.sendRedirect("phonetail.do?command=loginForm");
	    } else {
	    	int page = 1; // 첫 페이지 시작 번호 설정
	        if (request.getParameter("page") != null) { // 받은 페이지가 없다면
	            page = Integer.parseInt(request.getParameter("page")); // 페이지를 입력하고
	            session.setAttribute("page", page); // 세션에 페이지를 저장
	        } else if (session.getAttribute("page") != null) { // 받은 페이지가 있으면
	            page = (Integer) session.getAttribute("page"); // 바로 세션에다가 투입
	        }
	        
	        
			Paging paging = new Paging();
			paging.setPage(page);
			
			String myId = mdto.getUserid();
			
			ReportDAO rdao = ReportDAO.getInstace();
			int count = rdao.getMyAllCount("report",myId);
			paging.setTotalCount(count);
			if(count==0) {
				 request.setAttribute("message", "내 신고내역이 없습니다.");
			}else {
				
			ArrayList<ReportDTO> reportList=rdao.myReportList(paging,myId);
			
			request.setAttribute("paging", paging);
			request.setAttribute("reportList", reportList);
			}
			request.getRequestDispatcher("mypage/myReportList.jsp").forward(request, response);
	    }
	}

}
