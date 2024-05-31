package com.miniproject.phonetail.controller;

import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.controller.action.IndexAction;
import com.miniproject.phonetail.controller.action.MainAction;
import com.miniproject.phonetail.controller.customer.DeleteQnaForm;
import com.miniproject.phonetail.controller.customer.QnaListAction;
import com.miniproject.phonetail.controller.customer.QnaViewAction;
import com.miniproject.phonetail.controller.customer.WriteQnaAction;
import com.miniproject.phonetail.controller.customer.WriteQnaFormAction;
import com.miniproject.phonetail.controller.mypage.MyPageAction;
import com.miniproject.phonetail.controller.action.chat.ChatListAction;
import com.miniproject.phonetail.controller.action.chat.ChatingAction;
import com.miniproject.phonetail.controller.action.chat.InsertChatAction;
import com.miniproject.phonetail.controller.action.chat.InsertChatListAction;
import com.miniproject.phonetail.controller.product.ProductDetailAction;
import com.miniproject.phonetail.controller.product.ProductInsertAction;
import com.miniproject.phonetail.controller.product.ProductInsertFormAction;
import com.miniproject.phonetail.controller.product.ProductListAction;
import com.miniproject.phonetail.controller.product.ProductUpdateAction;
import com.miniproject.phonetail.controller.product.ProductUpdateFormAction;
import com.miniproject.phonetail.controller.action.admin.AdminAction;
import com.miniproject.phonetail.controller.action.admin.AdminLoginAction;
import com.miniproject.phonetail.controller.action.admin.AdminLogoutAction;
import com.miniproject.phonetail.controller.action.admin.AdminMemberListAction;
import com.miniproject.phonetail.controller.action.admin.AdminQnaListAction;
import com.miniproject.phonetail.controller.action.admin.AdminQnaReplyAction;
import com.miniproject.phonetail.controller.action.admin.AdminQnaReplyFormAction;
import com.miniproject.phonetail.controller.action.admin.AdminReportListAction;
import com.miniproject.phonetail.controller.action.admin.AdminUserStateChangeBAction;
import com.miniproject.phonetail.controller.action.member.DeleteMemberAction;
import com.miniproject.phonetail.controller.action.member.FindZipNumAction;
import com.miniproject.phonetail.controller.action.member.IdCheckAction;
import com.miniproject.phonetail.controller.action.member.JoinAction;
import com.miniproject.phonetail.controller.action.member.JoinFormAction;
import com.miniproject.phonetail.controller.action.member.LoginAction;
import com.miniproject.phonetail.controller.action.member.LoginFormAction;
import com.miniproject.phonetail.controller.action.member.LogoutAction;
import com.miniproject.phonetail.controller.action.member.UpdateMemberAction;
import com.miniproject.phonetail.controller.action.member.UpdateMemberFormAction;
import com.miniproject.phonetail.controller.action.report.ProcessReportAction;
import com.miniproject.phonetail.controller.action.report.ReportAction;
import com.miniproject.phonetail.controller.action.report.ReportFormAction;
import com.miniproject.phonetail.controller.action.report.ReportViewAction;


public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {
//		System.out.println("af 생성");
		return itc;
		}
	
	public Action getAction(String command) {
		Action ac = null;
		System.out.println("command : "+command);
		if( command.equals("index") ) ac = new IndexAction();
		else if(command.equals("main")) ac = new MainAction();
		
		// member
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("findZipnum")) ac = new FindZipNumAction();
		else if(command.equals("idcheck")) ac = new IdCheckAction();
		else if(command.equals("deleteMember")) ac = new DeleteMemberAction();
		else if(command.equals("updateMemberForm")) ac = new UpdateMemberFormAction();
		else if(command.equals("updateMember")) ac = new UpdateMemberAction();
		
		// customer
		else if(command.equals("qnaList"))ac = new QnaListAction();
		else if(command.equals("qnaView"))ac = new QnaViewAction();
		else if(command.equals("writeQnaForm"))ac = new WriteQnaFormAction();
		else if(command.equals("writeQna"))ac = new WriteQnaAction();
		else if(command.equals("deleteQnaForm"))ac = new DeleteQnaForm();
    
		//admin
		else if(command.equals("admin")) ac = new AdminAction();
		else if(command.equals("adminLogin")) ac = new AdminLoginAction();
		else if(command.equals("adminLogout")) ac = new AdminLogoutAction();
		else if(command.equals("adminReportList")) ac = new AdminReportListAction();
		else if(command.equals("adminQnaList")) ac = new AdminQnaListAction();
		else if(command.equals("adminQnaReplyForm")) ac = new AdminQnaReplyFormAction();
		else if(command.equals("adminQnaReply")) ac = new AdminQnaReplyAction();
		else if(command.equals("adminMemberList")) ac = new AdminMemberListAction();
		else if(command.equals("adminUserStateChangeB")) ac = new AdminUserStateChangeBAction();
		
		
	
		// chat 
		else if(command.equals("chatList")) ac = new ChatListAction(); 
		else if(command.equals("chating")) ac = new ChatingAction();
		else if(command.equals("insertChat")) ac = new InsertChatAction(); //채팅 내용 추가되는거
		else if(command.equals("insertChatList")) ac = new InsertChatListAction();
		
		//product (정빈)
		else if(command.equals("productList")) ac = new ProductListAction();
		else if(command.equals("productDetail")) ac = new ProductDetailAction();
		else if(command.equals("productInsertForm")) ac = new ProductInsertFormAction();
		else if(command.equals("productInsert")) ac = new ProductInsertAction();
		else if(command.equals("productUpdate")) ac = new ProductUpdateAction();
		else if(command.equals("productUpdateForm")) ac = new ProductUpdateFormAction();
		
		//report
		else if(command.equals("reportForm")) ac = new ReportFormAction();
		else if(command.equals("report")) ac = new ReportAction();
		else if(command.equals("reportView")) ac = new ReportViewAction();
		else if(command.equals("processReport")) ac = new ProcessReportAction();
		
		
		// mypage
		else if(command.equals("mypage")) ac = new MyPageAction();
		
		return ac;
	}
	
}
