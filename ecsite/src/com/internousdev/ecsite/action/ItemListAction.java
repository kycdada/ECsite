/**
 *
 */
package com.internousdev.ecsite.action;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.PaginationDTO;
import com.internousdev.ecsite.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class ItemListAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private String serch;
	private String pageNo;
	public String execute(){
		String result=ERROR;
		List<BuyItemDTO> itemDTOList=new ArrayList<BuyItemDTO>();
		BuyItemDAO itemDAO=new BuyItemDAO();
		if(Objects.nonNull(serch)) {
			String word=Normalizer.normalize(serch, Form.NFKC);
			Pattern p=Pattern.compile("[,/\\s]+");
			String[] words=p.split(word);

			itemDTOList=itemDAO.getSerchResult(words);

		}else {
		itemDTOList=itemDAO.getBuyItemInfo();
		}
		if(Objects.nonNull(itemDTOList)){
			if(Objects.isNull(pageNo)){
				PaginationDTO dto=new PaginationDTO();
				Pagination page=new Pagination();
				dto=page.getPage(itemDTOList,6);
				session.put("totalPageSize", dto.getTotalPagesize());
				session.put("currentPageNo", dto.getCurrentPageNo());
				session.put("recordSize", dto.getRecordsize());
				session.put("startRecordNo", dto.getStartRecordNo());
				session.put("endRecordNo", dto.getEndRecordNo());
				session.put("pageNoList", dto.getPageNoList());
				session.put("currentItemInfoPage",dto.getCurrentItemInfoPage());
				session.put("hasNext",dto.isHasNext());
				session.put("hasNextNo", dto.getHasNextNo());
				session.put("hasPre", dto.isHasPre());
				session.put("hasPreNo", dto.getHasNextNo());
				result=SUCCESS;
			}else{
				PaginationDTO dto=new PaginationDTO();
				Pagination page=new Pagination();
				dto=page.getPage(itemDTOList,6,pageNo);
				session.put("totalPageSize", dto.getTotalPagesize());
				session.put("currentPageNo", dto.getCurrentPageNo());
				session.put("recordSize", dto.getRecordsize());
				session.put("startRecordNo", dto.getStartRecordNo());
				session.put("endRecordNo", dto.getEndRecordNo());
				session.put("pageNoList", dto.getPageNoList());
				session.put("currentItemInfoPage",dto.getCurrentItemInfoPage());
				session.put("hasNext",dto.isHasNext());
				session.put("hasNextNo", dto.getHasNextNo());
				session.put("hasPre", dto.isHasPre());
				session.put("hasPreNo", dto.getHasNextNo());
				result=SUCCESS;
			}
		}
		return result;
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
	public String getSerch() {
		return serch;
	}
	public void setSerch(String serch) {
		this.serch = serch;
	}
	/**
	 * pageNoを取得します。
	 * @return pageNo
	 */
	public String getPageNo() {
	    return pageNo;
	}
	/**
	 * pageNoを設定します。
	 * @param pageNo pageNo
	 */
	public void setPageNo(String pageNo) {
	    this.pageNo = pageNo;
	}
}
