package com.miniproject.phonetail.controller.product;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.miniproject.phonetail.DAO.ChatListDAO;
import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DAO.ProductDAO;
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
		
         
        ChatListDAO cdao = ChatListDAO.getInstance();
        Map<Integer, Integer> productChatList = new HashMap<>();
        
        for(ProductDTO product : productList) {
        	int chatCount = cdao.getProductChatList(product.getPseq());
        	if(chatCount != 0) {
        		productChatList.put(product.getPseq(),chatCount);
        	}
        }
        
        // 몇시간 전 게시글인지 띄울 수 있을까?
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Map<Integer, String> timeList = new HashMap<>();
        for(ProductDTO product : productList) {
        	Timestamp timestamp = product.getIndate();
            LocalDateTime productIndate = timestamp.toLocalDateTime();
            Duration duration = Duration.between(productIndate, now);
            int minutes = (int) duration.toMinutes();
            int hours = (int) duration.toHours();
            int days = (int) duration.toDays();
            if(minutes<60) {
                timeList.put(product.getPseq(), minutes+"분 전");
            } else if (hours < 24) { 
                timeList.put(product.getPseq(), hours+"시간 전");
            }else {
            	timeList.put(product.getPseq(), days+"일 전");
            }
            

        }
        

        
        request.setAttribute("timeList", timeList);

        //
        
        request.setAttribute("productChatList", productChatList);
		request.setAttribute("paging", paging);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("product/productList.jsp").forward(request, response);

		

	}

}
