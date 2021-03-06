package com.internousdev.webproj2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class LoginDAO {

	public String username;
	public String password;

	public boolean select(String username, String password){
		boolean ret = false;
		/**
		 * boolean型の変数なので、
		 * 代入される値はtrueまたはfalse
		 * 初期状態ではfalseとしておく
		 */
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from where user_name=? and password=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				this.username = rs.getString("user_name");
				this.password = rs.getString("password");
				/*
				 * 取得したユーザー名とパスワードを
				 * このクラスの変数「username」「password」に代入
				 * （このプロジェクトにはDTOが無いため）
				 */
				ret = true;
				/**
				 * 接続が出来た場合はboolean型の変数retに
				 * trueを代入しなおす
				 */
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return ret;

	}

}
