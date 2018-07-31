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

import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.DBConnector;
/**
 * @author internousdev
 *
 */
public class CartDisplayDAO {
	private List<CartDTO> cartList=new ArrayList<CartDTO>();
	private int sumPrice;
	public List<CartDTO> select(String user_master_id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		sumPrice=0;
		String sql="SELECT item_transaction_id,iit.item_name,ct.price,sum(ct.total_count) as total_count,sum(ct.total_price) as total_price,ct.user_master_id,iit.item_img_path FROM cart_transaction ct LEFT JOIN item_info_transaction iit ON ct.item_transaction_id =iit.id WHERE ct.user_master_id=? GROUP BY item_transaction_id,iit.item_name,ct.price,ct.user_master_id,iit.item_img_path";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				CartDTO dto=new CartDTO();
				dto.setItemTransactionId(rs.getString("item_transaction_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("price"));
				dto.setCount(rs.getString("total_count"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setUserId(rs.getString("user_master_id"));
				dto.setItemImgPath(rs.getString("item_img_path"));
				sumPrice+=Integer.parseInt(rs.getString("total_price"));
				cartList.add(dto);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cartList;
	}

	public int delete(String itemId,String user_master_id){
	String sql="DELETE FROM cart_transaction WHERE item_transaction_id=? AND user_master_id=?";
	int result=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemId);
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

public int delete(String user_master_id){
	String sql="DELETE FROM cart_transaction WHERE user_master_id=?" ;
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



	public int getSumPrice(){
		return sumPrice;
	}
	public void setSumPrice(int sumPrice){
		this.sumPrice=sumPrice;
	}
	public List<CartDTO> getCartList(){
		return cartList;
	}
}
