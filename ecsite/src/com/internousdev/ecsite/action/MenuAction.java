/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class MenuAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private List<BuyItemDTO> itemList;
	private List<String> deleteIdList;
	private int deleteCount;
	public String execute(){
		BuyItemDAO itemDAO=new BuyItemDAO();
		String rs=ERROR;
		if(session.get("masterId")!=null){
			if (session.get("ICF").equals(true) || session.get("IEF").equals(true) || session.get("IDF").equals(true) || session.get("subMasterFlg").equals(false)){
				if(deleteIdList!=null){
					if ( session.get("IDF").equals(true) || session.get("subMasterFlg").equals(false)){
						for(int i=0;i<deleteIdList.size();i++){
						int res=itemDAO.deleteList(deleteIdList.get(i));
							if(res>0){
							deleteCount++;
							}
						}
					}

				}


			rs=SUCCESS;
			itemList=itemDAO.getBuyItemInfo();
			session.put("itemMenuList", itemList);
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
	 * itemListを取得します。
	 * @return itemList
	 */
	public List<BuyItemDTO> getItemList() {
	    return itemList;
	}
	/**
	 * itemListを設定します。
	 * @param itemList itemList
	 */
	public void setItemList(List<BuyItemDTO> itemList) {
	    this.itemList = itemList;
	}
	/**
	 * deleteIdListを設定します。
	 * @param deleteIdList deleteIdList
	 */
	public void setDeleteIdList(List<String> deleteIdList) {
	    this.deleteIdList = deleteIdList;
	}
	/**
	 * deleteIdListを取得します。
	 * @return deleteIdList
	 */
	public List<String> getDeleteIdList() {
	    return deleteIdList;
	}
	/**
	 * deleteCountを取得します。
	 * @return deleteCount
	 */
	public int getDeleteCount() {
	    return deleteCount;
	}
	/**
	 * deleteCountを設定します。
	 * @param deleteCount deleteCount
	 */
	public void setDeleteCount(int deleteCount) {
	    this.deleteCount = deleteCount;
	}


}
