package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.LoginDAO;
import com.internousdev.webproj4.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private String username;
	private String password;
	private List<LoginDTO> LoginDTOList = new ArrayList<LoginDTO>();
	// LoginDTO型のListを宣言(先頭を大文字にして区別する)

	public String execute(){
		String ret = ERROR;
		System.out.println(username);
		System.out.println(password);
		LoginDAO dao = new LoginDAO();

		LoginDTOList = dao.select(username, password);
		/**
		 * LoginDAOクラスのselectメソッドに引数を渡して実行
		 * 結果をLoginDTO型のListに代入
		 * このListはLoginDTO型の変数であるため、
		 * DTOクラスのsetterやgetterも使える
		 */

		if(this.username.equals(LoginDTOList.get(0).getUsername()) &&
				this.password.equals(LoginDTOList.get(0).getPassword())){
			/** 入力されたユーザー名とパスワードがデータベースのものと
			 * 一致するかを調べる。
			 * 比べるのはここで入力された（JSPファイルから渡された）ものと
			 * LoginDTOListに代入されたもの
			 * もし、入力された情報がデータベースと一致しない場合は
			 * LoginDAO内でloginDTOListに「該当なし」と代入されているため
			 * ここのif文では条件に当てはまらなくなる。
			 */

			ret = SUCCESS;
		} else{
			ret = ERROR;
		}
		return ret;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public List<LoginDTO> getLoginDTOList(){
		return LoginDTOList;
	}

	public void setLoginDTOList(List<LoginDTO> loginDTOList){
		LoginDTOList = loginDTOList;
	}


}
