package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.CartInfoDAO;
import com.internousdev.testsampleweb.dto.CartInfoDTO;
import com.internousdev.testsampleweb.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String productCount;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;

	private String categoryId;

	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;
		String userId = null;
		String tempUserId = null;

		/**
		 * ログイン状態かどうかを判定
		 * ログインID、tempUserIdがsessionに保持されているかどうかを調べる
		 */
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRandomValue());
			//条件に一致しなければ暫定ユーザーIDをランダムにsessionに格納
		}

		//ログイン状態の場合
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
			//値を取り出しそのままユーザーIDに代入
		}


		//暫定ユーザーIDのみを持っている場合
		if(!(session.containsKey("loginId")) && session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
			/**
			 * ユーザーIDに暫定ユーザーIDを代入
			 * 暫定ユーザーIDにもそのまま代入する
			 */
		}

		productCount = String.valueOf((productCount.split(" ,", 0))[0]);

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int count = cartInfoDAO.regist(userId, tempUserId, productId, productCount, price);
		// userID、tempUserIdを元にカートに商品を登録する


		if(count > 0){
			result = SUCCESS;
			//登録できればSUCCESS
		}

		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

		if(!(iterator.hasNext())){
			cartInfoDTOList = null;
		}
		/**
		 * 先ほど登録したカート情報を取得する
		 * 結果はiteratorを利用して反復処理する
		 *
		 * if文内でhasNextを利用、次の要素がなければカート情報はnullにしておく
		 */

		session.put("cartInfoDTOList", cartInfoDTOList);
		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		return result;
		/**
		 * session内にカート情報のListを格納
		 * cartInfoDAOの合計金額を算出するメソッドgetTotalPriceを利用、
		 * 結果をsessionに格納
		 */
 	}


	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductname(String productName){
		this.productName = productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	public String getImageFilePath(){
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setProductCount(String productCount){
		this.productCount = productCount;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}

	public void settReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}

	public Date getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setPRoductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
