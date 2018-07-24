package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.CartInfoDAO;
import com.internousdev.testsampleweb.dto.CartInfoDTO;
import com.internousdev.testsampleweb.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{

	private Collection<String> checkList;
	/**
	 * Collectionは要素をひとつのユニットに集めるもの
	 * Set、List、Queueなどの上の階層に属するもので
	 * Collectionを介して要素を追加することが出来る
	 */

	private String categoryId;
	private String productId;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;

	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseCompany;
	private String releaseDate;
	private String productCount;
	private String subtotal;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

	private Map<String, Object> session;

	//注意！　全部Stringでいいの？

	public String execute(){
		String result = ERROR;
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int count = 0;
		List<String> checkListErrorMessageList = new ArrayList<String>();

		if(checkList==null){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}

		for(String id : checkList){
			System.out.println(id);
			count += cartInfoDAO.delete(id);
		}

		if(count <= 0){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}else{
			String userId = null;
			List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

			if(session.containsKey("loginId")){
				userId = String.valueOf(session.get("loginId"));
			}else if(session.containsKey("tempUserId")){
				userId = String.valueOf(session.get("tempUserId"));
			}

			cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(userId);
			Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

			if(!(iterator.hasNext())){
				cartInfoDTOList = null;
			}
			session.put("cartInfoDTOList", cartInfoDTOList);

			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(userId)));
			session.put("totalPrice", totalPrice);

			sexList.add(MALE);
			sexList.add(FEMALE);

			result = SUCCESS;
		}
		return result;
	}

	public Collection<String> getCheckList(){
		return checkList;
	}

	public void setCheckList(Collection<String> checkList){
		this.checkList = checkList;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getProductId(){
		return productId;
	}

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public List<String> getSexList(){
		return sexList;
	}

	public void setSexList(List<String> sexList){
		this.sexList = sexList;
	}

	public String getDefaultSexValue(){
		return defaultSexValue;
	}
	public void setDefaultSexValue(String defaultSexValue){
		this.defaultSexValue = defaultSexValue;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
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

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setProductCount(String productCount){
		this.productCount = productCount;
	}

	public String getSubtotal(){
		return subtotal;
	}

	public void setSubtotal(String subtotal){
		this.subtotal = subtotal;
	}

	public List<MCategoryDTO> getMCategoryDTOList(){
		return mCategoryDTOList;
	}

	public void setMCategoryDTOList(List<MCategoryDTO> mCategoryDTOList){
		this.mCategoryDTOList = mCategoryDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}


}
