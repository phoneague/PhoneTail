package com.miniproject.phonetail.controller.action.chat;

import java.io.IOException;
import java.util.Date;

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
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		ProductDAO pdao = ProductDAO.getInstance();
		ProductDTO pdto = pdao.getProduct(Integer.parseInt(request.getParameter("pseq")));
		ChatListDTO fdto = cdao.filter(pdto.getPseq(), mdto.getUserid());
		
		if(fdto.getBid()=="hakhyun" && fdto.getPseq()==980623){
			ChatListDTO cdto = new ChatListDTO();
			cdto.setBid(mdto.getUserid());
			cdto.setPseq(Integer.parseInt(request.getParameter("pseq")));
			cdto.setPrice(pdto.getPrice());
			cdto.setModel(pdto.getModel());
			cdto.setSid(pdto.getUserid());
			cdto.setContent(null);
			java.sql.Timestamp now = new java.sql.Timestamp(new Date().getTime());
			cdto.setIndate(now);
			cdao.insertChatList(cdto);
			request.setAttribute("loginUser", mdto.getUserid());
			response.sendRedirect("phonetail.do?command=gochatList");
		}else {
			response.sendRedirect("phonetail.do?command=chating&lseq="+fdto.getLseq());
		}
		
	}
}