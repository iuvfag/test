package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword){
		/**
		 * メソッド名は処理内容をわかりやすくするため
		 * 「getLoginUserInfo」とする
		 */

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		LoginDTO loginDTO = new LoginDTO();
		/**
		 * LoginDTOクラスをインスタンス化
		 * これでDTOクラスのgetterとsetterを使用することが出来る
		 */

		String sql = "select * from login_user_transaction where login_id=? and login_pass=?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);
			/**
			 * セキュリティを考慮してPreparedStatementを使用する
			 * SQL文の「？」パラメータに指定した値を挿入する
			 */

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()){
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				/**
				 * データベースから取得した値をDTOクラスのsetterを
				 * 利用して格納
				 */

				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO.setLoginFlg(true);
					/**
					 * この条件式は
					 * 「取得したlogin_idがnullでなかったら」という意味
					 * うまく取得できていれば値が代入されているはずであり、
					 * DTOクラスのloginFlgにはtrueを代入する
					 * そうでなければfalseのまま
					 */
				}
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
		return loginDTO;
	}

}
