package com.internousdev.webproj.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport {
	//execute()を実行するためにActionSupportを継承する

	public String execute(){
		return SUCCESS;
		//executeメソッドの結果をsuccessで返す
	}

}
