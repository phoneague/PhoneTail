package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChatListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChatListDAO ldao = ChatListDAO.getInstance();
		
		ArrayList<ChatListDTO> list = ldao.getAllList();
		
		request.setAttribute("chatList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("ChatList.jsp");
		rd.forward(request, response);

	}

}
