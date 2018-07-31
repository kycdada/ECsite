/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */


public class BuyItemCompleteAction extends ActionSupport implements SessionAware {
	private Map<String,Object> session;
	private String pay;
	public String execute(){
		String payment;
		if(pay.equals("0")) {
			payment="現金払い";
		}else {
			payment="クレジットカード";
		}
		BuyItemDAO dao=new BuyItemDAO();

		List<CartDTO> cartList=CommonUtility.autoCast(session.get("cartList"));
		String random=CommonUtility.getRandomValue();
		for(int i=0; i<cartList.size();i++)
		dao.buyItemComplete(
				random,
				cartList.get(i).getItemTransactionId(),
				cartList.get(i).getUserId(),
				cartList.get(i).getTotalPrice(),
				cartList.get(i).getCount(),
				payment);

		dao.deleteAllPreMove(session.get("login_user_id").toString());
		String result=SUCCESS;
		return result;
	}


	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public void setPay(String pay) {
		this.pay=pay;
	}
}