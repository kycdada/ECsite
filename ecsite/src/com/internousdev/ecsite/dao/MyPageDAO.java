/**
 *
 */
package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

/**
 * @author internousdev
 *
 */
public class MyPageDAO {
	public ArrayList<MyPageDTO> getMyPageUserInfo(String user_master_id){
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
		DBConnector db=new DBConnector();
		Connection con= db.getConnection();
		String sql="SELECT ubit.id,iit.item_name,ubit.order_number,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.user_master_id=? ORDER BY insert_date DESC";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();
				dto.setId(rs.getString("id"));
				dto.setOrderNumber(rs.getString("order_number"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				myPageDTO.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return myPageDTO;
	}

	public int buyItemHistoryDelete(String id,String user_master_id){
		String sql="DELETE FROM user_buy_item_transaction WHERE id=? AND user_master_id=?";
		int result=0;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, user_master_id);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public int buyItemHistoryDelete(String user_master_id){
		String sql="DELETE FROM user_buy_item_transaction WHERE user_master_id=?";
		int result=0;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public List<String> getBuyItemDay(String user_master_id){
		String sql="SELECT order_number FROM user_buy_item_transaction WHERE user_master_id=? GROUP BY order_number HAVING count(*)>=1 ORDER BY insert_date DESC";
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<String> number=new ArrayList<String>();
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				number.add(rs.getString("order_number"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return number;
	}
}
