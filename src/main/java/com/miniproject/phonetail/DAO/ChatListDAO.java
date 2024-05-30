package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.ChatListDTO;
import com.miniproject.phonetail.DTO.ChatingDTO;
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
	
	  public ChatListDTO getChatList(int lseq) { 
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
				  cdto.setModel(rs.getString("model"));
				  cdto.setIndate(rs.getTimestamp("indate")); } 
			  } catch (SQLException e) {e.printStackTrace(); 
			  } finally { DB.close(con, pstmt, rs);} 
		  	return cdto;
		  }
	 
	  public ArrayList<ChatingDTO> getChating(int num) {
			ArrayList<ChatingDTO> list = new ArrayList<ChatingDTO>();
			con = DB.getConnection();
			String sql = "select * from chat where lseq=? order by cseq asc";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ChatingDTO cdto = new ChatingDTO();
					cdto.setCseq( rs.getInt("cseq") );
					cdto.setLseq( rs.getInt("lseq") );
					cdto.setUserid( rs.getString("userid") );
					cdto.setContent( rs.getString("content") );
					cdto.setIndate( rs.getTimestamp("indate") );
					list.add(cdto);
				}
			} catch (SQLException e) { e.printStackTrace();
			}finally { DB.close(con, pstmt, rs);	 }	
			
			return list;
		}

	public void insertReply(ChatingDTO cdto) {
		con = DB.getConnection();
		String sql = "insert into chat( lseq, userid, content) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cdto.getLseq());
			pstmt.setString(2, cdto.getUserid());
			pstmt.setString(3, cdto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {DB.close(con, pstmt, rs);}
	}
}
