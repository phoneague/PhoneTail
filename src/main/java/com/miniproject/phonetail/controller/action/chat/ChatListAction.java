package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ChatListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChatListDAO ldao = ChatListDAO.getInstance();
		ProductDAO pdao = ProductDAO.getInstance();
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
				
		ArrayList<ChatListDTO> list = ldao.getAllList();
		if( mdto == null) {
			response.sendRedirect("phonetail.do?command=loginForm");
		}else {
			request.setAttribute("loginUser", mdto.getUserid());
			request.setAttribute("chatList", list);

			RequestDispatcher rd = request.getRequestDispatcher("chat/ChatList.jsp");
			rd.forward(request, response);
		}
	}

}
