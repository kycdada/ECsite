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
public class SubMasterAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private int deleteFlg=0;
	private List<String> idList;
	private String nameEditFlg="";

	public String execute(){
		String rs=ERROR;
		List<SubMasterFlgDTO> flgDTOList=new ArrayList<SubMasterFlgDTO>();
		if(Objects.nonNull(session.get("masterId"))){
			MasterLoginDAO flgDAO=new MasterLoginDAO();
			SubMasterFlgDTO flgDTO=new SubMasterFlgDTO();
			flgDTO=flgDAO.getSubMasterFlg(session.get("masterId").toString());
			if(!(flgDTO.getSubMasterFlg())){
				session.put("subMasterFlg", flgDTO.getSubMasterFlg());
				rs=SUCCESS;

				if(Objects.nonNull(idList)){
						int del=flgDAO.delete(idList);
							if(del>0) {
								deleteFlg=del;
							}
					}
				if(nameEditFlg.equals("1") && Objects.nonNull(session.get("newSubMasId"))){
					int i=flgDAO.updateName(session.get("newSubMasName").toString(),session.get("newSubMasPass").toString(),session.get("newSubMasId").toString());
					if(i==2){
						rs=ERROR;
					}
				}

				flgDTOList=flgDAO.getSubMastersList();

					session.put("submasList", flgDTOList);


			}
		}
		return rs;
	}
	/**
	 * deleteFlgを取得します。
	 * @return deleteFlg
	 */
	public int getDeleteFlg() {
		return deleteFlg;
	}
	/**
	 * deleteFlgを設定します。
	 * @param deleteFlg deleteFlg
	 */
	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
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
	 * idListを取得します。
	 * @return idList
	 */
	public List<String> getIdList() {
		return idList;
	}
	/**
	 * idListを設定します。
	 * @param idList idList
	 */
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	/**
	 * nameEditFlgを取得します。
	 * @return nameEditFlg
	 */
	public String getNameEditFlg() {
	    return nameEditFlg;
	}
	/**
	 * nameEditFlgを設定します。
	 * @param nameEditFlg nameEditFlg
	 */
	public void setNameEditFlg(String nameEditFlg) {
	    this.nameEditFlg = nameEditFlg;
	}

}
