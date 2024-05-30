package com.miniproject.phonetail.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.AdminDAO;
import com.miniproject.phonetail.DTO.AdminDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		AdminDTO adto = (AdminDTO)session.getAttribute("adminUser");
		if( adto == null ) {
			response.sendRedirect("phonetail.do?command=admin"); 
		}else {
			 
			Paging paging = new Paging(); 
			if( request.getParameter("page")!=null) {
					paging.setPage( Integer.parseInt( request.getParameter("page") ) );
					session.setAttribute("page", Integer.parseInt( request.getParameter("page")  ) );
			} else if( session.getAttribute("page") != null ) {
					paging.setPage( (Integer)session.getAttribute("page") );
			} else {
					paging.setPage(1);
					session.removeAttribute("page");
			}
			
			String key="";
			if( request.getParameter("key") != null ) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if( session.getAttribute("key") != null ) {
				key = (String)session.getAttribute("key");
			} else {
				key="";
				session.removeAttribute("key");
			}
			AdminDAO adao = AdminDAO.getInstance();
			
			int count = adao.getAllCount( "member", "name", key);
			paging.setTotalCount(count);
				
			ArrayList<MemberDTO> memberList = adao.adminMemberList( paging , key);
			
			request.setAttribute("paging", paging);
			request.setAttribute("memberList", memberList);
			request.setAttribute("key", key);
			
			request.getRequestDispatcher("admin/member/memberList.jsp").forward(request, response);
		}
		
		
	}

}
