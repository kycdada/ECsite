/**
 *
 */
package com.internousdev.ecsite.action;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.EditMenuDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class EditCompleteAction extends ActionSupport implements SessionAware,ServletContextAware{
	private String itemName;
	private String itemHira;
	private String itemKata;
	private String itemCategory;
	private String itemPrice;
	private String itemExplain;
	private String imgFileName;
	private String imgContentType;
	private File img;
	private ServletContext servletContext;
	private Map<String,Object> session;
	private int updateFlg=0;
	private List<BuyItemDTO> itemList;

	public void validate(){
		if(Objects.isNull(itemName) || itemName.isEmpty()){
			addActionError("商品名が空欄です");
		}
		if(Objects.isNull(itemPrice) || itemPrice.isEmpty()){
			addActionError("価格が空欄です");
		}
		if(Objects.isNull(itemHira) || itemHira.isEmpty()){
			addActionError("ふりがなが空欄です");
		}
		if(Objects.isNull(itemKata) || itemKata.isEmpty()){
			addActionError("フリガナが空欄です");
		}
		if(Objects.isNull(itemCategory) || itemCategory.isEmpty()){
			addActionError("カテゴリが空欄です");
		}
		if(Objects.isNull(itemExplain) || itemExplain.isEmpty()){
			addActionError("商品説明が空欄です");
		}
		if(itemName.length()<1 || itemName.length()>15){
			addActionError("商品名は1字以上15文字以下です");
		}
		if(!(itemPrice.matches("[0-9]+"))){
			addActionError("価格は半角数字です");
		}
		if(itemPrice.length()<1 || itemPrice.length()>8){
			addActionError("価格は１桁以上8桁以下です");
		}
		if(itemHira.length()<1 || itemHira.length()>15){
			addActionError("ふりがなは1字以上15文字以下です");
		}
		if(itemKata.length()<1 || itemKata.length()>15){
			addActionError("フリガナは1字以上15文字以下です");
		}
		if(itemCategory.length()<1 || itemCategory.length()>15){
			addActionError("カテゴリは1字以上15文字以下です");
		}
		if(itemExplain.length()<1 || itemExplain.length()>50){
			addActionError("商品説明は1字以上50文字以下です");
		}
		if(Objects.nonNull(imgFileName ) && !(imgFileName.isEmpty())){
			if(!(imgFileName.matches(".+jpg")) && !(imgFileName.matches(".+jpeg")) && !(imgFileName.matches(".+JPG")) && !(imgFileName.matches(".+JPEG")) && !(imgFileName.matches(".+gif"))) {
				addActionError("画像の拡張子は.jpg.jpeg.JPG.JPEG.gifのみです");
			}
		}

	}
	public String execute(){
		String rs=ERROR;
		EditMenuDAO dao=new EditMenuDAO();
		int id=((BuyItemDTO)session.get("editMenu")).getId();
		String stId=Integer.toString(id);
		if(!(itemName.equals(((BuyItemDTO)(session.get("editMenu"))).getItemName()))){
			updateFlg+=dao.upName(itemName,stId);
		}
		if(!(itemHira.equals(((BuyItemDTO)(session.get("editMenu"))).getItemHira()))){
			updateFlg+=dao.upHira(itemHira,stId);
		}
		if(!(itemKata.equals(((BuyItemDTO)(session.get("editMenu"))).getItemKata()))){
			updateFlg+=dao.upKata(itemKata,stId);
		}
		if(!(itemCategory.equals(((BuyItemDTO)(session.get("editMenu"))).getItemCategory()))){
			updateFlg+=dao.upCategory(itemCategory,stId);
		}
		if(!(itemPrice.equals(((BuyItemDTO)(session.get("editMenu"))).getItemPrice()))){
			updateFlg+=dao.upPrice(itemPrice,stId);
		}
		if(!(itemExplain.equals(((BuyItemDTO)(session.get("editMenu"))).getItemExplain()))){
			updateFlg+=dao.upExplain(itemExplain,stId);
		}
		if(Objects.nonNull(img)) {
			String imgPath="";
			String savePoint=servletContext.getRealPath("images");
			try{
			Path path=img.toPath();
			String ts =FileSystems.getDefault().getSeparator();
			if(!(Files.exists(Paths.get(savePoint)))){
				Files.createDirectory(Paths.get(savePoint));
				System.out.println("ディレクトリを作成しました。");
			}
			 File file = new File(savePoint+ ts +imgFileName);

		        if (file.createNewFile()){
		            System.out.println("ファイル作成成功");
		        }else{
		            System.out.println("ファイル作成失敗");
		        }

			Path pathTo=Paths.get(savePoint + ts +imgFileName);
			Files.copy(path, pathTo,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("コピーが成功しました。");
			imgPath="images/"+imgFileName;
			session.put("imgPath",imgPath );
			}catch(IOException e){
				e.printStackTrace();
			}
			updateFlg+=dao.upItemImg(imgPath, stId);
			}
		if(updateFlg>0){
			rs=SUCCESS;
		}
		BuyItemDAO itemDAO=new BuyItemDAO();
		itemList=itemDAO.getBuyItemInfo();
		session.put("itemMenuList", itemList);
		return rs;
	}

	/**
	 * itemNameを取得します。
	 * @return itemName
	 */
	public String getItemName() {
	    return itemName;
	}
	/**
	 * itemNameを設定します。
	 * @param itemName itemName
	 */
	public void setItemName(String itemName) {
	    this.itemName = itemName;
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
	 * itemPriceを取得します。
	 * @return itemPrice
	 */
	public String getItemPrice() {
	    return itemPrice;
	}
	/**
	 * itemPriceを設定します。
	 * @param itemPrice itemPrice
	 */
	public void setItemPrice(String itemPrice) {
	    this.itemPrice = itemPrice;
	}
	/**
	 * itemExplainを取得します。
	 * @return itemExplain
	 */
	public String getItemExplain() {
	    return itemExplain;
	}
	/**
	 * itemExplainを設定します。
	 * @param itemExplain itemExplain
	 */
	public void setItemExplain(String itemExplain) {
	    this.itemExplain = itemExplain;
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

	/**
	 * updateFlgを取得します。
	 * @return updateFlg
	 */
	public int getUpdateFlg() {
	    return updateFlg;
	}

	/**
	 * updateFlgを設定します。
	 * @param updateFlg updateFlg
	 */
	public void setUpdateFlg(int updateFlg) {
	    this.updateFlg = updateFlg;
	}

	/**
	 * itemListを取得します。
	 * @return itemList
	 */
	public List<BuyItemDTO> getItemList() {
	    return itemList;
	}

	/**
	 * itemListを設定します。
	 * @param itemList itemList
	 */
	public void setItemList(List<BuyItemDTO> itemList) {
	    this.itemList = itemList;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

}
