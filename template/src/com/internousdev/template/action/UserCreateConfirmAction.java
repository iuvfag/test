package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;


	public String execute(){

		String result = SUCCESS;

		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))){
			/**
			 * 上記のif文で判定しているものは
			 * ユーザーID、パスワード、ユーザーネームそれぞれに
			 * 空欄の場所がないか（それぞれの変数が空欄に
			 * 一致していなければ）ということ
			 * もし空欄でなければその結果をMapに格納
			 */

			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
			/**
			 * 確認画面で表示したい値を
			 * セッションに格納する
			 */
		}else{
			setErrorMessage("未入力の項目があります。");
			/**
			 * 空欄があれば
			 * 未入力の項目があると
			 * このクラスのセッターを利用して
			 * エラーメッセージをセットする
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

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	/**
	 * @Overrideのことをアノテーションという
	 * 親クラスのメソッドをオーバーライドする宣言をする際につける
	 * もし親クラスに同名のメソッドがない場合にコンパイラが
	 * エラーメッセージを出してくれる
	 * なくても問題ないがつけておいた方がいいかも
	 */
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}


}
