package com.miniproject.phonetail.controller.customer;

import java.io.IOException;

import com.miniproject.phonetail.DAO.QuestionDAO;
import com.miniproject.phonetail.DTO.QuestionDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 내용의 레코드를 추가하고 qnaList 로 되돌아가기
		/*
		 * QuestionDTO qvo = new QuestionDTO();
		 * qvo.setUserid(request.getParameter("userid"));
		 * qvo.setContent(request.getParameter("content"));
		 * 
		 * QuestionDAO qdao = QuestionDAO.getInstance(); qdao.insertQna(qvo);
		 * 
		 * response.sendRedirect("phonetail.do?customer=qnaList");
		 */
			}
	}

