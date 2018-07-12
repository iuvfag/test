package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){
		session.clear();
		/**
		 * Map内のコンテナに保持されている情報を削除するメソッド
		 * これまでsessionに保持してきた情報を削除するため、
		 * ログイン情報も削除される
		 * ログアウト完了
		 */
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public Map<String, Object> getSession(){
		return session;
	}

}
