package com.internousdev.login.dto;

/*
 * DTOクラスではDAOがDBから取得した値をActionに戻すとき、
 * DB値を格納するのに利用される
 * DTOクラス内では、テーブルカラム値に
 * 紐づいたフィールド変数とGetter、Setterのみが定義される
 */
public class LoginDTO {
	private int id;
	private String name;
	private String password;
	//テーブルカラムに対応した変数を宣言


	//フィールド変数に対応するGetter、Setterを定義する
	public int getId(){
		return id;
	}

	public void setInt(int id){
		this.id = id;
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



}
