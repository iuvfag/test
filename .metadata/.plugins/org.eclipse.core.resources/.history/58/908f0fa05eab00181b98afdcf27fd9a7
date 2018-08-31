package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		// "session"内にログインIDと仮ログインIDが無いことを確認
		if (!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))) {
			CommonUtility commonUtility = new CommonUtility();

			// 仮ログインIDを16桁の数字でランダム生成し、"session"に格納
			session.put("tempUserId", commonUtility.getRamdomValue());
		}

		// "session"内にログイン済みでは無いことを確認
		if (!session.containsKey("logined")) {

			// "session logined"に０を格納
			session.put("logined", 0);
		}

		// "session"内にmCategoryListが無いことを確認
		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();

			// "session mCategoryDtoList"に"mCategoryDtoList"を格納
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		// "execute"に値を返す

		result = SUCCESS;
		return result;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
