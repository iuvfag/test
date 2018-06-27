package com.internousdev.webproj2.action;

import com.internousdev.webproj2.dao.TestDAO;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private String username;
	private String password;

	public String execute(){

	String ret = ERROR;
	TestDAO dao = new TestDAO();
	int count = dao.insert(username, password);
	//TestDAOクラスをインスタンス化し、insertメソッドを利用
	if(count > 0){
		ret = SUCCESS;
	}
	/*
	 * 戻ってきた値が1以上（一件でもあれば）なら
	 * struts.xmlにexecute結果を「success」で返す
	 */
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

}
