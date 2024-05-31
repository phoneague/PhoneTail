package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.ReportDTO;
import com.miniproject.phonetail.util.DB;
import com.miniproject.phonetail.util.Paging;

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

	public ReportDTO getReport(int reseq) {
		ReportDTO rdto = new ReportDTO();
		String sql = "SELECT r.*, p.userid AS pid FROM report r JOIN product p ON r.pseq = p.pseq WHERE r.reseq = ?;";
		con = DB.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				rdto.setReseq(reseq);
				rdto.setPseq(rs.getInt("pseq"));
				rdto.setUserid(rs.getString("userid"));
				rdto.setRetype(rs.getInt("retype"));
				rdto.setRecontent(rs.getString("recontent"));
				rdto.setRestate(rs.getString("restate"));
				rdto.setIndate(rs.getTimestamp("indate"));
				rdto.setPid(rs.getString("pid"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs); }	
		return rdto;
	}

	public void updateReport(String restate, int reseq) {
		con = DB.getConnection();
		String sql = "UPDATE report SET restate=? WHERE reseq=? ";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, restate);
			pstmt.setInt(2, reseq);
			pstmt.executeUpdate();
		}catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);  }
	}

	public int getMyAllCount(String tablename, String myId) {
		int count = 0;
		con = DB.getConnection();
		String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE userid LIKE ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, myId);
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

	public ArrayList<ReportDTO> myReportList(Paging paging, String myId) {
		ArrayList<ReportDTO>list = new ArrayList<>();
		con = DB.getConnection();
		String sql = "SELECT * FROM report WHERE userid LIKE ? "
				+ " ORDER BY restate DESC, reseq DESC LIMIT ? OFFSET ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, myId);
			pstmt.setInt(2, paging.getDisplayRow());
			pstmt.setInt(3, paging.getStartNum() - 1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReportDTO rdto = new ReportDTO();
				rdto.setReseq(rs.getInt("reseq"));	
				rdto.setPseq(rs.getInt("pseq"));	
				rdto.setUserid(rs.getString("userid"));	
				rdto.setRetype(rs.getInt("retype"));	
				rdto.setRecontent(rs.getString("recontent"));	
				rdto.setRestate(rs.getString("restate"));	
				rdto.setIndate(rs.getTimestamp("indate"));	
//				System.out.println(rdto.toString());
				list.add(rdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
		return list;
	}

	
	
}
