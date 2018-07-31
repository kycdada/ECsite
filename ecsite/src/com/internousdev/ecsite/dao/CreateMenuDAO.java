/**
 *
 */
package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
/**
 * @author yukei
 *
 */
public class CreateMenuDAO {
	public int insert(String newItemName,String newItemPrice,String newitemKata,String newitemHira,String newItemCategory,String newItemExplain,String newItemImgPass) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();
		int i=0;
		String sql="INSERT INTO item_info_transaction(item_name,item_price,item_kata,item_hira,item_category,item_explain,item_img_path,insert_date) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,newItemName);
			ps.setString(2,newItemPrice);
			ps.setString(3,newitemKata);
			ps.setString(4, newitemHira);
			ps.setString(5, newItemCategory);
			ps.setString(6,newItemExplain);
			ps.setString(7,newItemImgPass);
			ps.setString(8, date.getDate());
			int in=ps.executeUpdate();
			if(in>0) {
				i=in;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return i;
	}

}
