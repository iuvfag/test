package com.internousdev.testsampleweb.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String loginId;
	private String password;
	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.resetPassword(String.valueOf(session.get("loginId")), String.valueOf(session.get("newPassword")));
		/**
		 * UserInfoDAOクラスのresetPasswordメソッドを呼び出し
		 * int型の戻り値を受け取る
		 */

		if(count > 0){
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;
		/**
		 * 戻り値がゼロ以上
		 * （更新されたpasswordが1件以上）
		 * ならSUCCESSを、そうでないならERRORを返す
		 */
	}


	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
