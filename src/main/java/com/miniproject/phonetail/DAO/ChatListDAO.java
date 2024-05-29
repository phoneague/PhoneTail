package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.util.DB;

public class ChatListDAO {

	private ChatListDAO() {
	}

	private static ChatListDAO itc = new ChatListDAO();

	public static ChatListDAO getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<ChatListDTO> getAllList() {
		ArrayList<ChatListDTO> list = new ArrayList<ChatListDTO>();
		con = DB.getConnection();
		String sql = "select * from chatlist order by lseq desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ChatListDTO cdto = new ChatListDTO();
				cdto.setLseq(rs.getInt("lseq"));
				cdto.setSid(rs.getString("sid"));
				cdto.setBid(rs.getString("bid"));
				// cdto.setModel(rs.getString("model"));
				cdto.setPseq(rs.getInt("pseq"));
				cdto.setIndate(rs.getTimestamp("indate"));

				list.add(cdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {	DB.close(con, pstmt, rs);	}
		return list;
	}
	
	 /* public ChatListDTO getChatList(int lseq) { 
		  ChatListDTO cdto = null; 
		  con =  DB.getConnection();
		  String sql = "select * from chatlist where lseq=?"; 
		  try {
			  pstmt = con.prepareStatement(sql); 
			  pstmt.setInt(1, lseq); 
			  rs = pstmt.executeQuery();
			  while(rs.next()) { 
				  cdto = new ChatListDTO();
				  cdto.setLseq(rs.getInt("lseq")); 
				  cdto.setPseq(rs.getInt("pseq"));
				  cdto.setSid(rs.getString("userid"));
				  cdto.setBid(rs.getString("userid"));
				  cdto.setmodel(rs.getString("model"));
				  cdto.setIndate(rs.getTimestamp("indate")); } 
			  } catch (SQLException e) {e.printStackTrace(); 
			  } finally { DB.close(con, pstmt, rs);} 
		  } */
	 
}
