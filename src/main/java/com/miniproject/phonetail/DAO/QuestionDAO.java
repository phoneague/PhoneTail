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
	    	
	    	public ArrayList<QuestionDTO> getAllQuestions(Paging paging, String key) {
	    	    ArrayList<QuestionDTO> questionList = new ArrayList<>();

	    	    try {
	    	        con = DB.getConnection();
	    	        String sql = "SELECT * FROM question WHERE (userid LIKE CONCAT('%',?,'%') OR title LIKE CONCAT('%',?,'%') OR content LIKE CONCAT('%',?,'%')) "
	    	                   + "ORDER BY indate DESC, qseq DESC LIMIT ? OFFSET ?";
	    	        pstmt = con.prepareStatement(sql);
	    	        pstmt.setString(1, key);
	    	        pstmt.setString(2, key);
	    	        pstmt.setString(3, key);
	    	        pstmt.setInt(4, paging.getDisplayRow());
	    	        pstmt.setInt(5, paging.getStartNum() - 1);
	    	        rs = pstmt.executeQuery();
	    	        while (rs.next()) {
	    	            QuestionDTO question = new QuestionDTO();
	    	            question.setQseq(rs.getInt("qseq"));
	    	            question.setUserid(rs.getString("userid"));
	    	            question.setTitle(rs.getString("title"));
	    	            question.setIndate(rs.getTimestamp("indate"));
	    	            question.setContent(rs.getString("content"));
	    	            question.setReadCount(rs.getInt("readCount"));
	    	            question.setQreply(rs.getString("qreply"));
	    	            question.setSecret(rs.getBoolean("secret"));

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
						question.setReadCount(rs.getInt("readCount"));
						question.setQreply(rs.getString("qreply"));
						question.setSecret(rs.getBoolean("secret"));
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
				String sql = "INSERT INTO question (title, content, userid, qreply, secret) VALUES (?, ?, ? ,? ,?)";
				con = DB.getConnection();
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, qdto.getTitle());
					pstmt.setString(2, qdto.getContent());
					pstmt.setString(3, qdto.getUserid());
					pstmt.setString(4, "" );
					pstmt.setBoolean(5, qdto.getSecret());
					pstmt.executeUpdate();
				} catch (SQLException e) { e.printStackTrace();
				} finally { DB.close(con, pstmt, rs); }	
				
			}

			public void deleteQna(int qseq) {
				
				String sql = "DELETE FROM question WHERE qseq = ?";
				con = DB.getConnection();
				 try {
				        pstmt = con.prepareStatement(sql);
				        pstmt.setInt(1, qseq);
				        pstmt.executeUpdate();
				    } catch (SQLException e) { e.printStackTrace();
				    } finally { DB.close(con, pstmt, rs); }	
				}		

			public int getMyAllCount(String tablename, String myId, String fieldname, String key) {
				int count = 0;
				con = DB.getConnection();
				String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE " + fieldname + " LIKE CONCAT('%', ?, '%') AND userid LIKE ?";
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, key);
					pstmt.setString(2, myId);
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
            
			public ArrayList<QuestionDTO> getMyAllQuestions(Paging paging, String key, String myId) {
				ArrayList<QuestionDTO> questionList = new ArrayList<>();
		        try {
		            con = DB.getConnection();
		            String sql =  "SELECT * FROM question WHERE title LIKE CONCAT('%',?,'%') AND userid LIKE ? "
		    				+ " ORDER BY indate DESC, qseq DESC LIMIT ? OFFSET ?";
		        	pstmt = con.prepareStatement(sql);
					pstmt.setString(1, key);
					pstmt.setString(2, myId);
					pstmt.setInt(3, paging.getDisplayRow());
					pstmt.setInt(4, paging.getStartNum() - 1);
		            rs = pstmt.executeQuery();
		            while (rs.next()) {
		                QuestionDTO question = new QuestionDTO();
		                question.setQseq(rs.getInt("qseq"));
		                question.setUserid(rs.getString("userid"));
		                question.setTitle(rs.getString("title"));
		                question.setIndate(rs.getTimestamp("indate"));
		                question.setContent(rs.getString("content"));
		                question.setQreply(rs.getString("qreply"));
		                question.setSecret(rs.getBoolean("secret"));

		                questionList.add(question);
		            }
		        } catch (SQLException e) { e.printStackTrace();
		        } finally { DB.close(con, pstmt, rs); }

		          return questionList;
			}
			
			public void updateReadCount(int qseq) {
				String sql = "UPDATE question SET readCount = readCount + 1 WHERE qseq = ?";
			    try {
			    	     con = DB.getConnection();
			    		 pstmt = con.prepareStatement(sql);
			             pstmt.setInt(1, qseq);
			             pstmt.executeUpdate();
			    } catch (SQLException e) { e.printStackTrace();
			    } finally { DB.close(con, pstmt, rs); }
			}

}		






	

	