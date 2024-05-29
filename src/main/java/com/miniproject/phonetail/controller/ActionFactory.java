package com.miniproject.phonetail.controller;

import com.miniproject.phonetail.controller.action.Action;
import com.miniproject.phonetail.controller.action.IndexAction;
import com.miniproject.phonetail.controller.action.LoginAction;
import com.miniproject.phonetail.controller.action.LoginFormAction;
import com.miniproject.phonetail.controller.action.MainAction;
import com.miniproject.phonetail.controller.product.ProductDetailAction;
import com.miniproject.phonetail.controller.product.ProductInsertAction;
import com.miniproject.phonetail.controller.product.ProductInsertFormAction;
import com.miniproject.phonetail.controller.product.ProductListAction;
import com.miniproject.phonetail.controller.product.ProductUpdateAction;
import com.miniproject.phonetail.controller.product.ProductUpdateFormAction;


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
