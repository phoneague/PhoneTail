package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.AdminDTO;
import com.miniproject.phonetail.DTO.ReportDTO;
import com.miniproject.phonetail.util.DB;
import com.miniproject.phonetail.util.Paging;

public class AdminDAO {
	private AdminDAO() {}
	private static AdminDAO itc = new AdminDAO();
	public static AdminDAO getInstance() {
		return itc;
	}
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminDTO getMember(String adminid) {
		AdminDTO adto = null;
		con = DB.getConnection();
		String sql = "SELECT * FROM admin WHERE adminid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				adto = new AdminDTO();
				adto.setAdminid(rs.getString("adminid"));
				adto.setPwd(rs.getString("pwd"));
				adto.setName(rs.getString("pwd"));
				adto.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}

		return adto;
	}

	public int getAllCount(String tablename, String fieldname, String key) {
		int count = 0;
		con = DB.getConnection();
		String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE " + fieldname + " LIKE CONCAT('%', ?, '%')";
		// 검색어가 '부츠' CONCAT의 결과 '%부츠%' -> 부츠를 포함한 상품명 검색
		// 검색어가 '' CONCAT의 결과 '%%' -> 모두검색
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

	public ArrayList<ReportDTO> adminReportList(Paging paging, String key) {
		ArrayList<ReportDTO>list = new ArrayList<>();
		con = DB.getConnection();
		String sql = "SELECT * FROM report WHERE userid LIKE CONCAT('%',?,'%') "
				+ " ORDER BY restate DESC LIMIT ? OFFSET ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
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
				System.out.println(rdto.toString());
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
