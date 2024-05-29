package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.miniproject.phonetail.DTO.QuestionDTO;
import com.miniproject.phonetail.util.DB;

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
		    public ArrayList<QuestionDTO> getAllQuestions() {
		        ArrayList<QuestionDTO> questionList = new ArrayList<>();

		        try {
		            con = DB.getConnection();
		            String sql = "SELECT * FROM question ORDER BY indate DESC";
		            pstmt = con.prepareStatement(sql);
		            rs = pstmt.executeQuery();

		            while (rs.next()) {
		                QuestionDTO question = new QuestionDTO();
		                question.setQseq(rs.getInt("qseq"));
		                question.setUserid(rs.getString("userid"));
		                question.setTitle(rs.getString("title"));
		                question.setIndate(rs.getTimestamp("indate"));
		                question.setContent(rs.getString("content"));
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
						question.setContent(rs.getString("content"));
						question.setIndate(rs.getTimestamp("indate"));
						question.setQreply(rs.getString("qreply"));
					}
				} catch (SQLException e) { e.printStackTrace();
				} finally { DB.close(con, pstmt, rs); }	
				return question;
			}
			}







	

	