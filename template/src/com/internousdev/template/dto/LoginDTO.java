package com.internousdev.template.dto;

public class LoginDTO {
	/**
	 * ログインの際に必要な情報を格納するためのクラス
	 */

	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
	/**
	 * ログインID、パスワード、ユーザー名とは別に
	 * boolean型の変数loginFlgを宣言する
	 * この変数はログインできたかどうかを判定する
	 * デフォルトではfalseにしておく
	 * @return
	 */

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
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

	public boolean getLoginFlg(){
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}

}
