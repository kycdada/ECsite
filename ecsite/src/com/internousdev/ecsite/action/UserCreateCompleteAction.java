/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

	public String execute(){
		String result=ERROR;
		UserCreateCompleteDAO dao=new UserCreateCompleteDAO();
		int i=dao.createUser(session.get("loginUserId").toString(),session.get("loginPassword").toString(),session.get("userName").toString());
		if(i>0){
		result=SUCCESS;
		}
		return result;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
