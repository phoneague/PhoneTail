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
		
		ProductDAO pdao = ProductDAO.getInstance();
		int check = pdao.checkWant(pseq, userid);
		if(check==0) {
			pdao.insertWant(pseq, userid);
			pdao.updateWantCount(pseq);
		} else {
			request.setAttribute("message", "이미 찜함");
			System.out.println("이미찜함");
		}
		response.sendRedirect("phonetail.do?command=productDetail&pseq=" + pseq);
		
		
	}

}
