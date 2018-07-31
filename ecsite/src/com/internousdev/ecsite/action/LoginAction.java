/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDisplayDAO;
import com.internousdev.ecsite.dao.CartInsertDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class LoginAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private String loginUserId;
	private String loginPassword;
	private LoginDAO logDAO=new LoginDAO();
	private LoginDTO logDTO=new LoginDTO();
	private String errorMessage;
	private String mesFlg;
	private String page;
	private List<CartDTO> cartList;

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
		String result=ERROR;



			logDTO=logDAO.getLoginUserInfo(loginUserId,loginPassword);
			session.put("loginUser", logDTO);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){

			session.put("login_user_id", logDTO.getLoginId());

			if(Objects.nonNull(session.get("tempCartList"))){
				CartInsertDAO cartDAO=new CartInsertDAO();
				cartDAO.insertCart(session.get("tempCartList"),session.get("login_user_id"));
				session.remove("tempCartList");
			}

			if(page.equals("home")){
				result="home";
			}

			if(page.equals("cart")){
				CartDisplayDAO dao=new CartDisplayDAO();
				result="cart";
				cartList=dao.select(session.get("login_user_id").toString());

				session.put("cartList", cartList);
			}

			if(page.equals("buyItem")) {
				result="buyItem";
			}

			if(page.equals("itemDetail")) {
				result="itemDetail";
			}

			if(page.equals("buyItemConfirm")) {
				result="buyItemConfirm";
			}
			if(page.equals("insertCart")) {
				result="insertCart";
			}



		}else{
			errorMessage="idまたはpasswordが違います";
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
		this.loginPassword =loginPassword;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}



	/**
	 * errorMessageを取得します。
	 * @return errorMessage
	 */
	public String getErrorMessage() {
	    return errorMessage;
	}

	/**
	 * mesFlgを取得します。
	 * @return mesFlg
	 */
	public String getMesFlg() {
	    return mesFlg;
	}

	/**
	 * mesFlgを設定します。
	 * @param mesFlg mesFlg
	 */
	public void setMesFlg(String mesFlg) {
	    this.mesFlg = mesFlg;
	}

	/**
	 * pageを取得します。
	 * @return page
	 */
	public String getPage() {
	    return page;
	}

	/**
	 * pageを設定します。
	 * @param page page
	 */
	public void setPage(String page) {
	    this.page = page;
	}

	/**
	 * cartListを取得します。
	 * @return cartList
	 */
	public List<CartDTO> getCartList() {
	    return cartList;
	}

	/**
	 * cartListを設定します。
	 * @param cartList cartList
	 */
	public void setCartList(List<CartDTO> cartList) {
	    this.cartList = cartList;
	}



}
