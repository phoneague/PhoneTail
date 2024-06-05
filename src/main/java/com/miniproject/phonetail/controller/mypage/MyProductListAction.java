package com.miniproject.phonetail.controller.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

public class MyProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("login");
		if (mdto == null) {
			response.sendRedirect("phonetail.do?command=loginForm");
		} else {
			// 여기서부터 페이지 분할 관련 내용
			int page = 1; // 첫 페이지 시작 번호 설정
			if (request.getParameter("page") != null) { // 받은 페이지가 없다면
				page = Integer.parseInt(request.getParameter("page")); // 페이지를 입력하고
				session.setAttribute("page", page); // 세션에 페이지를 저장
			} else if (session.getAttribute("page") != null) { // 받은 페이지가 있으면
				page = (Integer) session.getAttribute("page"); // 바로 세션에다가 투입
			}

			
			Paging paging = new Paging();
			paging.setPage(page);

			String myId = mdto.getUserid();
			
			ProductDAO pdao = ProductDAO.getInstance();
			int count = pdao.getMyAllcount("product", myId);
			paging.setTotalCount(count);
			if(count==0) {
				 request.setAttribute("message", "내가 등록한 상품이 없습니다.");
			}else {
				ArrayList<ProductDTO> productList = pdao.myProudctList(paging,myId);
				
				request.setAttribute("paging", paging);
				request.setAttribute("productList", productList);
				
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
				request.setAttribute("productChatList", productChatList);
				request.setAttribute("userStates", userStates);
			}
			
			request.getRequestDispatcher("mypage/myProductList.jsp").forward(request, response);
		}
	}

}
