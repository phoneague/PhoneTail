package com.miniproject.phonetail.controller.action.member;

import java.io.IOException;
import java.util.ArrayList;

import com.miniproject.phonetail.DAO.MemberDAO;
import com.miniproject.phonetail.DTO.AddressDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dong = request.getParameter("dong");
		if( dong != null ) {
			if( dong.equals("") == false ) {
				MemberDAO mdao = MemberDAO.getInstance();
				ArrayList<AddressDTO> list = mdao.selectAddressByDong(dong);
				request.setAttribute("addressList" , list);
			}
		}
		request.getRequestDispatcher("member/findZipNum.jsp").forward(request, response); 

	}

}
