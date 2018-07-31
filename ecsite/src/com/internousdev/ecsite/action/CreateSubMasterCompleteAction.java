/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.List;
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
public class CreateSubMasterCompleteAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private int insertFlg=0;
	public String execute(){
		String rs=ERROR;
		MasterLoginDAO dao=new MasterLoginDAO();
		if(Objects.nonNull(session.get("masterId"))){
			if(!(Boolean.valueOf(session.get("subMasterFlg").toString()))){
				int i=dao.insertCreate((SubMasterFlgDTO)session.get("newSubDTO"));
				if(i>0){
					rs=SUCCESS;
					insertFlg=i;
					List<SubMasterFlgDTO> dtoList=new ArrayList<SubMasterFlgDTO>();
					dtoList=dao.getSubMastersList();
					session.put("submasList", dtoList);
				}
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
	 * insertFlgを取得します。
	 * @return insertFlg
	 */
	public int getInsertFlg() {
	    return insertFlg;
	}

}
