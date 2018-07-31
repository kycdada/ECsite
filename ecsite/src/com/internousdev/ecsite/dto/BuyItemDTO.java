/**
 *
 */
package com.internousdev.ecsite.dto;

/**
 * @author internousdev
 *
 */
public class BuyItemDTO {
	private int id;
	private String itemName;
	private String itemPrice;
	private String count;
	private String itemExplain;
	private String itemCategory;
	private String itemImgPath;
	private String itemKata;
	private String itemHira;

	/**
	 * idを取得します。
	 * @return id
	 */
	public int getId(){
		return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(int id){
		this.id=id;
	}

	/**
	 * itemNameを取得します。
	 * @return itemName
	 */
	public String getItemName(){
		return itemName;
	}
	/**
	 * itemNameを設定します。
	 * @param itemName itemName
	 */
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	/**
	 * itemPriceを取得します。
	 * @return itemPrice
	 */
	public String getItemPrice(){
		return itemPrice;
	}
	/**
	 * itemPriceを設定します。
	 * @param itemPrice itemPrice
	 */
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}
	/**
	 * countを取得します。
	 * @return count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * countを設定します。
	 * @param count count
	 */
	public void setCount(String count) {
		this.count=count;
	}
	/**
	 * itemExplainを取得します。
	 * @return itemExplain
	 */
	public String getItemExplain(){
		return itemExplain;
	}
	/**
	 * itemExplainを設定します。
	 * @param itemExplain itemExplain
	 */
	public void setItemExplain(String itemExplain){
		this.itemExplain=itemExplain;
	}

	/**
	 * itemCategoryを取得します。
	 * @return itemCategory
	 */
	public String getItemCategory() {
	    return itemCategory;
	}
	/**
	 * itemCategoryを設定します。
	 * @param itemCategory itemCategory
	 */
	public void setItemCategory(String itemCategory) {
	    this.itemCategory = itemCategory;
	}

	public String getItemImgPath() {
	    return itemImgPath;
	}

	public void setItemImgPath(String itemImgPath) {
	    this.itemImgPath = itemImgPath;
	}
	/**
	 * itemKataを取得します。
	 * @return itemKata
	 */
	public String getItemKata() {
	    return itemKata;
	}
	/**
	 * itemKataを設定します。
	 * @param itemKata itemKata
	 */
	public void setItemKata(String itemKata) {
	    this.itemKata = itemKata;
	}
	/**
	 * itemHiraを取得します。
	 * @return itemHira
	 */
	public String getItemHira() {
	    return itemHira;
	}
	/**
	 * itemHiraを設定します。
	 * @param itemHira itemHira
	 */
	public void setItemHira(String itemHira) {
	    this.itemHira = itemHira;
	}


}
