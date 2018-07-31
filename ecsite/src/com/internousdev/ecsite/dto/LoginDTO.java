/**
 *
 */
package com.internousdev.ecsite.dto;

/**
 * @author internousdev
 *
 */
public class LoginDTO {
	private String id;
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg;
	private String insertDate;
	private String updateDate;


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
	 * loginIdを取得します。
	 * @return loginId
	 */
	public String getLoginId(){
		return loginId;
	}
	/**
	 * loginIdを設定します。
	 * @param loginId loginId
	 */
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	/**
	 * loginPasswordを取得します。
	 * @return loginPassword
	 */
	public String getLoginPassword(){
		return loginPassword;
	}
	/**
	 * loginPasswordを設定します。
	 * @param loginPassword loginPassword
	 */
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	/**
	 * userNameを取得します。
	 * @return userName
	 */
	public String getUserName(){
		return userName;
	}
	/**
	 * userNameを設定します。
	 * @param userName userName
	 */
	public void setUserName(String userName){
		this.userName=userName;
	}
	/**
	 * loginFlgを取得します。
	 * @return loginFlg
	 */
	public boolean getLoginFlg(){
		return loginFlg;
	}
	/**
	 * loginFlgを設定します。
	 * @param loginFlg loginFlg
	 */
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg=loginFlg;
	}
	/**
	 * insertDateを取得します。
	 * @return insertDate
	 */
	public String getInsertDate() {
	    return insertDate;
	}
	/**
	 * insertDateを設定します。
	 * @param insertDate insertDate
	 */
	public void setInsertDate(String insertDate) {
	    this.insertDate = insertDate;
	}
	/**
	 * updateDateを取得します。
	 * @return updateDate
	 */
	public String getUpdateDate() {
	    return updateDate;
	}
	/**
	 * updateDateを設定します。
	 * @param updateDate updateDate
	 */
	public void setUpdateDate(String updateDate) {
	    this.updateDate = updateDate;
	}
}
