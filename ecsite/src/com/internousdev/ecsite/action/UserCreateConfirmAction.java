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
public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String errorMassage;

	public void validate(){
		if(Objects.isNull(loginUserId) || loginUserId.isEmpty()){
			addActionError("idが空欄です");
		}
		if(Objects.isNull(loginPassword) || loginPassword.isEmpty()){
			addActionError("passwordが空欄です");
		}
		if(Objects.isNull(userName) || userName.isEmpty()){
			addActionError("userNameが空欄です");
		}
		if(loginUserId.length()<5 || loginUserId.length()>15){
			addActionError("idは5字以上15文字以下です");
		}
		if(loginPassword.length()<5 || loginPassword.length()>15){
			addActionError("passwordは5文字以上15文字以下です");
		}
		if(userName.length()<5 || userName.length()>15){
			addActionError("userNameは5字以上15文字以下です");
		}
		if(!(loginUserId.matches("[a-z0-9]+"))) {
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
		String result=SUCCESS;



		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))){
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName",userName);
		}else{
			setErrorMassage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public String getErrorMassage(){
		return errorMassage;
	}
	public void setErrorMassage(String errorMassage){
		this.errorMassage=errorMassage;
	}
}
