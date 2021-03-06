package com.internousdev.login.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/*
 * 画面から送られてきたリクエストを取得
 * 内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPに値を返す
 */
public class LoginAction extends ActionSupport implements SessionAware{
	/* ActionSupportを継承し、SessionAwareを実装しておく
	 * ActionSupportはメッセージの操作などさまざまな便利機能を持つ
	 * 今回はexecuteの実行のため必要
	 * struts2のSessionAwareを実装することでサーバーに情報を保持することができる
	 * 実装するとマップでセッションオブジェクトにアクセスできる
	 *
	 */
	private String name;
	private String password;
	private Map<String,Object> session;


public String execute()throws SQLException{
	String ret = ERROR;
	//デフォルトはerrorに設定（大文字で）
	LoginDAO dao = new LoginDAO();
	LoginDTO dto = new LoginDTO();
	//まずはインスタンス化する

	dto = dao.select(name,password);
	/* まず、入力された情報がデータベースに一致するかを調べる
	* 入力されたログインIDとパスワードをDAOクラスに渡す
	* DAOクラスへ
	*/
	if(name.equals(dto.getName())){
		if(password.equals(dto.getPassword())){
			ret = SUCCESS;
	/** 「DAOクラス」を呼び出してDBに接続する
	 *  今回はユーザーが入力した「ログインID」と「パスワード」に
	 *  一致する情報がないか検索する
	 *  一致した場合はString型変数retにsuccessを代入する
	 */
		}
	}

	session.put("name",dto.getName());
	/*
	 * keyと値を（今回は、key=「name」、値=「DAOクラスにおいて取得され、DTOクラスに保存されたname」）を関連付ける
	 * 今回は入力された情報を保持してページ移動ができるようになる
	 * ただし、利用にはSessionAwareの実装が必要
	 */
	return ret;
	//「success」か「error」を代入したretを戻す
}

public String getName(){
	return name;
}

public void setName(String name){
	this.name = name;
}

public String getPassword(){
	return password;
}

public void setPassword(String password){
	this.password = password;
}

public Map<String,Object> getSession(){
	return session;
}

public void setSession(Map<String,Object> session){
	this.session = session;
}

}
