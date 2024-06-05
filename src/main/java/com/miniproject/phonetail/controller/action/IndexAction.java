package com.miniproject.phonetail.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.ProductDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO pdao = ProductDAO.getInstance();
		ArrayList<ProductDTO> newlist = pdao.newList();
		
		request.setAttribute("newList", newlist);		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
