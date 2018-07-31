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
public class EditMenuDAO {
public int upName(String itemName,String id){
	int rs=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil date=new DateUtil();
	String sql="UPDATE item_info_transaction SET item_name=?, updated_date=? WHERE id=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemName);
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

public int upPrice(String itemPrice,String id){
	int rs=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil date=new DateUtil();
	String sql="UPDATE item_info_transaction SET item_price=?, updated_date=? WHERE id=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemPrice);
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

public int upHira(String itemHira,String id){
	int rs=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil date=new DateUtil();
	String sql="UPDATE item_info_transaction SET item_hira=?, updated_date=? WHERE id=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemHira);
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

public int upKata(String itemKata,String id){
	int rs=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil date=new DateUtil();
	String sql="UPDATE item_info_transaction SET item_kata=?, updated_date=? WHERE id=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemKata);
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

public int upExplain(String itemExplain,String id){
	int rs=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil date=new DateUtil();
	String sql="UPDATE item_info_transaction SET item_explain=?, updated_date=? WHERE id=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemExplain);
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

public int upCategory(String category,String id){
	int rs=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil date=new DateUtil();
	String sql="UPDATE item_info_transaction SET item_category=?, updated_date=? WHERE id=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, category);
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

public int upItemImg(String itemImgPath,String id){
	int rs=0;
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	DateUtil date=new DateUtil();
	String sql="UPDATE item_info_transaction SET item_img_path=?, updated_date=? WHERE id=?";
	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, itemImgPath);
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