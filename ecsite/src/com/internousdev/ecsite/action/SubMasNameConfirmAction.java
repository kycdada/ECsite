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
public class SubMasNameConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private String hostMasterId;
	private String loginPassword;
	private String index;

public void validate(){
	if(Objects.isNull(hostMasterId) || hostMasterId.isEmpty()){
		addActionError("idが空欄です");
	}
	if(Objects.isNull(loginPassword) || loginPassword.isEmpty()){
		addActionError("passwordが空欄です");
	}
	if(hostMasterId.length()<5 || hostMasterId.length()>15){
		addActionError("idは5字以上15文字以下です");
	}
	if(loginPassword.length()<5 || loginPassword.length()>15){
		addActionError("passwordは5文字以上15文字以下です");
	}
	if(!(hostMasterId.matches("[a-z0-9]+"))) {
		addActionError("idは半角小文字英数字でお願いします。");
	}
	if(!(loginPassword.matches("[a-z0-9]+"))) {
		addActionError("passwordは半角小文字英数字でお願いします。");
	}
}
	public String execute(){
		String rs=ERROR;
		if(Objects.nonNull(session.get("masterId").toString()) && !(Boolean.valueOf(session.get("subMasterFlg").toString()))){
			if(Objects.nonNull(session.get("newSubMasId"))){
				session.put("newSubMasName", getHostMasterId());
				session.put("newSubMasPass", getLoginPassword());
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
	/**
	 * hostMasterIdを取得します。
	 * @return hostMasterId
	 */
	public String getHostMasterId() {
	    return hostMasterId;
	}
	/**
	 * hostMasterIdを設定します。
	 * @param hostMasterId hostMasterId
	 */
	public void setHostMasterId(String hostMasterId) {
	    this.hostMasterId = hostMasterId;
	}
	/**
	 * loginPasswordを取得します。
	 * @return loginPassword
	 */
	public String getLoginPassword() {
	    return loginPassword;
	}
	/**
	 * loginPasswordを設定します。
	 * @param loginPassword loginPassword
	 */
	public void setLoginPassword(String loginPassword) {
	    this.loginPassword = loginPassword;
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
}
