package com.miniproject.phonetail.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.AdminDAO;
import com.miniproject.phonetail.DTO.AdminDTO;
import com.miniproject.phonetail.DTO.ReportDTO;
import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminReportListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		AdminDTO adto = (AdminDTO) session.getAttribute("adminUser");

		if (adto == null) {
			response.sendRedirect("phonetail.do?command=admin");
		}else {
			int page=1;
			if(request.getParameter("page")!=null) {
				page=Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page")!=null) {
				page=(Integer)session.getAttribute("page");
			}else {
				session.removeAttribute("page");
			}
			
			String key="";
			if(request.getParameter("key")!=null) {
				key=request.getParameter("key");
				session.setAttribute("key",key);
			}else if(session.getAttribute("key") !=null) {
				key = (String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			AdminDAO adao = AdminDAO.getInstance();
			int count = adao.getAllCount("report","userid",key, null);
			paging.setTotalCount(count);
			
			ArrayList<ReportDTO> reportList = adao.adminReportList(paging,key);
			
			request.setAttribute("paging", paging);
			request.setAttribute("reportList", reportList);
			request.getRequestDispatcher("admin/report/reportList.jsp").forward(request, response);
		}
		
	}

}
