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
public class CreateSubMasterAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	public String execute(){
		String rs=ERROR;
		if(Objects.nonNull(session.get("masterId"))){
			if(!(Boolean.valueOf(session.get("subMasterFlg").toString()))){
				rs=SUCCESS;
			}
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
}
