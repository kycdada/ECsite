/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class CreateMenuAction extends ActionSupport implements SessionAware{
	private  Map<String,Object>session;
	public String execute(){
		String res=ERROR;
		if (session.get("ICF").equals(true) || session.get("subMasterFlg").equals(false)){
			if(Objects.nonNull(session.get("masterId"))){
					res=SUCCESS;
			}
		}
		return res;
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
