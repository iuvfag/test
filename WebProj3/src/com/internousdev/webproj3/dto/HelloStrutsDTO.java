package com.internousdev.webproj3.dto;

public class HelloStrutsDTO {
	private String result;

	public String getResult(){
		return result;
	}

	public void setResult(String result){
		this.result = result;
	}
	/**
	 * このクラスではDAOでのMySQL接続の結果をresultに格納する
	 * setterとgetterで結果の取り出し、変更ができるようにしておく
	 */

}
