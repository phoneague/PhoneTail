package com.miniproject.phonetail.controller.product;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductSoldAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pseq = Integer.parseInt( request.getParameter("pseq"));
		
		ProductDAO pdao = ProductDAO.getInstance();
		pdao.soldProduct(pseq);
		response.sendRedirect("phonetail.do?command=productDetail&pseq=" + pseq);
	}

}
