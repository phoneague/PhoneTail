package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.util.DB;

public class ProductDAO {
	
	private ProductDAO() {}
	private static ProductDAO itc = new ProductDAO();
	public static ProductDAO getInstance() { return itc; }
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ArrayList<ProductDTO> selectBrandProduct() {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		con = DB.getConnection();
		String sql = "select * from product";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while( rs.next()) {
				ProductDTO pdto = new ProductDTO();
				pdto.setPseq(rs.getInt("pseq") );
				pdto.setBrand(rs.getString("brand") );
				pdto.setSeries(rs.getString("series") );
				pdto.setModel(rs.getString("model") );
				pdto.setComment(rs.getString("comment") );
				pdto.setImage(rs.getString("image") );
				pdto.setSaveimagefile(rs.getString("saveimagefile") );
				pdto.setSellstate(rs.getString("sellstate") );
				pdto.setIndate(rs.getTimestamp("indate") );
				pdto.setUserid(rs.getString("userid") );
				list.add(pdto);				
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {DB.close(con, pstmt, rs);
		}
		return list;
	}


	public ProductDTO getProduct(int pseq) {
		ProductDTO pdto = new ProductDTO();
		return pdto;
	}
	

}
