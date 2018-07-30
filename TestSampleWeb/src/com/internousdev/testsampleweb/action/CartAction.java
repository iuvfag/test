package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.CartInfoDAO;
import com.internousdev.testsampleweb.dao.MCategoryDAO;
import com.internousdev.testsampleweb.dto.CartInfoDTO;
import com.internousdev.testsampleweb.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;
		String userId = null;
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}else if(session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
		}
		/**
		 * ログイン状態かどうかで処理を分岐させる
		 * sessionにユーザーIDがあればそれを、
		 * ユーザーIDがなく暫定IDがあればそれを
		 * userIdに代入する
		 *
		 * これでログイン状態でもログイン状態でなくとも
		 * 代入されたログインIDでカート情報を取り出すことが出来る
		 */

		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

		if(!(iterator.hasNext())){
			cartInfoDTOList = null;
		}
		session.put("cartInfoDTOList", cartInfoDTOList);
		/**
		 * カート情報を取得
		 * 要素があるかを確認し、
		 * sessionに格納する
		 */

		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(userId)));
		session.put("totalprice", totalPrice);
		//合計金額を算出し、sessionに格納

		result = SUCCESS;

		if(!(session.containsKey("mCategoryList"))){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		/**
		 * mCategoryListというキーがsessionに格納されていれば
		 * mCategoryDTOListを取得し、sessionに格納
		 */
		return result;
	}


	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getKeywrods(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
