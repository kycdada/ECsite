/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class MyPageAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private List<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg="0";
	private String message;
	private MyPageDAO dao=new MyPageDAO();
	private List<String> idList;
	private List<String> numberList;
	private Map<String,ArrayList<MyPageDTO>> map=new HashMap<String,ArrayList<MyPageDTO>>();


	public String execute(){
		if(!session.containsKey("login_user_id")){
			return ERROR;
		}
		String user_master_id=session.get("login_user_id").toString();
		myPageList=dao.getMyPageUserInfo(user_master_id);
		numberList=dao.getBuyItemDay(user_master_id);
		for(int i=0;i<numberList.size();i++){
			ArrayList<MyPageDTO> inList=new ArrayList<MyPageDTO>();
			String stri=Integer.toString(i);
			for(int j=0;j<myPageList.size();j++){
				if(numberList.get(i).equals(myPageList.get(j).getOrderNumber())){

					inList.add(myPageList.get(j));
				}
			}
			map.put(stri, inList);
		}

		if(idList!=null){
			for(String id:idList){
			delete(id,user_master_id);
			}
			myPageList=dao.getMyPageUserInfo(user_master_id);
			numberList=dao.getBuyItemDay(user_master_id);
		}

		if(deleteFlg.equals("1")){
			delete();
			myPageList=dao.getMyPageUserInfo(user_master_id);
			numberList=dao.getBuyItemDay(user_master_id);
		}
		String result=SUCCESS;
		return result;
	}

	public void delete(String id,String user_master_id){
		int res=dao.buyItemHistoryDelete(id,user_master_id);
		if(res>0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}


	public void delete(){
		String user_master_id=session.get("login_user_id").toString();

		int res=dao.buyItemHistoryDelete(user_master_id);
		if(res>0){
			setMessage("商品情報を全て削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}
	public List<MyPageDTO> getMyPageList(){
		return myPageList;
	}
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
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
	 * numberListを取得します。
	 * @return numberList
	 */
	public List<String> getNumberList() {
	    return numberList;
	}

	/**
	 * numberListを設定します。
	 * @param numberList numberList
	 */
	public void setNumberList(List<String> numberList) {
	    this.numberList = numberList;
	}

	/**
	 * mapを取得します。
	 * @return map
	 */
	public Map<String,ArrayList<MyPageDTO>> getMap() {
	    return map;
	}


}
