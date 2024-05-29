package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.QuestionDTO;
import com.miniproject.phonetail.util.DB;

public class QuestionDAO {
 

	private QuestionDAO() {}
	private static QuestionDAO ist = new QuestionDAO();
	public static QuestionDAO getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int getAllCount() {
			int count = 0;
			con = DB.getConnection();
			String sql = "select count(*) as cnt from qna";
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) count = rs.getInt("cnt");
			} catch (SQLException e) { e.printStackTrace();
			} finally { DB.close(con, pstmt, rs); }	
			
			return count;
	}

	public QuestionDTO getQna(int qseq) {
		
		QuestionDTO qvo = new QuestionDTO();
		String sql = "select * from qna where qseq=?";
		con = DB.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				qvo.setQseq(qseq);
				qvo.setContent(rs.getString("content"));
				qvo.setUserid(rs.getString("userid"));
				qvo.setIndate(rs.getDate("indate"));
				qvo.setQreply(rs.getString("qreply"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs); }	
		return qvo;
	}

	public void insertQna(QuestionDTO qvo) {
		
		String sql = "insert into qna (content, userid) values (?, ?)";
		con = DB.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getContent());
			pstmt.setString(2, qvo.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs); }	
		
	}
}
