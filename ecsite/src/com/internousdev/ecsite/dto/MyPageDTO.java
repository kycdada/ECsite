/**
 *
 */
package com.internousdev.ecsite.dto;

/**
 * @author internousdev
 *
 */
public class MyPageDTO {
	private String itemName;
	private String orderNumber;
	private String totalPrice;
	private String totalCount;
	private String payment;
	private String userName;
	private String id;
	private String insert_date;
	private String item_transaction_id;

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	/**
	 * orderNumberを取得します。
	 * @return orderNumber
	 */
	public String getOrderNumber() {
	    return orderNumber;
	}
	/**
	 * orderNumberを設定します。
	 * @param orderNumber orderNumber
	 */
	public void setOrderNumber(String orderNumber) {
	    this.orderNumber = orderNumber;
	}
	public String getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice){
		this.totalPrice=totalPrice;
	}
	public String getTotalCount(){
		return totalCount;
	}
	public void setTotalCount(String totalCount){
		this.totalCount=totalCount;
	}
	public String getPayment(){
		return payment;
	}
	public void setPayment(String payment){
		this.payment=payment;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getInsert_date(){
		return insert_date;
	}
	public void setInsert_date(String insert_date){
		this.insert_date=insert_date;
	}


	public String getItem_transaction_id() {
	    return item_transaction_id;
	}

	public void setItem_transaction_id(String item_transaction_id) {
	    this.item_transaction_id = item_transaction_id;
	}
}
