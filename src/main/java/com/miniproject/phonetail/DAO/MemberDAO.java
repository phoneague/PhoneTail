package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.AddressVO;
import com.miniproject.phonetail.DTO.MemberDTO;
import com.miniproject.phonetail.util.DB;

public class MemberDAO {
	
	private MemberDAO() {}
	private static MemberDAO itc = new MemberDAO();
	public static MemberDAO getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDTO getMember(String userid) {
		
		MemberDTO mdto = null;
		con = DB.getConnection();
		String sql = "select * from member where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				mdto = new MemberDTO();
				mdto.setUserid( rs.getString("userid") );
				mdto.setPwd(rs.getString("pwd"));
				mdto.setName(rs.getString("name"));
				mdto.setEmail(rs.getString("email"));
				mdto.setZip_num(rs.getString("zip_num"));
				mdto.setAddress1(rs.getString("address1"));
				mdto.setAddress2(rs.getString("address2"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setUsestate(rs.getString("usestate"));
				mdto.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs); }
		return mdto;
	}

	public ArrayList<AddressVO> selectAddressByDong(String dong) {
		
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		con = DB.getConnection();
		String sql = "select * from address where dong like concat('%', ?, '%') ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
		    while( rs.next() ) {
		    	AddressVO avo = new AddressVO();
		    	avo.setZip_num(rs.getString("zip_num"));
		    	avo.setSido(rs.getString("sido"));
		    	avo.setGugun(rs.getString("gugun"));
		    	avo.setDong(rs.getString("dong"));
		    	avo.setZip_code(rs.getString("zip_code"));
		    	avo.setBunji(rs.getString("bunji"));
		    	list.add(avo);
		    }
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);		}
		return list;
	}
	
}
