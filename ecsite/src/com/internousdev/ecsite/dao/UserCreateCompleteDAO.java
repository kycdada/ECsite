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
 * @author internousdev
 *
 */
public class UserCreateCompleteDAO {
	public int createUser(String loginUserId,String loginUserPassword,String userName){

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();
		String sql="INSERT INTO login_user_transaction (login_id,login_pass,user_name,insert_date) VALUES(?,?,?,?)";
		int i=0;
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, date.getDate());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
}
