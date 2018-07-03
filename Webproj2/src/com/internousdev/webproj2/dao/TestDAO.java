package com.internousdev.webproj2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.webproj2.util.DBConnector;

public class TestDAO {

	public int insert(String username, String password){
		int ret = 0;
		//戻す変数iを初期化
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into users(user_name,password) values(?,?)";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			int i = ps.executeUpdate();
			if(i > 0){
				System.out.println(i + "件登録されました");
				ret = i;
				/**
				 * 登録されたものがあれば、
				 * その件数を返す
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
