package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ChatListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		if( mdto == null) {
			response.sendRedirect("phonetail.do?command=loginForm");
		}else {
			/*
			 * int page=1; if(request.getParameter("page")!=null) {
			 * page=Integer.parseInt(request.getParameter("page"));
			 * session.setAttribute("page", page); }else
			 * if(session.getAttribute("page")!=null) {
			 * page=(Integer)session.getAttribute("page"); }else {
			 * session.removeAttribute("page"); }
			 */
			
			String key="";
			if(request.getParameter("key")!=null) {
				key=request.getParameter("key");
				session.setAttribute("key",key);
			}else if(session.getAttribute("key") !=null) {
				key = (String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
			}
			
			//Paging paging = new Paging();
			//paging.setPage(page);
			
			
			ChatListDAO cdao = ChatListDAO.getInstance();
			ArrayList<ChatListDTO> clist = new ArrayList<ChatListDTO>();
			//int count = cdao.AllList("hak","model", key, mdto.getUserid());
			
			//paging.setTotalCount(count);
			clist = cdao.chatList( key, mdto.getUserid(), mdto.getUserid());
			
			
			
			
			request.setAttribute("loginUser", mdto.getUserid()); // 기존에 있던거
			
			request.setAttribute("chatList", clist); // 기존에 있던거
			
			
			//request.setAttribute("paging", paging);
			//request.setAttribute("chatList", cList);
			
			// 기존에 있던거
			RequestDispatcher rd = request.getRequestDispatcher("chat/ChatList.jsp");
			rd.forward(request, response);
		}
	}

}
