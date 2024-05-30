package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.miniproject.phonetail.DTO.ReportDTO;
import com.miniproject.phonetail.util.DB;

public class ReportDAO {
	private ReportDAO() {}
	private static ReportDAO itc = new ReportDAO();
	public static ReportDAO getInstace() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertReport(ReportDTO rdto) {
		con = DB.getConnection();
		String sql = "insert into report(pseq,recontent,userid,retype) values(?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getPseq());
			pstmt.setString(2, rdto.getRecontent());
			pstmt.setString(3, rdto.getUserid());
			pstmt.setInt(4, rdto.getRetype());
			pstmt.executeUpdate();
		}catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);  }
		
	}
	
}
