/**
 *
 */
package com.internousdev.ecsite.action;
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
public class UserCompilationAction extends ActionSupport implements SessionAware{
	private String id;
	private Map<String,Object> session;
	public String execute(){


		UserDAO dao=new UserDAO();
		LoginDTO dto=new LoginDTO();
		String rs=ERROR;
		if (session.get("UEF").equals(true) || session.get("subMasterFlg").equals(false)){
		dto=dao.getUserInfo(id);
		if(dto != null){
		session.put("user", dto);
		rs=SUCCESS;

		}
		if(Objects.isNull(session.get("masterId")) || Objects.isNull(session.get("userList"))){
			rs=ERROR;
		}
		if(Objects.isNull("id")){
			rs=ERROR;
		}
		}
		return rs;

	}
	/**
	 * idを取得します。
	 * @return id
	 */
	public String getId() {
	    return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(String id) {
	    this.id = id;
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
}
