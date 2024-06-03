package com.miniproject.phonetail.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import com.miniproject.phonetail.DAO.ProductDAO;
import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.controller.action.Action;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

public class ProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pseq = Integer.parseInt( request.getParameter("pseq") );

		
		ProductDTO pdto = new ProductDTO();
		System.out.println("업데이트에서 상품번호 전달 확인" + pseq);
		pdto.setPseq(Integer.parseInt(request.getParameter("pseq")));
		pdto.setBrand(request.getParameter("brand"));
		pdto.setSeries(request.getParameter("series"));
		pdto.setModel(request.getParameter("model"));
		pdto.setPrice(Integer.parseInt(request.getParameter("price")));
		pdto.setComment(request.getParameter("comment"));
		pdto.setUserid(request.getParameter("userid"));

		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath("product/images");

		File uploadDir = new File(uploadFilePath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		String fileName = "";
		String saveimagefile = "";
		for (Part p : request.getParts()) {
			fileName = "";
			for (String content : p.getHeader("content-disposition").split(";")) {
				if (content.trim().startsWith("filename")) {
					fileName = content.substring(content.indexOf("=") + 2, content.length() - 1);
					System.out.println("fileName : " + fileName);
					if (!fileName.equals("")) {
						Calendar today = Calendar.getInstance();
						long dt = today.getTimeInMillis();
						String fn1 = fileName.substring(0, fileName.indexOf("."));
						String fn2 = fileName.substring(fileName.indexOf("."));
						saveimagefile = fn1 + dt + fn2;
						p.write(uploadFilePath + File.separator + saveimagefile); // 파일 저장
						pdto.setImage(fileName);
						pdto.setSaveimagefile(saveimagefile);
					} else {
						pdto.setImage(request.getParameter("oldimage"));
						pdto.setSaveimagefile(request.getParameter("oldsaveimagefile"));
					}
				}
			}
		}
		ProductDAO pdao = ProductDAO.getInstance();
		pdao.updateProduct(pdto);
		response.sendRedirect("phonetail.do?command=productDetail&pseq=" + pdto.getPseq());
	}

}