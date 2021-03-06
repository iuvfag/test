package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;

	public String execute()throws SQLException{

		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
				session.get("loginPassword").toString(),
				session.get("userName").toString());
		/**
		 * DAOを経由して入力された内容をDBに登録する
		 * UserCreateConfirmActionクラスで格納された情報を
		 * userCreateConfirm.jspを通じて
		 * 取り出し、文字列に変換してDAOクラスのcreateUserメソッドに引数
		 * を渡して実行する
		 *
		 * toString()は、数字を文字列に変換するもの
		 * 数字を入力した場合も文字列に変換して返す
		 * getしてきたものを返す
		 */

		String result = SUCCESS;
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

}
