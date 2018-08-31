package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.CartInfoDAO;
import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dto.CartInfoDTO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;


public class CartAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mcDTOList = new ArrayList<MCategoryDTO>();
	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			return result;
		}

		//エラーメッセージの重複表示対策
		String userId = null;
		CartInfoDAO ciDAO = new CartInfoDAO();
		List<CartInfoDTO> CartInfoDtoList = new ArrayList<CartInfoDTO>();

		/*
		 *本Id、仮Idそれぞれ存在する値に合わせてsessionから取得して、userIdに代入する
		 */
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}

		//userIdに紐づいた値を取得し、iteratorで取り出す
		CartInfoDtoList = ciDAO.getCartInfoDtoList(userId);
		Iterator<CartInfoDTO> iterator = CartInfoDtoList.iterator();

		//値がなくなるまで回して、次の行がなくなった時にnullを代入
		if(!(iterator.hasNext())){
			CartInfoDtoList = null;
		}

		session.put("cartInfoDtoList", CartInfoDtoList);

		/*
		 * sessionから合計金額を取得
		 * データ型をObject→String→intの順に変換し、totalPriceに代入
		 */
		int totalPrice = Integer.parseInt(String.valueOf(ciDAO.getTotalPrice(userId)));

		session.put("totalPrice", totalPrice);
		result = SUCCESS;


		if(!(session.containsKey("mCategoryList"))){
			MCategoryDAO mCategoryDao =new MCategoryDAO();
			mcDTOList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mcDTOList);
		}
		try{
			session.remove("checkListErrorMessageList");
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
