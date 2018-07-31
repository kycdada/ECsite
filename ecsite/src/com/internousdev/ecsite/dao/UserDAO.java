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

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
/**
 * @author internousdev
 *
 */
public class UserDAO {

	public List<LoginDTO> getUserInfo(){
		List<LoginDTO> dtoList=new ArrayList<LoginDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="SELECT * FROM login_user_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				LoginDTO dto=new LoginDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setUpdateDate(rs.getString("updated_date"));
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

	public int deleteList(String id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM login_user_transaction WHERE id=?";
		int res=0;
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

	public LoginDTO getUserInfo(String id){
		LoginDTO dto=new LoginDTO();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="SELECT * FROM login_user_transaction WHERE id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));
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

	public int updateLoginId(String loginId,String id){
		int rs=0;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();
		String sql="UPDATE login_user_transaction SET login_id=?, updated_date=? WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, date.getDate());
			ps.setString(3, id);
			int i=ps.executeUpdate();
			if(i>0){
				rs=i;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}

	public int updatePass(String loginPassword,String id){
		int rs=0;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();
		String sql="UPDATE login_user_transaction SET login_pass=?, updated_date=? WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginPassword);
			ps.setString(2, date.getDate());
			ps.setString(3, id);
			int i=ps.executeUpdate();
			if(i>0){
				rs=i;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}

	public int updateUserName(String userName,String id){
		int rs=0;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();
		String sql="UPDATE login_user_transaction SET user_name=?, updated_date=? WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, date.getDate());
			ps.setString(3, id);
			int i=ps.executeUpdate();
			if(i>0){
				rs=i;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
}
