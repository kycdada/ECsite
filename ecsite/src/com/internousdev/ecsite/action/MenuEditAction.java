/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class MenuEditAction extends ActionSupport implements SessionAware{
	private String id;
	private BuyItemDTO dto=new BuyItemDTO();
	private BuyItemDAO dao=new BuyItemDAO();
	Map<String,Object> session;
	public String execute(){
		String rs=ERROR;
		if (session.get("IEF").equals(true) || session.get("subMasterFlg").equals(false)){
		dto=dao.getBuyItemInfo(id);
		if(dto!=null){
			rs=SUCCESS;
			session.put("editMenu", dto);
		}
		}
		return rs;

	}
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
	 * dtoを取得します。
	 * @return dto
	 */
	public BuyItemDTO getDto() {
	    return dto;
	}
	/**
	 * dtoを設定します。
	 * @param dto dto
	 */
	public void setDto(BuyItemDTO dto) {
	    this.dto = dto;
	}
	/**
	 * daoを取得します。
	 * @return dao
	 */
	public BuyItemDAO getDao() {
	    return dao;
	}
	/**
	 * daoを設定します。
	 * @param dao dao
	 */
	public void setDao(BuyItemDAO dao) {
	    this.dao = dao;
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
}
