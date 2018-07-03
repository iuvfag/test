package com.internousdev.webproj3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.webproj3.dto.HelloStrutsDTO;
import com.internousdev.webproj3.util.DBConnector;

public class HelloStrutsDAO {

	public HelloStrutsDTO select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		HelloStrutsDTO dto = new HelloStrutsDTO();
		/**
		 * HelloStrutsDTOクラスをインスタンス化しておく
		 * 後で接続結果をDTOクラスのresultに代入し、戻すため
		 */

		String sql = "select * from users";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setResult("MySQLと接続できます");
			}else{
				dto.setResult("MySQLと接続できません");
			}
			/**
			 * データベースに接続できるかを調べる
			 * HelloStrutsDTOクラスのsetterを利用して
			 * DTOにある変数resultに今回の結果を代入する
			 */
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return dto;
		//結果をDTOに戻す
	}

}
