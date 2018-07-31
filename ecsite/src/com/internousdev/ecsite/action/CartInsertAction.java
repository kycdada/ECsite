/**
 *
 */
package com.internousdev.ecsite.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartInsertDAO;
import com.internousdev.ecsite.dto.CartDTO;
import com.internousdev.ecsite.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class CartInsertAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	public String execute(){
		String res=ERROR;
		if((Objects.nonNull(session.get("login_user_id")))){
			int i=0;
			CartInsertDAO dao =new CartInsertDAO();
			i=dao.insertCart(session.get("id").toString(), session.get("itemPrice").toString(), session.get("count").toString(),session.get("total_price").toString(),session.get("login_user_id").toString());
			if(i>0){
				res=SUCCESS;
			}
		}else{

			CartDTO dto=new CartDTO();
			dto.setId(session.get("id").toString());
			dto.setItemName(session.get("itemName").toString());
			dto.setItemPrice(session.get("itemPrice").toString());
			dto.setCount(session.get("count").toString());
			dto.setTotalPrice(session.get("total_price").toString());
			dto.setItemImgPath(session.get("itemImgPath").toString());

			if(Objects.nonNull(session.get("tempCartList"))){

				List<CartDTO> list=CommonUtility.autoCast(session.get("tempCartList"));
				Iterator<CartDTO> ite=list.iterator();
				int plusFlg=0;
				while(ite.hasNext()){
					CartDTO item=ite.next();
					if(item.getId().equals(session.get("id"))){
						int itemCount=Integer.parseInt(item.getCount())+Integer.parseInt(session.get("count").toString());
						item.setCount(String.valueOf(itemCount));
						plusFlg++;
					}
				}
				if(plusFlg==0){
					list.add(dto);
				}
				session.put("tempCartList",list);
			}else{
				List<CartDTO> list=new ArrayList<CartDTO>();
				list.add(dto);
				session.put("tempCartList", list);
			}


			res=SUCCESS;

		}
		return res;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
