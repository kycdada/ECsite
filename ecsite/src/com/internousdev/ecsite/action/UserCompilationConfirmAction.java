/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class UserCompilationConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String loginId;
	private String loginPassword;
	private String userName;

	public void validate(){
		if(Objects.isNull(loginId) || loginId.isEmpty()){
			addActionError("idが空欄です");
		}
		if(Objects.isNull(loginPassword) || loginPassword.isEmpty()){
			addActionError("passwordが空欄です");
		}
		if(Objects.isNull(userName) || userName.isEmpty()){
			addActionError("userNameが空欄です");
		}
		if(loginId.length()<5 || loginId.length()>15){
			addActionError("idは5字以上15文字以下です");
		}
		if(loginPassword.length()<5 || loginPassword.length()>15){
			addActionError("passwordは5文字以上15文字以下です");
		}
		if(userName.length()<5 || userName.length()>15){
			addActionError("userNameは5字以上15文字以下です");
		}
		if(!(loginId.matches("[a-z0-9]+"))) {
			addActionError("idは半角小文字英数字でお願いします。");
		}
		if(!(loginPassword.matches("[a-z0-9]+"))) {
			addActionError("passwordは半角小文字英数字でお願いします。");
		}
		if(!(userName.matches("[a-z0-9]+"))) {
			addActionError("userNameは半角小文字英数字でお願いします。");
		}
	}

	public String execute(){
		LoginDTO dto=new LoginDTO();
		dto.setLoginId(loginId);
		dto.setLoginPassword(loginPassword);
		dto.setUserName(userName);
		session.put("newUser", dto);
		String rs=SUCCESS;
	if(Objects.isNull(loginId) || Objects.isNull(loginPassword) || Objects.isNull(userName)){
			rs=ERROR;
		}
		if(Objects.isNull(session.get("masterId")) || Objects.isNull(session.get("userList"))){
			rs=ERROR;
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
	 * loginIdを取得します。
	 * @return loginId
	 */
	public String getLoginId() {
	    return loginId;
	}
	/**
	 * loginIdを設定します。
	 * @param loginId loginId
	 */
	public void setLoginId(String loginId) {
	    this.loginId = loginId;
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
	 * userNameを取得します。
	 * @return userName
	 */
	public String getUserName() {
	    return userName;
	}
	/**
	 * userNameを設定します。
	 * @param userName userName
	 */
	public void setUserName(String userName) {
	    this.userName = userName;
	}
}
