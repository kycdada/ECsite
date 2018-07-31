/**
 *
 */
package com.internousdev.ecsite.dto;

/**
 * @author internousdev
 *
 */
public class CartDTO {
	private String id;
	private String itemName;
	private String itemPrice;
	private String itemExplain;
	private String totalPrice;
	private String count;
	private String userId;
	private String itemTransactionId;
	private String ItemImgPath;

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	public String getCount(){
		return count;
	}
	public void setCount(String count){
		this.count=count;
	}
	public String getId(){
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}

	public String getItemExplain(){
		return itemExplain;
	}
	public void setItemExplain(String itemExplain){
		this.itemExplain=itemExplain;
	}
	public String getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice){
		this.totalPrice=totalPrice;
	}
	/**
	 * itemTransactionIdを取得します。
	 * @return itemTransactionId
	 */
	public String getItemTransactionId() {
	    return itemTransactionId;
	}
	/**
	 * itemTransactionIdを設定します。
	 * @param itemTransactionId itemTransactionId
	 */
	public void setItemTransactionId(String itemTransactionId) {
	    this.itemTransactionId = itemTransactionId;
	}

	public String getItemImgPath() {
	    return ItemImgPath;
	}


	public void setItemImgPath(String ItemImgPath) {
	    this.ItemImgPath = ItemImgPath;
	}


}
