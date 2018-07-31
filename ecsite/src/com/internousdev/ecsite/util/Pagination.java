/**
 *
 */
package com.internousdev.ecsite.util;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.PaginationDTO;
/**
 * @author internousdev
 *
 */
public class Pagination {

	public PaginationDTO getPage(List<BuyItemDTO> list,int pageSize){
		PaginationDTO dto=new PaginationDTO();
		//int同士の計算はintが返ってくるためdoubleに計算前にキャスト
		double d=(double)list.size()/pageSize;

		dto.setTotalPagesize((int)(Math.ceil(d)));
		System.out.println(Math.ceil(d));
		dto.setCurrentPageNo(1);
		dto.setRecordsize(list.size()-1);
		dto.setStartRecordNo(pageSize*(dto.getCurrentPageNo()-1));
		dto.setEndRecordNo(Math.min((dto.getStartRecordNo()+pageSize-1),(list.size()-1)));
		List<Integer> pageNumber=new ArrayList<Integer>();
		for(int i=1;i<=dto.getTotalPagesize();i++){
			pageNumber.add(i);
		}
		dto.setPageNoList(pageNumber);
		List<BuyItemDTO> itemInfoList=new ArrayList<BuyItemDTO>();
		for(int i=dto.getStartRecordNo();i<=dto.getEndRecordNo();i++){
			itemInfoList.add(list.get(i));
		}
		dto.setCurrentItemInfoPage(itemInfoList);

		if((dto.getEndRecordNo())==list.size()-1){
			dto.setHasNext(false);
		}else{
			dto.setHasNext(true);
			dto.setHasNextNo(dto.getCurrentPageNo()+1);
		}

		if(dto.getCurrentPageNo()-1<=0){
			dto.setHasPre(false);
		}else{
			dto.setHasPre(true);
			dto.setHasPreNo(dto.getCurrentPageNo()-1);
		}

		return dto;

	}

	public PaginationDTO getPage(List<BuyItemDTO> list,int pageSize,String PageNo){
		PaginationDTO dto=new PaginationDTO();
		//int同士の計算はintが返ってくるためdoubleに計算前にキャスト
		double d=(double)list.size()/pageSize;

		dto.setTotalPagesize((int)(Math.ceil(d)));
		System.out.println(Math.ceil(d));
		dto.setCurrentPageNo(Integer.parseInt(PageNo));
		dto.setRecordsize(list.size()-1);
		dto.setStartRecordNo(pageSize*(dto.getCurrentPageNo()-1));
		dto.setEndRecordNo(Math.min((dto.getStartRecordNo()+pageSize-1),(list.size()-1)));
		List<Integer> pageNumber=new ArrayList<Integer>();
		for(int i=1;i<=dto.getTotalPagesize();i++){
			pageNumber.add(i);
		}
		dto.setPageNoList(pageNumber);
		List<BuyItemDTO> itemInfoList=new ArrayList<BuyItemDTO>();
		for(int i=dto.getStartRecordNo();i<=dto.getEndRecordNo();i++){
			itemInfoList.add(list.get(i));
		}
		dto.setCurrentItemInfoPage(itemInfoList);

		if(dto.getEndRecordNo()==list.size()-1){
			dto.setHasNext(false);
		}else{
			dto.setHasNext(true);
			dto.setHasNextNo(dto.getCurrentPageNo()+1);
		}

		if(dto.getCurrentPageNo()-1<=0){
			dto.setHasPre(false);
		}else{
			dto.setHasPre(true);
			dto.setHasPreNo(dto.getCurrentPageNo()-1);
		}

		return dto;

	}
}
