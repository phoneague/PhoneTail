package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.miniproject.phonetail.DTO.QuestionDTO;
import com.miniproject.phonetail.util.DB;
import com.miniproject.phonetail.util.Paging;

public class QuestionDAO {

		    private static QuestionDAO instance = new QuestionDAO();

		    private QuestionDAO() {}

		    public static QuestionDAO getInstance() {
		        return instance;
		    }
		    
		    Connection con = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	
		    // 모든 질문을 가져오는 메서드
		    public ArrayList<QuestionDTO> getAllQuestions(Paging paging, String key) {
		        ArrayList<QuestionDTO> questionList = new ArrayList<>();

		        try {
		            con = DB.getConnection();
		            String sql =  "SELECT * FROM question WHERE userid LIKE CONCAT('%',?,'%') "
		    				+ " ORDER BY indate DESC, qseq DESC LIMIT ? OFFSET ?";
		        	pstmt = con.prepareStatement(sql);
					pstmt.setString(1, key);
					pstmt.setInt(2, paging.getDisplayRow());
					pstmt.setInt(3, paging.getStartNum() - 1);
		            rs = pstmt.executeQuery();
		            while (rs.next()) {
		                QuestionDTO question = new QuestionDTO();
		                question.setQseq(rs.getInt("qseq"));
		                question.setUserid(rs.getString("userid"));
		                question.setTitle(rs.getString("title"));
		                question.setIndate(rs.getTimestamp("indate"));
		                question.setContent(rs.getString("content"));
		                question.setQreply(rs.getString("qreply"));
		                // 필요한 다른 속성들도 마찬가지로 설정해주세요.
		                questionList.add(question);
		            }
		        } catch (SQLException e) { e.printStackTrace();
		        } finally { DB.close(con, pstmt, rs); }

		          return questionList;
		    }

			public QuestionDTO getQna(int qseq) {
	
				QuestionDTO question = new QuestionDTO();
				String sql = "SELECT * FROM question WHERE qseq=?";
				con = DB.getConnection();
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, qseq);
					rs = pstmt.executeQuery();
					if( rs.next() ) {
						question.setQseq(qseq);
						question.setUserid(rs.getString("userid"));
						question.setTitle(rs.getString("title"));
						question.setContent(rs.getString("content"));
						question.setIndate(rs.getTimestamp("indate"));
						question.setQreply(rs.getString("qreply"));
					}
				} catch (SQLException e) { e.printStackTrace();
				} finally { DB.close(con, pstmt, rs); }	
				return question;
			}

			public int getAllCount(String tablename, String fieldname, String key) {
				int count = 0;
				con = DB.getConnection();
				String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE " + fieldname + " LIKE CONCAT('%', ?, '%')";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, key);
					rs = pstmt.executeQuery();
					if (rs.next())
						count = rs.getInt("cnt");
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DB.close(con, pstmt, rs);
				}
				return count;
			}

			public void insertQna(QuestionDTO qdto) {
				String sql = "INSERT INTO question (title, content, userid) VALUES (?, ?, ?)";
				con = DB.getConnection();
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, qdto.getTitle());
					pstmt.setString(2, qdto.getContent());
					pstmt.setString(3, qdto.getUserid());
					pstmt.executeUpdate();
				} catch (SQLException e) { e.printStackTrace();
				} finally { DB.close(con, pstmt, rs); }	
				
			}
			
}







	

	