package com.miniproject.phonetail.controller.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductDetailAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pseq = Integer.parseInt(request.getParameter("pseq"));

        ProductDAO pdao = ProductDAO.getInstance();
        pdao.updateReadcount(pseq);
		
        ProductDTO pdto = pdao.getProduct(pseq);

        request.setAttribute("productDTO", pdto);

        MemberDAO mdao = MemberDAO.getInstance();
        Map<String, String> userStates = new HashMap<>();

        if (pdto != null) {
            MemberDTO member = mdao.getMember(pdto.getUserid());
            if (member != null) {
                userStates.put(pdto.getUserid(), member.getUserstate());
            }
        }
        
        String pmessage = (String)request.getAttribute("pmessage");
        request.setAttribute("pmessage", pmessage);
        
        request.setAttribute("userStates", userStates);
        request.getRequestDispatcher("product/productDetail.jsp").forward(request, response);

    }

}
