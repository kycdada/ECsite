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
public class HomeAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	public String execute(){
		return SUCCESS;

	}
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}