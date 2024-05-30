package com.miniproject.phonetail.controller.action.admin;

import java.io.IOException;
import com.miniproject.phonetail.DAO.AdminDAO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.controller.action.Action;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminUserStateChangeBAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid"); // 사용자 아이디 가져오기
        System.out.println("AdminUserStateChangeBAction - userid: " + userid); // 로그 추가
        
        // 사용자 아이디를 기반으로 회원 상태를 변경
        AdminDAO adao = AdminDAO.getInstance();
        String result = adao.adminUserStateChangeB(userid);
        
        if (result.equals("success")) { // 변경이 성공했을 때
            // 세션에 변경된 회원 상태 정보 저장
            HttpSession session = request.getSession();
            MemberDTO mdto = new MemberDTO();
            mdto.setUserid(userid);
            mdto.setUserstate("B");
            session.setAttribute("adminUserStateChangeB", mdto);
            System.out.println("(액션)다음 회원을 블랙리스트에 올린다 userid: " + userid); // 로그 추가
        } else {
            System.out.println("(액션)다음 회원을 블랙리스트에 올리는 데에 실패했다 userid: " + userid); // 로그 추가
        }
        
        // 회원 목록 페이지로 이동
        RequestDispatcher dp = request.getRequestDispatcher("phonetail.do?command=adminMemberList");
        dp.forward(request, response);
    }
}
