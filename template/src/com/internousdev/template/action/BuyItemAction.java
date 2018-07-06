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
		 * JSPファイル内で選択された値を取得してsessionに代入(1)
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
		/**
		 * buyItem.jspファイルで選択された支払い方法を宣言（受け取る）
		 */

		if(pay.equals("1")){
			payment = "現金払い";
			session.put("pay", payment);
		}else{
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		/**
		 * JSPファイルで指定された場合わけに応じて
		 * 支払い方法をsessionに格納
		 */
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
