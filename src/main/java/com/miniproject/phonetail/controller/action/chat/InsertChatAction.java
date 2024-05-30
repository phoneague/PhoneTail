package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DTO.ChatingDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertChatAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ChatingDTO cdto = new ChatingDTO();
		cdto.setUserid(request.getParameter("loginUser"));
		cdto.setLseq(Integer.parseInt(request.getParameter("lseq")));
		cdto.setContent(request.getParameter("content"));
		
		ChatListDAO ldto = ChatListDAO.getInstance();
		ldto.insertReply(cdto);
		
		request.getRequestDispatcher("phonetail.do?command=chating&lseq=" + cdto.getLseq()).forward(request, response);
	}

}
