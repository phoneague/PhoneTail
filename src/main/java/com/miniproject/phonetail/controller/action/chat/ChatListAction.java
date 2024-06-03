package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.util.Paging;

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
			
			int price = 1;
			if(request.getParameter("price")!=null) {
				price=Integer.parseInt(request.getParameter("price"));
				session.setAttribute("price",price);
			}else if(session.getAttribute("price") !=null) {
				price = (int)session.getAttribute("price");
			}else {
				session.removeAttribute("price");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			

			
			
			
			ChatListDAO cdao = ChatListDAO.getInstance();
			ArrayList<ChatListDTO> cList = new ArrayList<ChatListDTO>();
			int count = cdao.AllList("hak","model", key, price, mdto.getUserid());
			paging.setTotalCount(count);
			cList = cdao.chatList(paging, key, price, mdto.getUserid());
			
			request.setAttribute("loginUser", mdto.getUserid()); // 기존에 있던거
			//ArrayList<ChatListDTO> list = ldao.getAllList(mdto.getUserid()); // 기존에 있던거
			//request.setAttribute("chatList", list); // 기존에 있던거
			
			
			request.setAttribute("paging", paging);
			request.setAttribute("chatList", cList);
			
			// 기존에 있던거
			RequestDispatcher rd = request.getRequestDispatcher("chat/ChatList.jsp");
			rd.forward(request, response);
		}
	}

}
