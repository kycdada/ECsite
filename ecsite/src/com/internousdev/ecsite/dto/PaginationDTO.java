/**
 *
 */
package com.internousdev.ecsite.dto;

import java.util.List;

/**
 * @author internousdev
 *
 */
public class PaginationDTO {
	//全ページ数
	private int totalPagesize;
	//現在のページ数
	private int currentPageNo;
	//全レコード数(0スタート)
	private int recordsize;
	//開始レコードNO
	private int startRecordNo;
	//終了レコードNo
	private int endRecordNo;
	//ページNoList
	private List<Integer> pageNoList;
	//ページに表示するレコード
	private List<BuyItemDTO> currentItemInfoPage;
	//次ページが存在するか
	private boolean hasNext;
	//前ページが存在するか
	private boolean hasPre;
	//次のページNp
	private int hasNextNo;
	//前のページNo
	private int hasPreNo;

	/**
	 * totalPagesizeを取得します。
	 * @return totalPagesize
	 */
	public int getTotalPagesize() {
	    return totalPagesize;
	}
	/**
	 * totalPagesizeを設定します。
	 * @param totalPagesize totalPagesize
	 */
	public void setTotalPagesize(int totalPagesize) {
	    this.totalPagesize = totalPagesize;
	}
	/**
	 * currentPageNoを取得します。
	 * @return currentPageNo
	 */
	public int getCurrentPageNo() {
	    return currentPageNo;
	}
	/**
	 * currentPageNoを設定します。
	 * @param currentPageNo currentPageNo
	 */
	public void setCurrentPageNo(int currentPageNo) {
	    this.currentPageNo = currentPageNo;
	}
	/**
	 * Recordsizeを取得します。
	 * @return Recordsize
	 */
	public int getRecordsize() {
	    return recordsize;
	}
	/**
	 * Recordsizeを設定します。
	 * @param Recordsize Recordsize
	 */
	public void setRecordsize(int recordsize) {
	    this.recordsize = recordsize;
	}
	/**
	 * startRecordNoを取得します。
	 * @return startRecordNo
	 */
	public int getStartRecordNo() {
	    return startRecordNo;
	}
	/**
	 * startRecordNoを設定します。
	 * @param startRecordNo startRecordNo
	 */
	public void setStartRecordNo(int startRecordNo) {
	    this.startRecordNo = startRecordNo;
	}
	/**
	 * endRecordNoを取得します。
	 * @return endRecordNo
	 */
	public int getEndRecordNo() {
	    return endRecordNo;
	}
	/**
	 * endRecordNoを設定します。
	 * @param endRecordNo endRecordNo
	 */
	public void setEndRecordNo(int endRecordNo) {
	    this.endRecordNo = endRecordNo;
	}
	/**
	 * pageNoListを取得します。
	 * @return pageNoList
	 */
	public List<Integer> getPageNoList() {
	    return pageNoList;
	}
	/**
	 * pageNoListを設定します。
	 * @param pageNoList pageNoList
	 */
	public void setPageNoList(List<Integer> pageNoList) {
	    this.pageNoList = pageNoList;
	}
	/**
	 * currentItemInfoPageを取得します。
	 * @return currentItemInfoPage
	 */
	public List<BuyItemDTO> getCurrentItemInfoPage() {
	    return currentItemInfoPage;
	}
	/**
	 * currentItemInfoPageを設定します。
	 * @param currentItemInfoPage currentItemInfoPage
	 */
	public void setCurrentItemInfoPage(List<BuyItemDTO> currentItemInfoPage) {
	    this.currentItemInfoPage = currentItemInfoPage;
	}
	/**
	 * hasNextを取得します。
	 * @return hasNext
	 */
	public boolean isHasNext() {
	    return hasNext;
	}
	/**
	 * hasNextを設定します。
	 * @param hasNext hasNext
	 */
	public void setHasNext(boolean hasNext) {
	    this.hasNext = hasNext;
	}
	/**
	 * hasPreを取得します。
	 * @return hasPre
	 */
	public boolean isHasPre() {
	    return hasPre;
	}
	/**
	 * hasPreを設定します。
	 * @param hasPre hasPre
	 */
	public void setHasPre(boolean hasPre) {
	    this.hasPre = hasPre;
	}
	/**
	 * hasNextNoを取得します。
	 * @return hasNextNo
	 */
	public int getHasNextNo() {
	    return hasNextNo;
	}
	/**
	 * hasNextNoを設定します。
	 * @param hasNextNo hasNextNo
	 */
	public void setHasNextNo(int hasNextNo) {
	    this.hasNextNo = hasNextNo;
	}
	/**
	 * hasPreNoを取得します。
	 * @return hasPreNo
	 */
	public int getHasPreNo() {
	    return hasPreNo;
	}
	/**
	 * hasPreNoを設定します。
	 * @param hasPreNo hasPreNo
	 */
	public void setHasPreNo(int hasPreNo) {
	    this.hasPreNo = hasPreNo;
	}



}
