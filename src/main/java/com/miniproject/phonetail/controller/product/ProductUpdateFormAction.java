package com.miniproject.phonetail.controller.product;

import java.io.IOException;

import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProductUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO)session.getAttribute("login");
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		
		
		ProductDAO pdao = ProductDAO.getInstance();
		ProductDTO pdto = pdao.getProduct(pseq);
		request.setAttribute("ProductDTO", pdto);
		
		
		if( mdto == null) {
			response.sendRedirect("phonetail.do?command=loginForm");
		} else {
			String[] brandList = {"Sansung","Apple","LG"};
			request.setAttribute("brandList", brandList);
			request.setAttribute("loginUser", mdto.getUserid());
			
			request.getRequestDispatcher("product/productUpdate.jsp").forward(request, response);

		}
	}

}
