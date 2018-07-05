package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String, Object> session;

	public String execute(){
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		/**
		 * LoginDAOクラスの「getLoginUserInfo」メソッド（ログイン用メソッド）を
		 * 呼び出し、結果をLoginDTOクラスに格納する
		 */

		session.put("loginUser", loginDTO);
		/**
		 * ログインDTOクラスの情報（ユーザー情報）をMap型変数に代入
		 */

		/*
		 * 入力値からユーザー情報の検索を行う
		 * ログイン認証が成功した場合、次の場面で
		 * 「商品情報」が必要なため商品情報を取得する
		 */

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			/**
			 * 先ほどMap型変数に代入したものの中から
			 * loginFlg（情報の取得が出来たかどうかを代入した変数）
			 * を呼び出す
			 * loginFlgはboolean型の変数なのでこのif文では
			 * loginFlgがtrueならばという意味になる
			 * もし、LoginDAOクラスでログインに失敗している場合は
			 * loginFlgはfalseのままなのでこの条件文には合致しなくなる
			 */

			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			/**
			 * BuyDAOクラスの「getBuyItemInfo」メソッド
			 * （データベースから商品名や価格などの情報を取得してくるメソッド）
			 * を呼び出し、その結果をBuyItemDTOに格納する
			 */

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItemName", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			/**
			 * BuyItemDTOクラス、LoginDTOクラスのgetterを利用して
			 * MapにユーザーID、
			 * 商品ID、商品名、商品価格をそれぞれ代入する
			 * これで、JSPファイルでKeyを指定すれば呼び出せるようになる
			 */

			return result;
			/**
			 * 結果を戻す
			 * この結果しだいでstruts.xmlの呼び出すファイルが変わる
			 */

		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
