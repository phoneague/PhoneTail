package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChatingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lseq = Integer.parseInt(request.getParameter("lseq"));
		ChatListDAO cdao = ChatListDAO.getInstance();
		
		ChatListDTO cdto = cdao.getChatList(lseq);
		
		request.setAttribute("chatList", cdto);
		request.getRequestDispatcher("chat/Chating.jsp").forward(request, response);
	}

}
