package com.internousdev.webproj4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dto.HelloStrutsDTO;
import com.internousdev.webproj4.util.DBConnector;

public class HelloStrutsDAO {

	List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();
	/**
	 * HelloStrutsDTO型のList型変数を宣言する
	 * 変数名は小文字で始める
	 */

	public List<HelloStrutsDTO> select(){
		/**
		 *今回、結果はList型変数（配列）として戻すため
		 * Listを戻り値として宣言する
		 */


		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from users";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				HelloStrutsDTO dto = new HelloStrutsDTO();
				dto.setUserId(rs.getInt("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				dto.setResult("MySQLと接続できます。");
				helloStrutsDTOList.add(dto);
				/**
				 * 取得した結果をそれぞれListに代入
				 * 結果は配列の型で保存される
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
		return helloStrutsDTOList;
		//結果が代入されたListを戻す


	}



}
