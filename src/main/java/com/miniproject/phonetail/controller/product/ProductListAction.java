package com.miniproject.phonetail.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.util.Paging;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int page=1;
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		}else if(session.getAttribute("page")!=null) {
			page=(Integer)session.getAttribute("page");
		}else {
			session.removeAttribute("page");
		}
		
		String key="";
		if(request.getParameter("key")!=null) {
			key=request.getParameter("key");
			session.setAttribute("key",key);
		}else if(session.getAttribute("key") !=null) {
			key = (String)session.getAttribute("key");
		}else {
			session.removeAttribute("key");
		}
		
		String brand="";
		if(request.getParameter("brand")!=null) {
			brand=request.getParameter("brand");
			session.setAttribute("brand",brand);
		}else if(session.getAttribute("brand") !=null) {
			brand = (String)session.getAttribute("brand");
		}else {
			session.removeAttribute("brand");
		}
		
		String sellstate="";
		if(request.getParameter("sellstate")!=null) {
			sellstate=request.getParameter("sellstate");
			session.setAttribute("sellstate",sellstate);
		}else if(session.getAttribute("sellstate") !=null) {
			sellstate = (String)session.getAttribute("sellstate");
		}else {
			session.removeAttribute("sellstate");
		}
		System.out.println(sellstate);
		
		
		Paging paging = new Paging();
		paging.setPage(page);
		paging.setDisplayRow(20);
		
		
		ProductDAO pdao = ProductDAO.getInstance();
		ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		int count = pdao.getAllCount("product", "model", key, brand, sellstate);
		paging.setTotalCount(count);
		productList = pdao.productList(paging, key, brand, sellstate);
		
		
		MemberDAO mdao = MemberDAO.getInstance();
        Map<String, String> userStates = new HashMap<>();
        
        for (ProductDTO product : productList) {
            MemberDTO member = mdao.getMember(product.getUserid());
            if (member != null) {
                userStates.put(product.getUserid(), member.getUserstate());
            }
        }
        
        ChatListDAO cdao = ChatListDAO.getInstance();
        Map<Integer, Integer> productChatList = new HashMap<>();
        
        for(ProductDTO product : productList) {
        	int chatCount = cdao.getProductChatList(product.getPseq());
        	if(chatCount != 0) {
        		productChatList.put(product.getPseq(),chatCount);
        	}
        }
        
        // soldview 변수를 확인해서 sell이면 판매중, sold면 판매완료 상품만 보여주기

        
        
        
        request.setAttribute("productChatList", productChatList);
		request.setAttribute("userStates", userStates);
		request.setAttribute("paging", paging);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("product/productList.jsp").forward(request, response);

		

	}

}
