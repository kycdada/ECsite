/**
 *
 */
package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.CommonUtility;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
/**
 * @author internousdev
 *
 */
public class CartInsertDAO {
	public int insertCart(String item_transaction_id,String price,String total_count,String total_price,String user_master_id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();

		int re=0;
		String sql="INSERT INTO cart_transaction(item_transaction_id, price, total_count, total_price, user_master_id, insert_date) VALUES(?,?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, price);
			ps.setString(3, total_count);
			ps.setString(4, total_price);
			ps.setString(5, user_master_id);
			ps.setString(6, date.getDate());
			re=ps.executeUpdate();


		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return re;
	}

		public void insertCart(Object cartList,Object userId){
			DBConnector db=new DBConnector();
			Connection con=db.getConnection();
			DateUtil date=new DateUtil();
			List<CartDTO> list=CommonUtility.autoCast(cartList);

			String sql="INSERT INTO cart_transaction(item_transaction_id,price, total_count, total_price, user_master_id, insert_date) VALUES(?,?,?,?,?,?)";
			try{
				for(CartDTO dto:list){

					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, dto.getId());
					ps.setString(2, dto.getItemPrice());
					ps.setString(3, dto.getCount());
					ps.setString(4, dto.getTotalPrice());
					ps.setString(5, userId.toString());
					ps.setString(6, date.getDate());
					ps.execute();
				}

			}catch(SQLException e){
				e.printStackTrace();
			}try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

}
