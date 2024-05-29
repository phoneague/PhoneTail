package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.util.DB;

public class ChatListDAO {

	private ChatListDAO() {}
	private static ChatListDAO itc = new ChatListDAO();
	public static ChatListDAO getInstance() {return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ChatListDTO> getAllList() {
		ArrayList<ChatListDTO> list = new ArrayList<ChatListDTO>();
		con = DB.getConnection();
		//String sql = "select "
		return list;
	}
	
	
}
