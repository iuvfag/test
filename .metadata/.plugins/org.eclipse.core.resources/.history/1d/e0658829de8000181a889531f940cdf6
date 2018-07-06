package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{
	/**
	 * 変数はbuyItem.jspから送られてくる値と連動させる
	 */

	private int stock;
	private String pay;
	public Map<String, Object> session;
	private String result;

	public String execute(){

		result = SUCCESS;

		session.put("stock", stock);//--1
		int intStock = Integer.parseInt(session.get("stock").toString());//--2
		/**
		 * JSPファイル内で選択された値(1)を取得して
		 * intStockに代入(2)
		 */
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		/**
		 * LoginActionで取得した
		 * 商品価格(session.buyItem_price)を取り出す
		 */

		session.put("buyItem_price", intStock * intPrice);
		/**
		 * 取り出した価格に
		 * 在庫×価格をして
		 * その結果を代入しなおす
		 */

		String payment;

		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay", payment);
		}else{
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	public int getStock(){
		return stock;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay = pay;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
