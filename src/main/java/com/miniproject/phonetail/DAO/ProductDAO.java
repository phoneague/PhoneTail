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

	private ProductDAO() {
	}

	private static ProductDAO itc = new ProductDAO();

	public static ProductDAO getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<ProductDTO> newList() {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		con = DB.getConnection();
		String sql = "select * from new_product";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO pdto = new ProductDTO();
				pdto.setPseq(rs.getInt("pseq"));
				pdto.setModel(rs.getString("model"));
				pdto.setPrice(rs.getInt("price"));
				pdto.setImage(rs.getString("image"));
				pdto.setSaveimagefile(rs.getString("saveimagefile"));
				pdto.setUserid(rs.getString("userid"));
				list.add(pdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
		return list;
	}

	public ArrayList<ProductDTO> selectBrandProduct() {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
		con = DB.getConnection();
		String sql = "select * from product";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO pdto = new ProductDTO();
				pdto.setPseq(rs.getInt("pseq"));
				pdto.setBrand(rs.getString("brand"));
				pdto.setModel(rs.getString("model"));
				pdto.setPrice(rs.getInt("price"));
				pdto.setComment(rs.getString("comment"));
				pdto.setImage(rs.getString("image"));
				pdto.setSaveimagefile(rs.getString("saveimagefile"));
				pdto.setSellstate(rs.getString("sellstate"));
				pdto.setIndate(rs.getTimestamp("indate"));
				pdto.setReadcount(rs.getInt("readcount"));
				pdto.setWantcount(rs.getInt("wantcount"));
				pdto.setUserid(rs.getString("userid"));
				list.add(pdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
		return list;
	}

	public ProductDTO getProduct(int pseq) {
		ProductDTO pdto = new ProductDTO();
		con = DB.getConnection();
		String sql = "select * from product where pseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pdto.setPseq(rs.getInt("pseq"));
				pdto.setBrand(rs.getString("brand"));
				pdto.setModel(rs.getString("model"));
				pdto.setPrice(rs.getInt("price"));
				pdto.setComment(rs.getString("comment"));
				pdto.setImage(rs.getString("image"));
				pdto.setSaveimagefile(rs.getString("saveimagefile"));
				pdto.setSellstate(rs.getString("sellstate"));
				pdto.setIndate(rs.getTimestamp("indate"));
				pdto.setReadcount(rs.getInt("readcount"));
				pdto.setWantcount(rs.getInt("wantcount"));
				pdto.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
		return pdto;
	}

	public void insertProduct(ProductDTO pdto) {

		con = DB.getConnection();
		String sql = "insert into product(brand, model, price, comment, image, saveimagefile, userid) values(?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdto.getBrand());
			pstmt.setString(2, pdto.getModel());
			pstmt.setInt(3, pdto.getPrice());
			pstmt.setString(4, pdto.getComment());
			pstmt.setString(5, pdto.getImage());
			pstmt.setString(6, pdto.getSaveimagefile());
			pstmt.setString(7, pdto.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
	}

	public int getAllCount(String tablename, String fieldname, String key, String brand, String sellstate) {
	    int count = 0;
	    con = DB.getConnection();
	    String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " p "
	               + "JOIN member m ON p.userid = m.userid "
	               + "WHERE p." + fieldname + " LIKE CONCAT('%', ?, '%') "
	               + "AND p.brand LIKE CONCAT('%', ?, '%') "
	               + "AND p.sellstate LIKE CONCAT('%', ?, '%') "
	               + "AND m.userstate != 'B'";
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, key);
	        pstmt.setString(2, brand);
	        pstmt.setString(3, sellstate);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt("cnt");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DB.close(con, pstmt, rs);
	    }
	    return count;
	}


	public ArrayList<ProductDTO> productList(Paging paging, String key, String brand, String sellstate) {
	    ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
	    con = DB.getConnection();
	    String sql = "SELECT p.* FROM product p "
	               + "JOIN member m ON p.userid = m.userid "
	               + "WHERE p.model LIKE CONCAT('%', ?, '%') "
	               + "AND p.brand LIKE CONCAT('%', ?, '%') "
	               + "AND p.sellstate LIKE CONCAT('%', ?, '%') "
	               + "AND m.userstate != 'B' "
	               + "ORDER BY p.indate DESC LIMIT ? OFFSET ?";
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, key);
	        pstmt.setString(2, brand);
	        pstmt.setString(3, sellstate);
	        pstmt.setInt(4, paging.getDisplayRow());
	        pstmt.setInt(5, paging.getStartNum() - 1);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            ProductDTO pdto = new ProductDTO();
	            pdto.setPseq(rs.getInt("pseq"));
	            pdto.setBrand(rs.getString("brand"));
	            pdto.setModel(rs.getString("model"));
	            pdto.setPrice(rs.getInt("price"));
	            pdto.setComment(rs.getString("comment"));
	            pdto.setImage(rs.getString("image"));
	            pdto.setSaveimagefile(rs.getString("saveimagefile"));
	            pdto.setSellstate(rs.getString("sellstate"));
	            pdto.setIndate(rs.getTimestamp("indate"));
	            pdto.setReadcount(rs.getInt("readcount"));
	            pdto.setWantcount(rs.getInt("wantcount"));
	            pdto.setUserid(rs.getString("userid"));
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
		String sql = "update product set brand=?, model=?, price=?, comment=?, image=?, saveimagefile=? where pseq=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pdto.getBrand());
			pstmt.setString(2, pdto.getModel());
			pstmt.setInt(3, pdto.getPrice());
			pstmt.setString(4, pdto.getComment());
			pstmt.setString(5, pdto.getImage());
			pstmt.setString(6, pdto.getSaveimagefile());
			pstmt.setInt(7, pdto.getPseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}

	}

	public int getMyAllcount(String tablename, String myId) {
		int count = 0;
		con = DB.getConnection();
//		System.out.println(tablename+"/"+fieldname+"/"+key+"/"+brand);
		String sql = "SELECT COUNT(*) AS cnt FROM " + tablename + " WHERE userid LIKE ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, myId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}

		return count;
	}

	public void deleteProduct(int pseq) {
		con = DB.getConnection();
		String sql = "delete from product where pseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
	}

	public void soldProduct(int pseq) {
		con = DB.getConnection();
		String sql = "update product set sellstate='Y' where pseq=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
	}

	public ArrayList<ProductDTO> myProudctList(Paging paging, String myId) {
		ArrayList<ProductDTO> list = new ArrayList<>();
		con = DB.getConnection();
		String sql = "SELECT * FROM product WHERE userid LIKE ? " + " ORDER BY indate DESC, pseq DESC LIMIT ? OFFSET ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, myId);
			pstmt.setInt(2, paging.getDisplayRow());
			pstmt.setInt(3, paging.getStartNum() - 1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO pdto = new ProductDTO();
				pdto.setPseq(rs.getInt("pseq"));
				pdto.setBrand(rs.getString("brand"));
				pdto.setModel(rs.getString("model"));
				pdto.setPrice(rs.getInt("price"));
				pdto.setComment(rs.getString("comment"));
				pdto.setImage(rs.getString("image"));
				pdto.setSaveimagefile(rs.getString("saveimagefile"));
				pdto.setSellstate(rs.getString("sellstate"));
				pdto.setIndate(rs.getTimestamp("indate"));
				pdto.setReadcount(rs.getInt("readcount"));
				pdto.setWantcount(rs.getInt("wantcount"));
				pdto.setUserid(rs.getString("userid"));
				list.add(pdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
		return list;
	}

	public int checkWant(int pseq, String userid) {
		int check = 0;
		con = DB.getConnection();
		String sql = "select wseq from wantlist where pseq=? and userid=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			pstmt.setString(2, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = rs.getInt("wseq");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
		return check;
	}

	public void insertWant(int pseq, String userid) {
		con = DB.getConnection();
		String sql = "insert into wantlist(pseq, userid) values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
	}

	public void updateWantCount(int pseq) {
		String sql = "UPDATE product SET wantcount = wantcount+1 where pseq = ?";
		try {
			con = DB.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(con, pstmt, rs);
		}
	}

	public void updateReadcount(int pseq) {
		String sql = "UPDATE product SET readcount = readcount + 1 WHERE pseq = ?";
	    try {
	    	     con = DB.getConnection();
	    		 pstmt = con.prepareStatement(sql);
	             pstmt.setInt(1, pseq);
	             pstmt.executeUpdate();
	    } catch (SQLException e) { e.printStackTrace();
	    } finally { DB.close(con, pstmt, rs); }
	}
		

}
