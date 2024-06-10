package com.miniproject.phonetail.controller.product;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductWantAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		String userid = request.getParameter("userid");
		
		String url ="phonetail.do?command=productDetail";
		request.setAttribute("pseq", pseq);
		
		ProductDAO pdao = ProductDAO.getInstance();
		int check = pdao.checkWant(pseq, userid);
		if(check==0) {
			pdao.insertWant(pseq, userid);
			pdao.updateWantCount(pseq);
			request.setAttribute("pmessage", "찜하기 성공!");
		} else {
			request.setAttribute("pmessage", "이미 찜하신 제품입니다.");
		}
		 request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
