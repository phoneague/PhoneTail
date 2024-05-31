package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InsertChatListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChatListDAO cdao = ChatListDAO.getInstance();
		ChatListDTO cdto = new ChatListDTO();
		ProductDAO pdao = ProductDAO.getInstance();
		ProductDTO pdto = pdao.getProduct(Integer.parseInt(request.getParameter("pseq")));
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		
		if(mdto.getUserid()=="a"){
			
		}else {
			cdto.setBid(mdto.getUserid());
			System.out.println( "userid : " + mdto.getUserid());
			cdto.setPseq(Integer.parseInt(request.getParameter("pseq")));
			cdto.setPrice(pdto.getPrice());
			cdto.setModel(pdto.getModel());
			cdto.setSid(pdto.getUserid());
			cdao.insertChatList(cdto);
			request.setAttribute("loginUser", mdto.getUserid());
			response.sendRedirect("phonetail.do?command=chatList");
		}
	}

}
