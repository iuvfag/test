package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() throws SQLException{

		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
		buyItemCompleteDAO.buyItemInfo(session.get("id").toString(), session.get("login_user_id").toString(), session.get("buyItem_price").toString(), session.get("stock").toString(), session.get("pay").toString());
		/**
		 * buyItemConfirm.jspから情報を受け取る
		 * LoginActionで取得した商品情報、JSPファイル(buyItem.jsp)で選択された在庫数、支払い方法
		 * などをsessionから取り出してbuyItemInfoメソッドに引数として渡す
		 * 価格はBuyItemActionで計算されたものを使用する
		 */

		String result = SUCCESS;
		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
