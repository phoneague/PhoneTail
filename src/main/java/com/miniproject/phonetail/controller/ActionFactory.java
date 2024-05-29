package com.miniproject.phonetail.controller;

import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.controller.action.IndexAction;
import com.miniproject.phonetail.controller.action.MainAction;
import com.miniproject.phonetail.controller.action.chat.ChatListAction;
import com.miniproject.phonetail.controller.product.ProductDetailAction;
import com.miniproject.phonetail.controller.product.ProductInsertAction;
import com.miniproject.phonetail.controller.product.ProductInsertFormAction;
import com.miniproject.phonetail.controller.product.ProductListAction;
import com.miniproject.phonetail.controller.product.ProductUpdateAction;
import com.miniproject.phonetail.controller.product.ProductUpdateFormAction;
import com.miniproject.phonetail.controller.action.admin.AdminAction;
import com.miniproject.phonetail.controller.action.admin.AdminLoginAction;
import com.miniproject.phonetail.controller.action.admin.AdminLogoutAction;
import com.miniproject.phonetail.controller.action.admin.AdminReportListAction;
import com.miniproject.phonetail.controller.action.member.FindZipnumAction;
import com.miniproject.phonetail.controller.action.member.IdCheckAction;
import com.miniproject.phonetail.controller.action.member.JoinFormAction;
import com.miniproject.phonetail.controller.action.member.LoginAction;
import com.miniproject.phonetail.controller.action.member.LoginFormAction;
import com.miniproject.phonetail.controller.action.member.LogoutAction;


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
		else if(command.equals("findZipnum")) ac = new FindZipnumAction();
		else if(command.equals("idcheck")) ac = new IdCheckAction();
    
    
		//admin
		else if(command.equals("admin")) ac = new AdminAction();
		else if(command.equals("adminLogin")) ac = new AdminLoginAction();
		else if(command.equals("adminLogout")) ac = new AdminLogoutAction();
		else if(command.equals("adminReportList")) ac = new AdminReportListAction();
		
	
		// chat 
		else if(command.equals("chatList")) ac = new ChatListAction(); 
		
		//product (정빈)
		else if(command.equals("productList")) ac = new ProductListAction();
		else if(command.equals("productDetail")) ac = new ProductDetailAction();
		else if(command.equals("productInsertForm")) ac = new ProductInsertFormAction();
		else if(command.equals("productInsert")) ac = new ProductInsertAction();
		else if(command.equals("productUpdate")) ac = new ProductUpdateAction();
		else if(command.equals("productUpdateForm")) ac = new ProductUpdateFormAction();

		
		return ac;
	}
	
}
