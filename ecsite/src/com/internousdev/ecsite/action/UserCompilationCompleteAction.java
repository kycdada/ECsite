/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class UserCompilationCompleteAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private int updateFlg=0;
	public String execute(){
		String rs=ERROR;
		List<LoginDTO> userList= new ArrayList<LoginDTO>();

		if(Objects.isNull(session.get("masterId")) || Objects.isNull(session.get("userList"))){
			return "home";
		}

		UserDAO dao=new UserDAO();
		String id=((LoginDTO)session.get("user")).getId();
		if(!(((LoginDTO)(session.get("user"))).getLoginId().equals(((LoginDTO)(session.get("newUser"))).getLoginId()))){
			String loginId=((LoginDTO)(session.get("newUser"))).getLoginId();

			updateFlg+=dao.updateLoginId(loginId,id);
		}
		if(!(((LoginDTO)(session.get("user"))).getLoginPassword().equals(((LoginDTO)(session.get("newUser"))).getLoginPassword()))){
			String password=((LoginDTO)(session.get("newUser"))).getLoginPassword();

			updateFlg+=dao.updatePass(password,id);
		}
		if(!(((LoginDTO)(session.get("user"))).getUserName().equals(((LoginDTO)(session.get("newUser"))).getUserName()))){
			String userName=((LoginDTO)(session.get("newUser"))).getUserName();

			updateFlg+=dao.updateUserName(userName,id);
		}
		if(updateFlg>0){
			rs=SUCCESS;
			userList=dao.getUserInfo();
			session.put("userList", userList);
		}
		return rs;
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
	 * updateFlgを取得します。
	 * @return updateFlg
	 */
	public int getUpdateFlg() {
	    return updateFlg;
	}
	/**
	 * updateFlgを設定します。
	 * @param updateFlg updateFlg
	 */
	public void setUpdateFlg(int updateFlg) {
	    this.updateFlg = updateFlg;
	}


}
