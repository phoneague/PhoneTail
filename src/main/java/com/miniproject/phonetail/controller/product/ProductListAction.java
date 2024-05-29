package com.miniproject.phonetail.controller.product;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDAO pdao = ProductDAO.getInstance();
		
		
		ArrayList<ProductDTO> list = pdao.selectBrandProduct();
		
		request.setAttribute("productList", list);
		
	
		request.getRequestDispatcher("product/productList.jsp").forward(request, response);

		

	}

}
