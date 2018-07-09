package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {

	public MyPageDTO getMyPageUserInfo(String item_transaction_id, String user_master_id) throws SQLException{
		/**
		 * ユーザー情報を集めるためのメソッド
		 */

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		MyPageDTO myPageDTO = new MyPageDTO();

		String sql = "select iit.item_name, ubit.total_price, ubit.total_count, ubit.pay from user_buy_item_transaction "
				+ "ubit left join item_info_transaction iit on ubit.item_transaction_id = iit.id where ubit.item_transaction_id= ?"
				+ "and ubit.user_master_id = ? order by ubit.insert_date desc";
		/**
		 * 商品情報から商品名を、
		 * ユーザーが購入する商品情報から合計金額と購入数、支払い方法を取得し、
		 * ユーザー購入商品情報をベースにテーブル結合を行う。
		 * その際に商品情報の商品IDとユーザー購入情報の商品IDを一致させる。
		 * 結合の際に取得する情報は商品IDとユーザーIDを着順にする。
		 * また、購入日順に並びかえる。
		 */

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			/**
			 * 商品ID、ユーザーIDを元にデータベースへの接続を試みる
			 */

			if(resultSet.next()){
				myPageDTO.setItemName(resultSet.getString("item_name"));
				myPageDTO.setTotalPrice(resultSet.getString("total_price"));
				myPageDTO.setTotalCount(resultSet.getString("total_count"));
				myPageDTO.setPayment(resultSet.getString("pay"));
				/**
				 * 商品名、価格、合計、料金などの情報を
				 * myPageDTOに格納する
				 */
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return myPageDTO;
	}


	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id)throws SQLException{
		/**
		 * ユーザーが商品情報を削除する際に呼び出すメソッド
		 */

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "delete from user_buy_item_transaction where item_transaction_id=? and user_master_id=?";

		PreparedStatement preparedStatement;
		int result = 0;

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);
			/**
			 * 指定された商品IDとユーザーIDを元に
			 * データーベースへの接続を試みる
			 * 該当するデータの削除を実行
			 */

			result = preparedStatement.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

}
