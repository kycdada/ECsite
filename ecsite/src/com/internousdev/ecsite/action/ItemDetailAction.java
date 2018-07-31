/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author yukei
 *
 */
public class ItemDetailAction extends ActionSupport implements SessionAware{
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemExplain;
	private String itemImgPath;
	Map<String,Object>session;

	public String execute(){
		session.put("id", id);
		session.put("itemName",itemName);
		session.put("itemPrice",itemPrice);
		session.put("itemExplain", itemExplain);
		session.put("itemImgPath", itemImgPath);

		return SUCCESS;

	}

	public String getId(){
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}


	public String getItemExplain(){
		return itemExplain;
	}
	public void setItemExplain(String itemExplain){
		this.itemExplain=itemExplain;
	}


	public String getItemImgPath() {
	    return itemImgPath;
	}


	public void setItemImgPath(String itemImgPath) {
	    this.itemImgPath = itemImgPath;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
