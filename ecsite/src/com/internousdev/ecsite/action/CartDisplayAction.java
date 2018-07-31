/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartDisplayDAO;
import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class CartDisplayAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private List<CartDTO> cartList;
	private String deleteFlg="0";
	private String Message;
	private List<String> deleteList;
	public String execute(){
		String res=ERROR;
		if(deleteFlg.equals("1")){
			session.remove("tempCartList");
		}

		if(Objects.nonNull(session.get("login_user_id"))){
			CartDisplayDAO dao=new CartDisplayDAO();
			String userId=session.get("login_user_id").toString();
			cartList=dao.select(userId);

			if(deleteList!=null){
				for(String id:deleteList){
					delete(id,userId);
				}
			}

			if(deleteFlg.equals("1")){
				delete();
			}

			int p=dao.getSumPrice();
			session.put("sumPrice", p);
			session.put("cartList",cartList);

			if(cartList!=null){
				res=SUCCESS;
			}
		}else if(Objects.nonNull(session.get("tempCartList"))){




			List <CartDTO> list=CommonUtility.autoCast(session.get("tempCartList"));
			int sumPrice=0;



			if(Objects.nonNull(deleteList)){
				for(String itemId:deleteList){
					Iterator<CartDTO> ite1=list.iterator();
					while(ite1.hasNext()){
						CartDTO item=ite1.next();
						if(item.getId().equals(itemId)){
							ite1.remove();
						}
					}
				}
			}

			Iterator<CartDTO> ite2=list.iterator();
			while(ite2.hasNext()){
				sumPrice+=Integer.parseInt(ite2.next().getTotalPrice());
				System.out.println(sumPrice);
			}
			session.put("sumPrice", sumPrice);
			session.put("tempCartList", list);
			res=SUCCESS;
		}
		return res;
	}

	public void delete(String itemId,String user_master_id){
		CartDisplayDAO dao=new CartDisplayDAO();
		int res=dao.delete(itemId,user_master_id);
		cartList=dao.select(user_master_id);
		if(res>0){
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}
		public void delete(){
			String user_master_id=session.get("login_user_id").toString();
			CartDisplayDAO dao=new CartDisplayDAO();
			int res=dao.delete(user_master_id);
			cartList=dao.select(user_master_id);
			if(res>0){
				setMessage("商品情報を全て削除しました。");
			}else if(res==0){
				setMessage("商品情報の削除に失敗しました。");
			}
		}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public List<CartDTO> getCartList(){
		return cartList;
	}



	public void setCartList(List<CartDTO> cartList) {
	    this.cartList = cartList;
	}

	public String getDeleteFlg() {
	    return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
	    this.deleteFlg = deleteFlg;
	}



	public String getMessage() {
	    return Message;
	}

	public void setMessage(String Message) {
	    this.Message = Message;
	}


	public List<String> getDeleteList() {
	    return deleteList;
	}


	public void setDeleteList(List<String> deleteList) {
	    this.deleteList = deleteList;
	}
}
