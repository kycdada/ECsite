/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.SubMasterFlgDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class CreateSubMasterConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private String hostMasterId;
	private String loginPassword;
	private String[] userFlg;
	private String[] itemFlg;

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
		if(Objects.nonNull(session.get("masterId"))){
			if(!(Boolean.valueOf(session.get("subMasterFlg").toString()))){
		SubMasterFlgDTO dto=new SubMasterFlgDTO();
		dto.setHostMasterId(hostMasterId);
		dto.setLoginPassword(loginPassword);
		for(int i=0;i<userFlg.length;i++){

			switch(userFlg[i]){
			case "1":
				dto.setUserCreate(true);
				break;
			case "2":
				dto.setUserEdit(true);
				break;
			case "3":
				dto.setUserDelete(true);
				break;
			}

		}

		for(int i=0;i<itemFlg.length;i++){

			switch(itemFlg[i]){
			case "1":
				dto.setItemCreate(true);
				break;
			case "2":
				dto.setItemEdit(true);
				break;
			case "3":
				dto.setItemDelete(true);
				break;
			}
		}
		session.put("newSubDTO", dto);
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
	 * userFlgを取得します。
	 * @return userFlg
	 */
	public String[] getUserFlg() {
	    return userFlg;
	}
	/**
	 * userFlgを設定します。
	 * @param userFlg userFlg
	 */
	public void setUserFlg(String[] userFlg) {
	    this.userFlg = userFlg;
	}
	/**
	 * itemFlgを取得します。
	 * @return itemFlg
	 */
	public String[] getItemFlg() {
	    return itemFlg;
	}
	/**
	 * itemFlgを設定します。
	 * @param itemFlg itemFlg
	 */
	public void setItemFlg(String[] itemFlg) {
	    this.itemFlg = itemFlg;
	}
}
