package com.miniproject.phonetail.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.miniproject.phonetail.DTO.ProductDTO;
import com.miniproject.phonetail.util.DB;
import com.miniproject.phonetail.util.Paging;

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
				pdto.setPrice(rs.getInt("price"));
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
		con = DB.getConnection();
		String sql = "select * from product where pseq=?";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			while( rs.next()) {
				pdto.setPseq(rs.getInt("pseq") );
				pdto.setBrand(rs.getString("brand") );
				pdto.setSeries(rs.getString("series") );
				pdto.setModel(rs.getString("model") );
				pdto.setPrice(rs.getInt("price"));
				pdto.setComment(rs.getString("comment") );
				pdto.setImage(rs.getString("image") );
				pdto.setSaveimagefile(rs.getString("saveimagefile") );
				pdto.setSellstate(rs.getString("sellstate") );
				pdto.setIndate(rs.getTimestamp("indate") );
				pdto.setUserid(rs.getString("userid") );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {DB.close(con, pstmt, rs);
		}
		return pdto;
	}


	public void insertProduct(ProductDTO pdto) {
		
		con = DB.getConnection();
		String sql = "insert into product(series, brand, model, price, comment, image, saveimagefile, userid) values(?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdto.getSeries());
			pstmt.setString(2, pdto.getBrand());
			pstmt.setString(3, pdto.getModel());
			pstmt.setInt(4, pdto.getPrice());
			pstmt.setString(5, pdto.getComment());
			pstmt.setString(6, pdto.getImage());
			pstmt.setString(7, pdto.getSaveimagefile());
			pstmt.setString(8, pdto.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);  }
	}

	public int getAllCount(String tablename, String fieldname, String key, String brand) {
		int count = 0;
		con = DB.getConnection();
		System.out.println(tablename+"/"+fieldname+"/"+key+"/"+brand);
		String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE " + fieldname + " LIKE CONCAT('%', ?, '%') AND brand LIKE CONCAT('%', ?, '%')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, brand);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);  }

		return count;
	}
	
	public ArrayList<ProductDTO> productList(Paging paging, String key, String brand) {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		con = DB.getConnection();
		String sql = "SELECT * FROM product WHERE model LIKE CONCAT('%',?,'%') AND brand LIKE CONCAT('%', ?, '%') "
				+ " ORDER BY indate DESC LIMIT ? OFFSET ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, brand);
			pstmt.setInt(3, paging.getDisplayRow());
			pstmt.setInt(4, paging.getStartNum() - 1);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDTO pdto = new ProductDTO();
				pdto.setPseq(rs.getInt("pseq") );
				pdto.setBrand(rs.getString("brand") );
				pdto.setSeries(rs.getString("series") );
				pdto.setModel(rs.getString("model") );
				pdto.setPrice(rs.getInt("price"));
				pdto.setComment(rs.getString("comment") );
				pdto.setImage(rs.getString("image") );
				pdto.setSaveimagefile(rs.getString("saveimagefile") );
				pdto.setSellstate(rs.getString("sellstate") );
				pdto.setIndate(rs.getTimestamp("indate") );
				pdto.setUserid(rs.getString("userid") );
				list.add(pdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
		return list;
	}


	public void updateProduct(ProductDTO pdto) {
		con = DB.getConnection();
		String sql = "update product set brand=?, series=?, model=?, price=?, comment=?, image=?, saveimagefile=? where pseq=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdto.getBrand());
			pstmt.setString(2, pdto.getSeries());
			pstmt.setString(3, pdto.getModel());
			pstmt.setInt(4, pdto.getPrice());
			pstmt.setString(5, pdto.getComment());
			pstmt.setString(6, pdto.getImage());
			pstmt.setString(7, pdto.getSaveimagefile());
			pstmt.setInt(8, pdto.getPseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.close(con, pstmt, rs);
		}
		
	}


	public int getMyAllcount(String tablename, String fieldname, String key, String myId) {
		int count = 0;
		con = DB.getConnection();
//		System.out.println(tablename+"/"+fieldname+"/"+key+"/"+brand);
		String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE " + fieldname + " LIKE CONCAT('%', ?, '%') AND brand LIKE CONCAT('%', ?, '%')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);  }

		return count;
	}


	public void deleteProduct(int pseq) {
		con = DB.getConnection();
		String sql = "delete from product where pseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DB.close(con, pstmt, rs);  }
	}


	
		

}
