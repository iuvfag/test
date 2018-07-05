package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;

public class UserCreateCompleteDAO {

	private DateUtil dateUtil = new DateUtil();

	private String sql = "insert into login_user_transaction(login_id, login_pass, user_name,insert_date) values(?,?,?,?)";


	public void createUser(String loginUserId, String loginUserPassword, String userName) throws SQLException{
		/**
		 * throwsはメソッド内で例外が発生した場合、自身のメソッド内でcatchするのではなく
		 * 呼ばれる側に例外を投げる処理
		 */

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			connection.close();
		}

	}

}
