package com.internousdev.testsampleweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.testsampleweb.dto.UserInfoDTO;
import com.internousdev.testsampleweb.util.DBConnector;

public class UserInfoDAO {

	//ユーザー情報登録のためのメソッド
	public int createUser(String familyName, String firstName, String familyNameKana,
			String firstNameKana, String sex, String email, String loginId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, status, logined, regist_date, update_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?, now(), now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, sex);
			ps.setString(8, email);
			ps.setInt(9, 0);
			ps.setInt(10, 1);
			//注意!setString(sex)

			count = ps.executeUpdate();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return count;
	}


	//ユーザー情報の存在を確認するメソッド(ログインID、パスワードを元に)
	public boolean isExistsUserInfo(String loginId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;

		String sql = "SELECT COUNT(*) AS count FROM user_info where user_id=? AND password=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count") > 0){
					result = true;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return result;
	}


	//ユーザー情報確認用のメソッド(ログインIDを元に)
	public boolean isExistsUserInfo(String loginId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;

		String sql = "SELECT COUNT(*) AS count FROM user_info where user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt("count") > 0){
					result = true;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return result;
	}


	//ユーザー情報取得のためのメソッド(ログインID、パスワードを基にする)、ログイン用
	public UserInfoDTO getUserInfo(String loginId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info WHERE user_id=? AND password=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return userInfoDTO;

	}


	public UserInfoDTO getUserInfo(String loginId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info WHERE user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return userInfoDTO;
	}


	//パスワード更新用のメソッド
	public int resetPassword(String loginId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "UPDATE user_info SET password WHERE password=? AND user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, loginId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return result;
	}

	//ログイン用メソッド(loginedの値を1にする)
	public int login(String loginId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "UPDATE user_info SET logined=1 WHERE user_id=? AND password=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return result;
	}


	//ログアウト用のメソッド(loginedの値を0に戻す)
	public int logout(String loginId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "UPDATE user_info SET logined=0 WHERE user_id=?";
		//loginedを0にする

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			result = ps.executeUpdate();

		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return result;
	}


	public String concealPassword(String password){
		int beginIndex = 0;
		int endIndex = 1;
		if(password.length() > 1){
			endIndex = 2;
		}
		StringBuilder stringBuilder = new StringBuilder("****************");
		/**
		 * StringBuilderクラスを呼び出すことで一度宣言した
		 * String型の文字列の変換、連結、挿入などが出来る
		 * 引数として「******************」を渡しておく
		 */

		String concealPassword = stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex, endIndex)).toString();
		/**
		 * StringBuilderクラスのreplaceメソッドを利用することで文字列の置換が可能
		 * replace(int a, int b, String s)で
		 * a番目～b番目の文字をsに置き換えることが出来る
		 *
		 * .substringメソッドは呼び出したメソッドの一部を取得するためのメソッド
		 * .substring(int beginIndex, int endIndex)で何文字目から何文字目までという指定が可能
		 * 今回は頭の2文字目ぐらいまでをパスワードのものと置き換える
		 * 頭の2文字ぐらいを表示して後は**に置き換えることが出来る
		 */
		return concealPassword;
	}

}
