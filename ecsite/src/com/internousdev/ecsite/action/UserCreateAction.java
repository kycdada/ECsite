/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class UserCreateAction extends ActionSupport implements SessionAware{
	private String masterFlg;
	private Map<String,Object>session;
	public String execute(){
		String res=SUCCESS;
		if(masterFlg != null){
		if(masterFlg.equals("1")){
			session.put("masterFlg",masterFlg);
		}
		}

		return res;
	}
	/**
	 * masterFlgを取得します。
	 * @return masterFlg
	 */
	public String getMasterFlg() {
	    return masterFlg;
	}
	/**
	 * masterFlgを設定します。
	 * @param masterFlg masterFlg
	 */
	public void setMasterFlg(String masterFlg) {
	    this.masterFlg = masterFlg;
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
