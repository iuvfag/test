package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.MCategoryDAO;
import com.internousdev.testsampleweb.dto.MCategoryDTO;
import com.internousdev.testsampleweb.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String, Object> session;

	public String execute(){

		// 3つの場合に分けて処理を分岐させる

		// ①ログインIDも一時的なログインIDも持っていない場合
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRandomValue());
			/**
			 * CommonUtilityクラスからgetRandomValueメソッドを呼び出す
			 * ランダムな数字を生成した後、それを
			 * session内のtempUserId(一時ログインID)に代入する
			 */
		}

		// ②ログイン状態である場合
		if(!session.containsKey("logined")){
			session.put("logined", 0);
			/**
			 * session内にloginedのkeyで値が格納されている場合
			 * (ログイン状態である場合)sessionにloginedのキーで
			 * 0を格納する
			 */
		}

		/**
		 *  ③商品カテゴリーをまだ取得していない場合
		 *  (ログインしていない場合はこうなる)
		 */
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
			/**
			 * MCategoryDAOクラスをインスタンス化し、
			 * getMCategoryメソッドを呼び出す
			 * session内にそのリストを格納する
			 */

		}
		return SUCCESS;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public List<MCategoryDTO> getCategoryDTOList(){
		return mCategoryDTOList;
	}

	public void setCategoryDTOList(List<MCategoryDTO> mCategoryDTOList){
		this.mCategoryDTOList = mCategoryDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
