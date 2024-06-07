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

public class GochatListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		String key="";
		ChatListDAO cdao = ChatListDAO.getInstance();
		ArrayList<ChatListDTO> clist = new ArrayList<ChatListDTO>();
		clist = cdao.chatList(key, mdto.getUserid(), mdto.getUserid());
		int maxLseq = Integer.MIN_VALUE; // 최대값을 저장할 변수 초기화

		// clist에서 ChatListDTO 객체를 가져와서 최대값 찾기
		for (ChatListDTO chat : clist) {
		    int lseq = chat.getLseq(); // 각 ChatListDTO 객체의 lseq 값을 가져옴
		    if (lseq > maxLseq) {
		        maxLseq = lseq; // 현재 값이 최대값보다 크면 최대값 업데이트
		    }
		}
		ChatListDTO cdto = cdao.getChatList(maxLseq);
		ArrayList<ChatingDTO> list= cdao.getChating(maxLseq);
		request.setAttribute("loginUser", mdto.getUserid());
		request.setAttribute("chatingList", list);
		request.setAttribute("chatList", cdto);
		request.getRequestDispatcher("chat/Chating.jsp").forward(request, response);
	
		
	}
	
}

	

