package com.miniproject.phonetail.controller;

import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.controller.action.IndexAction;
import com.miniproject.phonetail.controller.action.MainAction;
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
		System.out.println("af 생성");
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
		
		return ac;
	}
	
}
