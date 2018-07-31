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

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
/**
 * @author internousdev
 *
 */
public class BuyItemDAO {

	private List<BuyItemDTO> dtoList=new ArrayList<BuyItemDTO>();

	public List<BuyItemDTO> getBuyItemInfo(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="SELECT id,item_name,item_price,item_hira,item_kata,item_category,item_explain,item_img_path FROM item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				BuyItemDTO dto=new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemHira(rs.getString("item_hira"));
				dto.setItemKata(rs.getString("item_kata"));
				dto.setItemCategory(rs.getString("item_category"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemExplain(rs.getString("item_explain"));
				dto.setItemImgPath(rs.getString("item_img_path"));
				dtoList.add(dto);
			}
			}catch(SQLException e){
				e.printStackTrace();
			}try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return dtoList;
	}

	public BuyItemDTO getBuyItemInfo(String id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		BuyItemDTO dto=new BuyItemDTO();

		String sql="SELECT id,item_name,item_category,item_img_path,item_price,item_hira,item_kata,item_explain FROM item_info_transaction WHERE id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemCategory(rs.getString("item_category"));
				dto.setItemImgPath(rs.getString("item_img_path"));
				dto.setItemHira(rs.getString("item_hira"));
				dto.setItemKata(rs.getString("item_kata"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemExplain(rs.getString("item_explain"));
			}
			}catch(SQLException e){
				e.printStackTrace();
			}try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return dto;
	}

	public int deleteList(String id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int res=0;
		String sql="DELETE FROM item_info_transaction WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0){
				res=i;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}
	public List<BuyItemDTO> getDtoList(){
		return dtoList;
	}

	public List<BuyItemDTO> getSerchResult(String[] words){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		List<BuyItemDTO> itemList=new ArrayList<BuyItemDTO>();
		String sql="SELECT * from item_info_transaction WHERE item_category like ? || item_name like ? || item_kata like ? || item_hira like ?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			for(String word:words){
				if(word.equals(" ")){
					continue;
				}
				ps.setString(1, "%"+word+"%");
				ps.setString(2, "%"+word+"%");
				ps.setString(3, "%"+word+"%");
				ps.setString(4, "%"+word+"%");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					BuyItemDTO dto=new BuyItemDTO();
					dto.setId(rs.getInt("id"));
					dto.setItemName(rs.getString("item_name"));
					dto.setItemKata(rs.getString("item_kata"));
					dto.setItemHira(rs.getString("item_hira"));
					dto.setItemPrice(rs.getString("item_price"));
					dto.setItemCategory(rs.getString("item_category"));
					dto.setItemExplain(rs.getString("item_explain"));
					dto.setItemImgPath(rs.getString("item_img_path"));
					itemList.add(dto);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemList;
	}

	/**
	 *
	 */

	public void buyItemComplete(String random,String item_transaction_id,String user_master_id,String total_price,String total_count,String pay){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="INSERT INTO user_buy_item_transaction(order_number,item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?,?)";
		DateUtil date=new DateUtil();
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, random);
			ps.setString(2, item_transaction_id);
			ps.setString(3, total_price);
			ps.setString(4, total_count);
			ps.setString(5, user_master_id);
			ps.setString(6, pay);
			ps.setString(7, date.getDate());
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
		e.printStackTrace();
		}
	}

	public void deleteAllPreMove(String user_master_id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM cart_transaction WHERE user_master_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user_master_id);
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}

