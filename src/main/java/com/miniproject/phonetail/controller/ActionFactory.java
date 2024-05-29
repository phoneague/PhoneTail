package com.miniproject.phonetail.controller;

import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.controller.action.IndexAction;
import com.miniproject.phonetail.controller.action.LoginAction;
import com.miniproject.phonetail.controller.action.LoginFormAction;
import com.miniproject.phonetail.controller.action.MainAction;
import com.miniproject.phonetail.controller.customer.QnaListAction;
import com.miniproject.phonetail.controller.customer.QnaViewAction;
import com.miniproject.phonetail.controller.customer.WriteQnaAction;
import com.miniproject.phonetail.controller.customer.WriteQnaFormAction;


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
		else if(command.equals("loginForm")) ac = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		
		// customer
		else if(command.equals("qnaList"))ac = new QnaListAction();
		else if(command.equals("qnaView"))ac = new QnaViewAction();
		else if(command.equals("writeQnaForm"))ac = new WriteQnaFormAction();
		else if(command.equals("writeQna"))ac = new WriteQnaAction();
	
		return ac;
	}
	
}
