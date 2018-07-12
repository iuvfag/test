package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public String execute(){
		String result = "login";

		if(session.containsKey("id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			/**
			 * 	ログイン状態かどうかのチェック
			 * containskey()は、
			 * 「()内のキーに対して値が存在する場合はtrueを返す」というもの
			 * 今回はsessionにidが登録されているかどうかをチェックする
			 *
			 */

			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			result = SUCCESS;
			/**
			 * ログイン済み判定を行う
			 * 一度ログインしている場合はログイン認証画面に遷移させることなく、
			 * 商品画面に遷移させる
			 */
		}
		return result;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public Map<String, Object> getSession(){
		return session;
	}

}
