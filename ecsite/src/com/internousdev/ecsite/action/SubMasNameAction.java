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
public class SubMasNameAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private String index;
	private String id;
	public String execute(){
		String rs=ERROR;
		if(Objects.nonNull(session.get("masterId").toString()) && !(Boolean.valueOf(session.get("subMasterFlg").toString()))){
			session.put("newSubMasId", id);
				rs=SUCCESS;
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
	 * indexを取得します。
	 * @return index
	 */
	public String getIndex() {
	    return index;
	}
	/**
	 * indexを設定します。
	 * @param index index
	 */
	public void setIndex(String index) {
	    this.index = index;
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


}
