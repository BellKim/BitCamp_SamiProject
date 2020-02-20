package Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.OrderReviewDaoInterface;
import Dto.ModelReviewPurDto;
import Dto.OrderReviewDto;
import db.DBClose;
import db.DBConnection;

public class OrderReviewDao implements OrderReviewDaoInterface {

	public OrderReviewDao() {
		DBConnection.initConnection();
	}
	
	
	public boolean createOrderReview(String mem_id, int pur_index, int ins_index) {
		
		String sql = " INSERT INTO orderReview(re_index, mem_id, pur_index, ins_index) "
				+ " VALUES(orderReview_SEQ.nextval,?,?,?) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		System.out.println("[createOrderReview] sql = " + sql);
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_id);
			psmt.setInt(2, pur_index);
			psmt.setInt(3, ins_index);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[createOrderReview] fail");
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, null);
		}
		
		
		return count>0?true:false;
	}
	
	//모든 오더리뷰를 가져오는 메소드 
	/*
	 * public List<OrderReviewDto> getOrderReviewList(){
	 * 
	 * String sql = " SELECT * FROM OrderReview " +
	 * " WHERE order_re_title IS NOT NULL AND " + " order_re_content IS NOT NULL " +
	 * " ORDER BY re_index DESC ";
	 * 
	 * Connection conn = null; PreparedStatement psmt = null; ResultSet rs = null;
	 * 
	 * System.out.println("[getOrderReviewList] sql = " + sql); List<OrderReviewDto>
	 * list = new ArrayList<OrderReviewDto>(); try { conn =
	 * DBConnection.getConnection(); psmt = conn.prepareStatement(sql); rs =
	 * psmt.executeQuery();
	 * 
	 * while(rs.next()) { OrderReviewDto dto = new
	 * OrderReviewDto(rs.getInt("re_index"), rs.getString("mem_id"),
	 * rs.getInt("pur_index"), rs.getInt("ins_index"), rs.getString("wdate"),
	 * rs.getString("order_title"), rs.getString("order_content"),
	 * rs.getString("order_img_path"), rs.getInt("readcount"), rs.getInt("rating"),
	 * rs.getInt("re_auth")); list.add(dto); }
	 * 
	 * } catch (SQLException e) { System.out.println("[getOrderReviewList] fail");
	 * e.printStackTrace(); }finally { DBClose.close(psmt, conn, rs); } return list;
	 * }
	 */
	public boolean updatePurReview(int pur_index) {
		String sql = " UPDATE PURCHASE "
				+ " SET REVIEW = 1 "
				+ " WHERE PUR_INDEX=? ";
		
		 Connection conn = null;
		 PreparedStatement psmt = null;
		 int count = 0;
		 
		 try {
			 conn = DBConnection.getConnection();
			 System.out.println("1/6 updateReview success");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pur_index);
			System.out.println("2/6 updateReview success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 updateReview success");
		} catch (SQLException e) {
			System.out.println("updateReview fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		 
		 return count>0?true:false;
		
	}
	
	
	 public boolean writeOrderReview(OrderReviewDto dto) { 
		 String sql = " INSERT INTO orderReview ( RE_INDEX, MEM_ID, PUR_INDEX, INS_INDEX, WDATE, ORDER_RE_TITLE, ORDER_RE_CONTENT, "
		 		+ "  ORDER_RE_IMG_PATH, READCOUNT, RATING, RE_AUTH ) VALUES "
		 		+ " ( orderReview_SEQ.NEXTVAL, ?, ?, null, SYSDATE, ?, ?, ?, 0, ? , 0 ) "; 
		 
		 Connection conn = null;
		 PreparedStatement psmt = null;
		 int count = 0;
		 
		 try {
			 conn = DBConnection.getConnection();
			 System.out.println("1/6 writeOrderReview success");
		 	 psmt = conn.prepareStatement(sql); 
		 	 System.out.println("2/6 writeOrderReview success");
		 	 
		 	 psmt.setString(1, dto.getMem_id());
		 	 psmt.setInt(2, dto.getPur_index());
		 	 psmt.setString(3, dto.getOrder_title()); 
		 	 psmt.setString(4, dto.getOrder_content());
		 	 psmt.setString(5, dto.getOrder_img_path());
		 	 psmt.setInt(6, dto.getRating());
		 	 
		 	 System.out.println("sql: "+sql);
		 	 
		 	 count = psmt.executeUpdate();
		 	 System.out.println("3/6 writeOrderReview success");
		} catch (SQLException e) {
			 System.out.println("writeOrderReview fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		 
		 return count>0?true:false;
	 }
	 
	 public List<ModelReviewPurDto> reviewAllList(){
		 String sql = " select re_index,wdate, o.pur_index, o.mem_id, m.prd_name, p.pur_date,"
		 		+ " order_re_title, order_re_content, order_re_img_path, rating, readcount "
		 		+ " from modellist m, orderreview o, purchase p "
		 		+ " where m.prd_index = p.prd_index AND o.pur_index=p.pur_index "
		 		+ " ORDER BY wdate DESC ";
		 
		 Connection conn = null;
		 PreparedStatement psmt = null;
		 ResultSet rs = null;
		 
		 List<ModelReviewPurDto> list = new ArrayList<ModelReviewPurDto>();
		 
		 try {
			 conn = DBConnection.getConnection();
			 System.out.println("1/6 reviewAllList success");
			psmt = conn.prepareStatement(sql);
			 System.out.println("2/6 reviewAllList success");
			 
			 rs = psmt.executeQuery();
			 while(rs.next()) {
				 int i = 1;
				 ModelReviewPurDto dto = new ModelReviewPurDto(rs.getInt(i++),//re_index
						 										rs.getString(i++),//wdate
						 										rs.getInt(i++),//pur_index,
						 										rs.getString(i++),//	mem_id, 
						 										rs.getString(i++),//prd_name, 
						 										rs.getString(i++),//pur_date, 
						 										rs.getString(i++),//order_re_title, 
						 										rs.getString(i++),//order_re_content, 
						 										rs.getString(i++),//order_re_img_path, 
						 										rs.getInt(i++),//rating, 
						 										rs.getInt(i++));//readcount)
				 
				 list.add(dto);
				 
			 }
			 System.out.println("3/6 reviewAllList success");
		} catch (SQLException e) {
			System.out.println("reviewAllList fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		 
		return list;
	 }
	 
	 public ModelReviewPurDto getDetailReview(int re_index) {
		String sql = " select re_index,wdate, o.pur_index, o.mem_id, m.prd_name, p.pur_date,"
		 		+ " order_re_title, order_re_content, order_re_img_path, rating, readcount "
		 		+ " from modellist m, orderreview o, purchase p "
		 		+ " where m.prd_index = p.prd_index AND o.pur_index=p.pur_index AND re_index=? ";
		
		 Connection conn = null;
		 PreparedStatement psmt = null;
		 ResultSet rs = null;
		 
		 ModelReviewPurDto dto = null;
		 
		 try {
			 conn = DBConnection.getConnection();
			 System.out.println("1/6 getDetailReview success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 getDetailReview success");
			
			psmt.setInt(1, re_index);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				 int i = 1;
				 dto = new ModelReviewPurDto(rs.getInt(i++),//re_index
							rs.getString(i++),//wdate
							rs.getInt(i++),//pur_index,
							rs.getString(i++),//	mem_id, 
							rs.getString(i++),//prd_name, 
							rs.getString(i++),//pur_date, 
							rs.getString(i++),//order_re_title, 
							rs.getString(i++),//order_re_content, 
							rs.getString(i++),//order_re_img_path, 
							rs.getInt(i++),//rating, 
							rs.getInt(i++));//readcount)
			}
			System.out.println("3/6 getDetailReview success");
		} catch (SQLException e) {
			System.out.println(" getDetailReview fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
	}
	 
	public boolean updateReadCount(int re_index) {
		String sql = " UPDATE orderReview "
				+ " SET READCOUNT = READCOUNT + 1 "
				+ " WHERE RE_INDEX=? ";
		
		 Connection conn = null;
		 PreparedStatement psmt = null;

		 int count = 0;
		 
		 try {
			 conn = DBConnection.getConnection();
			 System.out.println("1/6 updateReadCount success");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, re_index);
			System.out.println("2/6 updateReadCount success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 updateReadCount success");
		} catch (SQLException e) {
			System.out.println("updateReadCount fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		 
		 return count>0?true:false;
	}
	
	public boolean updateReview(int re_index, ModelReviewPurDto dto) {
		String sql = " UPDATE orderReview "
				+ " SET as_re_title=? , as_re_content=?, as_re_img_path=?, rating=? "
				+ " WHERE RE_INDEX=? AND MEM_ID=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
				
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 updateReview success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/6 updateReview success");
			psmt.setString(1, dto.getOrder_re_title());
			psmt.setString(2, dto.getOrder_re_content());
			psmt.setString(3, dto.getOrder_re_img_path());
			psmt.setInt(4, dto.getRating());
			psmt.setInt(5, dto.getRe_index());
			psmt.setString(6, dto.getMem_id());
			
			
			count = psmt.executeUpdate();
			System.out.println("3/6 updateReview success");
		} catch (SQLException e) {
			System.out.println("updateReview fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		
		return count>0?true:false;
	}
	
	public boolean delReivew(int re_index) {
		String sql = " UPDATE orderReview "
				+ " SET RE_AUTH=1 "
				+ " WHERE RE_INDEX=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
				
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/6 delReview success");
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, re_index);
			System.out.println("2/6 delReview success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 delReview success");
		} catch (SQLException e) {
			System.out.println(" delReview fail");
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, null);
		}
		
		return count>0?true:false;
	}
	 
}
