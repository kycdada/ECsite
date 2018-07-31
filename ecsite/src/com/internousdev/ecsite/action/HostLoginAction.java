/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MasterLoginDAO;
import com.internousdev.ecsite.dto.SubMasterFlgDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class HostLoginAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private String loginUserId;
	private String loginPassword;

	public void validate(){
		if(Objects.isNull(loginUserId) || loginUserId.isEmpty()){
			addActionError("idが空欄です");
		}
		if(Objects.isNull(loginPassword) || loginPassword.isEmpty()){
			addActionError("passwordが空欄です");
		}
		if(loginUserId.length()<5 || loginUserId.length()>15){
			addActionError("idは5字以上15文字以下です");
		}
		if(loginPassword.length()<5 || loginPassword.length()>15){
			addActionError("passwordは5文字以上15文字以下です");
		}
		if(!(loginUserId.matches("[a-z0-9]+"))) {
			addActionError("idは半角小文字英数字でお願いします。");
		}
		if(!(loginPassword.matches("[a-z0-9]+"))) {
			addActionError("passwordは半角小文字英数字でお願いします。");
		}
	}
	public String execute(){
		String rs=ERROR;
		if(Objects.isNull(session.get("masterId"))){
		MasterLoginDAO masterDAO=new MasterLoginDAO();
		SubMasterFlgDTO logDTO=new SubMasterFlgDTO();
		logDTO=masterDAO.masterSelect(loginUserId, loginPassword);
		if(loginUserId.equals(logDTO.getHostMasterId()) && loginPassword.equals(logDTO.getLoginPassword())){
			rs=SUCCESS;
			session.put("masterId", logDTO.getId());
			session.put("UCF", logDTO.getUserCreate());
			session.put("UEF", logDTO.getUserEdit());
			session.put("UDF", logDTO.getUserDelete());
			session.put("ICF", logDTO.getItemCreate());
			session.put("IEF", logDTO.getItemEdit());
			session.put("IDF", logDTO.getItemDelete());
			session.put("subMasterFlg", logDTO.getSubMasterFlg());
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
	 * loginUserIdを取得します。
	 * @return loginUserId
	 */
	public String getLoginUserId() {
	    return loginUserId;
	}
	/**
	 * loginUserIdを設定します。
	 * @param loginUserId loginUserId
	 */
	public void setLoginUserId(String loginUserId) {
	    this.loginUserId = loginUserId;
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


}
