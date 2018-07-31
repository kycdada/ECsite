/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MasterLoginDAO;
import com.internousdev.ecsite.dto.SubMasterFlgDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author yukei
 *
 */
public class SubMasEditAction extends ActionSupport implements SessionAware{
private Map<String,Object>session;
private List<String> reUserCreateFlg;
private List<String> reUserEditFlg;
private List<String> reUserDeleteFlg;
private List<String> reItemCreateFlg;
private List<String> reItemEditFlg;
private List<String> reItemDeleteFlg;
private List<String> idList;

public String execute() {
	String rs=ERROR;
	if(Objects.nonNull(session.get("masterId").toString()) && !(Boolean.valueOf(session.get("subMasterFlg").toString()))){
		MasterLoginDAO dao=new MasterLoginDAO();
		dao.upDate(reUserCreateFlg, reUserEditFlg, reUserDeleteFlg, reItemCreateFlg, reItemEditFlg, reItemDeleteFlg, idList);
		List<SubMasterFlgDTO> list=dao.getSubMastersList();
		session.put("submasList", list);
		rs=SUCCESS;
	}
	return rs;
}

/**
 * sessionを取得します。
 * @return session
 */
public Map<String, Object> getSession() {
return session;
}

/**
 * sessionを設定します。
 * @param session session
 */
public void setSession(Map<String, Object> session) {
this.session = session;
}

/**
 * reUserCreateFlgを取得します。
 * @return reUserCreateFlg
 */
public List<String> getReUserCreateFlg() {
return reUserCreateFlg;
}

/**
 * reUserCreateFlgを設定します。
 * @param reUserCreateFlg reUserCreateFlg
 */
public void setReUserCreateFlg(List<String> reUserCreateFlg) {
this.reUserCreateFlg = reUserCreateFlg;
}

/**
 * reUserEditFlgを取得します。
 * @return reUserEditFlg
 */
public List<String> getReUserEditFlg() {
return reUserEditFlg;
}

/**
 * reUserEditFlgを設定します。
 * @param reUserEditFlg reUserEditFlg
 */
public void setReUserEditFlg(List<String> reUserEditFlg) {
this.reUserEditFlg = reUserEditFlg;
}

/**
 * reUserDeleteFlgを取得します。
 * @return reUserDeleteFlg
 */
public List<String> getReUserDeleteFlg() {
return reUserDeleteFlg;
}

/**
 * reUserDeleteFlgを設定します。
 * @param reUserDeleteFlg reUserDeleteFlg
 */
public void setReUserDeleteFlg(List<String> reUserDeleteFlg) {
this.reUserDeleteFlg = reUserDeleteFlg;
}

/**
 * reItemCreateFlgを取得します。
 * @return reItemCreateFlg
 */
public List<String> getReItemCreateFlg() {
    return reItemCreateFlg;
}

/**
 * reItemCreateFlgを設定します。
 * @param reItemCreateFlg reItemCreateFlg
 */
public void setReItemCreateFlg(List<String> reItemCreateFlg) {
    this.reItemCreateFlg = reItemCreateFlg;
}

/**
 * reItemEditFlgを取得します。
 * @return reItemEditFlg
 */
public List<String> getReItemEditFlg() {
    return reItemEditFlg;
}

/**
 * reItemEditFlgを設定します。
 * @param reItemEditFlg reItemEditFlg
 */
public void setReItemEditFlg(List<String> reItemEditFlg) {
    this.reItemEditFlg = reItemEditFlg;
}

/**
 * reItemDeleteFlgを取得します。
 * @return reItemDeleteFlg
 */
public List<String> getReItemDeleteFlg() {
    return reItemDeleteFlg;
}

/**
 * reItemDeleteFlgを設定します。
 * @param reItemDeleteFlg reItemDeleteFlg
 */
public void setReItemDeleteFlg(List<String> reItemDeleteFlg) {
    this.reItemDeleteFlg = reItemDeleteFlg;
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


}
