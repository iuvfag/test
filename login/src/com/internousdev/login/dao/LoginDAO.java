package com.internousdev.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

//Actionから送られた来た情報を使ってDBに問い合わせる
//取得した情報をそのままDTOクラスに格納する
public class LoginDAO {
	public LoginDTO select(String name, String password)throws SQLException{
		/* メソッド名は処理内容をわかりやすくするため「select」にする
		* 今回の戻り値はLoginDTO型の変数であるため戻り値もLoginDTOで宣言
		*/
		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from user where user_name = ? and password = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			//セキュリティ対策を考慮してJavaではPreparedStatementを利用する
			ps.setString(1, name);
			ps.setString(2, password);
			//SQL文の？パラメータに対応した値を挿入できる
			ResultSet rs = ps.executeQuery();
			//SQL文の実行
			/* 今回はフロントで入力された情報（「ユーザーID」、「password」）を元に、
			* 該当するデータがあるかを調べる
			*/
			if(rs.next()){
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				//select文で取得した情報をDTOクラスのセッターに格納
			}

		}catch(SQLException e ){
			e.printStackTrace();
			//処理中にSQL関連のエラーが発生した際に実行する処理
		}finally{
			con.close();
			//DB接続を切断する。必ず実行する処理
		}

		return dto;
		//取得した情報を戻す。Actionクラスへ
	}

}
