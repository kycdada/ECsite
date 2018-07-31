/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class UserEditAction extends ActionSupport implements SessionAware{
	private List<LoginDTO> userList=new ArrayList<LoginDTO>();
	private Map<String,Object>session;
	private List<String> deleteUserList;
	private int deleteUserCount;
	public String execute(){
		UserDAO userDAO=new UserDAO();
		String rs=ERROR;
		if(session.get("masterId")!=null){
			if (session.get("UCF").equals(true) || session.get("UEF").equals(true) || session.get("UDF").equals(true) || session.get("subMasterFlg").equals(false)){



			rs=SUCCESS;
			userList=userDAO.getUserInfo();
			session.put("userList", userList);

			if(deleteUserList!=null){
				if (session.get("UDF").equals(true) || session.get("subMasterFlg").equals(false)){
			for(int i=0;i<deleteUserList.size();i++){
				int index=Integer.parseInt(deleteUserList.get(i).toString());
				int res=userDAO.deleteList(userList.get(index).getId());
				if(res>0){
					deleteUserCount++;
				}
			}
			userList=userDAO.getUserInfo();
			session.put("userList", userList);
			}
			}
		}
		}

		return rs;
	}
	/**
	 * userListを取得します。
	 * @return userList
	 */
	public List<LoginDTO> getUserList() {
	    return userList;
	}
	/**
	 * userListを設定します。
	 * @param userList userList
	 */
	public void setUserList(List<LoginDTO> userList) {
	    this.userList = userList;
	}
	/**
	 * sessionを取得します。
	 * @return session
	 */
	public Map<String,Object> getSession() {
	    return session;
	}
	/**
	 * sessionを設定します。
	 * @param session session
	 */
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}
	/**
	 * deleteUserListを取得します。
	 * @return deleteUserList
	 */
	public List<String> getDeleteUserList() {
	    return deleteUserList;
	}
	/**
	 * deleteUserListを設定します。
	 * @param deleteUserList deleteUserList
	 */
	public void setDeleteUserList(List<String> deleteUserList) {
	    this.deleteUserList = deleteUserList;
	}
	/**
	 * deleteUserCountを取得します。
	 * @return deleteUserCount
	 */
	public int getDeleteUserCount() {
	    return deleteUserCount;
	}
	/**
	 * deleteUserCountを設定します。
	 * @param deleteUserCount deleteUserCount
	 */
	public void setDeleteUserCount(int deleteUserCount) {
	    this.deleteUserCount = deleteUserCount;
	}
}


