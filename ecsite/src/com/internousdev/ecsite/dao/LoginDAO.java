/**
 *
 */
package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;
/**
 * @author internousdev
 *
 */
public class LoginDAO {
	private LoginDTO dto=new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="SELECT * FROM login_user_transaction WHERE login_id=? AND login_pass=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
			}
			if(!(rs.getString("login_id").equals(null))){
				dto.setLoginFlg(true);
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
	public LoginDTO getLoginDTO(){
		return dto;
	}
}
