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

import com.internousdev.ecsite.dto.SubMasterFlgDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;
/**
 * @author internousdev
 *
 */
public class MasterLoginDAO {
	public SubMasterFlgDTO masterSelect(String loginUserId,String loginPassword){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		SubMasterFlgDTO flgDTO=new SubMasterFlgDTO();
		String sql="SELECT * FROM master_login_transaction WHERE host_master_id=? AND login_password=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				flgDTO.setId(rs.getString("id"));
				flgDTO.setHostMasterId(rs.getString("host_master_id"));
				flgDTO.setLoginPassword(rs.getString("login_password"));
				flgDTO.setItemCreate(rs.getBoolean("item_create"));
				flgDTO.setItemEdit(rs.getBoolean("item_edit"));
				flgDTO.setItemDelete(rs.getBoolean("item_delete"));
				flgDTO.setUserCreate(rs.getBoolean("user_create"));
				flgDTO.setUserEdit(rs.getBoolean("user_edit"));
				flgDTO.setUserDelete(rs.getBoolean("user_delete"));
				flgDTO.setSubMasterFlg(rs.getBoolean("sub_master_flg"));
				flgDTO.setInsertDate(rs.getString("insert_date"));

			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flgDTO;
	}

	public SubMasterFlgDTO getSubMasterFlg(String id){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="SELECT * FROM master_login_transaction WHERE id=?";
		SubMasterFlgDTO flgDTO=new SubMasterFlgDTO();
			try{
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
				flgDTO.setItemCreate(rs.getBoolean("item_create"));
				flgDTO.setItemEdit(rs.getBoolean("item_edit"));
				flgDTO.setItemDelete(rs.getBoolean("item_delete"));
				flgDTO.setUserCreate(rs.getBoolean("user_create"));
				flgDTO.setUserEdit(rs.getBoolean("user_edit"));
				flgDTO.setUserDelete(rs.getBoolean("user_delete"));
				flgDTO.setSubMasterFlg(rs.getBoolean("sub_master_flg"));
				flgDTO.setInsertDate(rs.getString("insert_date"));


				}
			}catch(SQLException e){
				e.printStackTrace();
			}try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
		}
		return flgDTO;
	}

	public List<SubMasterFlgDTO> getSubMastersList(){
		List<SubMasterFlgDTO> submasList=new ArrayList<SubMasterFlgDTO>();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="SELECT * FROM master_login_transaction WHERE id <>1";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				SubMasterFlgDTO flgDTO=new SubMasterFlgDTO();
				flgDTO.setId(rs.getString("id"));
				flgDTO.setHostMasterId(rs.getString("host_master_id"));
				flgDTO.setLoginPassword(rs.getString("login_password"));
				flgDTO.setItemCreate(rs.getBoolean("item_create"));
				flgDTO.setItemEdit(rs.getBoolean("item_edit"));
				flgDTO.setItemDelete(rs.getBoolean("item_delete"));
				flgDTO.setUserCreate(rs.getBoolean("user_create"));
				flgDTO.setUserEdit(rs.getBoolean("user_edit"));
				flgDTO.setUserDelete(rs.getBoolean("user_delete"));
				flgDTO.setSubMasterFlg(rs.getBoolean("sub_master_flg"));
				flgDTO.setInsertDate(rs.getString("insert_date"));
				flgDTO.setUpdateDate(rs.getString("update_date"));
				submasList.add(flgDTO);

			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return submasList;
	}

	public int insertCreate(SubMasterFlgDTO dto){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();
		int res=0;
		String sql ="INSERT INTO master_login_transaction (host_master_id,login_password,user_create,user_edit,user_delete,item_create,item_edit,item_delete,sub_master_flg,insert_date) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getHostMasterId());
			ps.setString(2, dto.getLoginPassword());
			ps.setBoolean(3, dto.getUserCreate());
			ps.setBoolean(4, dto.getUserEdit());
			ps.setBoolean(5, dto.getUserDelete());
			ps.setBoolean(6, dto.getItemCreate());
			ps.setBoolean(7, dto.getItemEdit());
			ps.setBoolean(8, dto.getItemDelete());
			ps.setBoolean(9, true);
			ps.setString(10, date.getDate());

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

	public int delete(List<String> idList) {
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM master_login_transaction WHERE id=?";
		int res=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			for(int i=0;i<idList.size();i++) {
				String id=idList.get(i);
				if(!(id.equals("1"))){
				ps.setString(1, id);
				res+=ps.executeUpdate();
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public void upDate(List<String> userCreateFlg,List<String> userEditFlg,List<String> userDeleteFlg,List<String> itemCreateFlg,List<String> itemEditFlg,List<String> itemDeleteFlg,List<String> idList){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil date=new DateUtil();
		boolean userCreate;
		boolean userEdit;
		boolean userDelete;
		boolean itemCreate;
		boolean itemEdit;
		boolean itemDelete;
		String id;
		String sql="UPDATE master_login_transaction SET user_create=?,user_edit=?,user_delete=?,item_create=?,item_edit=?,item_delete=?,update_date=? WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			for(int i=0;i<userCreateFlg.size();i++){
			userCreate=Boolean.valueOf(userCreateFlg.get(i));
			userEdit=Boolean.valueOf(userEditFlg.get(i));
			userDelete=Boolean.valueOf(userDeleteFlg.get(i));
			itemCreate=Boolean.valueOf(itemCreateFlg.get(i));
			itemEdit=Boolean.valueOf(itemEditFlg.get(i));
			itemDelete=Boolean.valueOf(itemDeleteFlg.get(i));
			id=idList.get(i);
				if(!(id.equals("1"))){
					ps.setBoolean(1, userCreate);
				ps.setBoolean(2, userEdit);
				ps.setBoolean(3, userDelete);
				ps.setBoolean(4, itemCreate);
				ps.setBoolean(5, itemEdit);
				ps.setBoolean(6, itemDelete);
				ps.setString(7, date.getDate());
				ps.setString(8, id);
				ps.execute();
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public int updateName(String hostMasterId,String loginPassword,String id){
		int res=2;
		if(id.equals("1")){
			return res;
		}
		DateUtil date=new DateUtil();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="UPDATE master_login_transaction SET host_master_id=?,login_password=?,update_date=? WHERE id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, hostMasterId);
			ps.setString(2, loginPassword);
			ps.setString(3, date.getDate());
			ps.setString(4, id);
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
}



