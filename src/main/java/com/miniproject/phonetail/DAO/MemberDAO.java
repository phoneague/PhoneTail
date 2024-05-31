package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.AddressDTO;
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
				mdto.setAddress1(rs.getString("address1"));
				mdto.setAddress2(rs.getString("address2"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setUserstate(rs.getString("userstate"));
				mdto.setIndate(rs.getTimestamp("indate"));
				System.out.println(mdto.toString());
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs); }
		return mdto;
	}

	public ArrayList<AddressDTO> selectAddressByDong(String dong) {
		
		ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
		con = DB.getConnection();
		String sql = "select * from address where dong like concat('%', ?, '%') ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
		    while( rs.next() ) {
		    	AddressDTO adto = new AddressDTO();
		    	adto.setZip_num(rs.getString("zip_num"));
		    	adto.setSido(rs.getString("sido"));
		    	adto.setGugun(rs.getString("gugun"));
		    	adto.setDong(rs.getString("dong"));
		    	adto.setZip_code(rs.getString("zip_code"));
		    	adto.setBunji(rs.getString("bunji"));
		    	list.add(adto);
		    }
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);		}
		return list;
	}

	public int insertMember(MemberDTO mdto) {
		int result = 0;
		con = DB.getConnection();
		String sql = "insert into member(userid, pwd, name, email, phone, address1, address2) values(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getUserid());
			pstmt.setString(2, mdto.getPwd());
			pstmt.setString(3, mdto.getName());
			pstmt.setString(4, mdto.getEmail());
			pstmt.setString(5, mdto.getPhone());
			pstmt.setString(6, mdto.getAddress1());
			pstmt.setString(7, mdto.getAddress2());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		}  finally { DB.close(con, pstmt, rs);	}
		return result;
	}

	public int deleteMember(String userid) {
		
		int result = 0;
		con = DB.getConnection();
		String sql = "delete from member where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);	}
		return result;
	}

	public int updateMember(MemberDTO mdto) {
		int result = 0;
		con = DB.getConnection();
		String sql = "update member set pwd=?, name=?, email=?, phone=?, address1=?, address2=?  where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getPwd());
			pstmt.setString(2, mdto.getName());
			pstmt.setString(3, mdto.getEmail());
			pstmt.setString(4, mdto.getPhone());
			pstmt.setString(5, mdto.getAddress1());
			pstmt.setString(6, mdto.getAddress2());
			pstmt.setString(7, mdto.getUserid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		}finally { DB.close(con, pstmt, rs);	}
		return result;
	}

	public int stateChangeBtoY(String userid) {
		int result = 0;
		con = DB.getConnection();
		String sql = "UPDATE member SET userstate='Y' where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);	}
		
		return result;
	}

	public int stateChangeNtoY(String userid) {
		int result = 0;
		con = DB.getConnection();
		String sql = "UPDATE member SET userstate='Y' where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);	}
		
		return result;
	}

	public int stateChangeYtoB(String userid) {
		
		int result = 0;
		con = DB.getConnection();
		String sql = "UPDATE member SET userstate='B' where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);	}
		
		return result;
	}
	
	
}
