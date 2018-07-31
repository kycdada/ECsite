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
public class BuyItemAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String count;

	public String execute(){
		String result=SUCCESS;
		session.put("count", count);
		int intCount=Integer.parseInt(count.toString());
		int intPrice=Integer.parseInt(session.get("itemPrice").toString());
		session.put("total_price",intCount*intPrice);

		return result;
	}




	public String getCount(){
		return count;
	}
	public void setCount(String count){
		this.count=count;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
