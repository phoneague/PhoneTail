package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.ChatingDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ChatingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int lseq = Integer.parseInt(request.getParameter("lseq"));
		ChatListDAO cdao = ChatListDAO.getInstance();
		ChatListDTO cdto = cdao.getChatList(lseq);
		ArrayList<ChatingDTO> list= cdao.getChating(lseq);
		
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		
			request.setAttribute("chatingList", list);
			request.setAttribute("chatList", cdto);
			request.setAttribute("loginUser", mdto.getUserid());
			request.getRequestDispatcher("chat/Chating.jsp").forward(request, response);
		
			
		
	}

}
