package com.miniproject.phonetail.controller.mypage;

import java.io.IOException;

import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

	    	request.getRequestDispatcher("mypage/mypage.jsp").forward(request, response);
	    	
	   
	}
}
