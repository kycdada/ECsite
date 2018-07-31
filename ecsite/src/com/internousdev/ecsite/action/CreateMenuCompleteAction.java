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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.CreateMenuDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author internousdev
 *
 */
public class CreateMenuCompleteAction extends ActionSupport implements SessionAware,ServletContextAware{

	private Map<String,Object> session;
	private String itemName;
	private String itemPrice;
	private String itemKata;
	private String itemHira;
	private String itemCategory;

	private String itemExplain;
	private String imgFileName;
	private String imgContentType;
	private File img;
	private ServletContext servletContext;
	private String createFlg="0";
	private List<BuyItemDTO> itemList=new ArrayList<BuyItemDTO>();


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
		if(Objects.isNull(imgFileName ) || imgFileName.isEmpty()){
			addActionError("画像が空欄です");
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
		if (session.get("ICF").equals(true) || session.get("subMasterFlg").equals(false)){
			if(Objects.nonNull(session.get("masterId"))){
		if(itemName !=null && itemPrice !=null && itemKata !=null && itemHira !=null && itemExplain !=null && Objects.nonNull(img)){
			if(!(itemName.equals("")) && !(itemPrice.equals("")) && !(itemKata.equals("")) && !(itemHira.equals("")) &&  !(itemExplain.equals(""))) {
			rs=SUCCESS;
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
			BuyItemDAO itemDAO=new BuyItemDAO();
			CreateMenuDAO dao=new CreateMenuDAO();
			int i=dao.insert(itemName,itemPrice,itemKata,itemHira,itemCategory,itemExplain,imgPath);
			if(i>0) {
				createFlg="1";
				itemList=itemDAO.getBuyItemInfo();
				session.put("itemMenuList", itemList);
			}

			}
			}
			}
		}
		return rs;
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
	 * imgFileNameを取得します。
	 * @return imgFileName
	 */
	public String getImgFileName() {
	    return imgFileName;
	}


	/**
	 * imgFileNameを設定します。
	 * @param imgFileName imgFileName
	 */
	public void setImgFileName(String imgFileName) {
	    this.imgFileName = imgFileName;
	}


	/**
	 * imgContentTypeを取得します。
	 * @return imgContentType
	 */
	public String getImgContentType() {
	    return imgContentType;
	}


	/**
	 * imgContentTypeを設定します。
	 * @param imgContentType imgContentType
	 */
	public void setImgContentType(String imgContentType) {
	    this.imgContentType = imgContentType;
	}


	/**
	 * imgを取得します。
	 * @return img
	 */
	public File getImg() {
	    return img;
	}


	/**
	 * imgを設定します。
	 * @param img img
	 */
	public void setImg(File img) {
	    this.img = img;
	}


	/**
	 * servletContextを取得します。
	 * @return servletContext
	 */
	public ServletContext getServletContext() {
	    return servletContext;
	}


	/**
	 * servletContextを設定します。
	 * @param servletContext servletContext
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}


	/**
	 * createFlgを取得します。
	 * @return createFlg
	 */
	public String getCreateFlg() {
	    return createFlg;
	}


	/**
	 * createFlgを設定します。
	 * @param createFlg createFlg
	 */
	public void setCreateFlg(String createFlg) {
	    this.createFlg = createFlg;
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




}
