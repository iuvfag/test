package team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.glanq.dto.UserInfoDTO;
import com.internousdev.glanq.util.DBConnector;

public class UserInfoDAO {

	//ユーザー登録用メソッド
	public int createUser(String loginId, String password, String familyName, String firstName, String familyNameKana, String firstNameKana, String sex, String email){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, status, logined, regist_date, update_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

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


	//ユーザーがいるかどうかの判定用メソッド
	public boolean isExistUser(String userId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;

		String sql = "SELECT COUNT(*) AS count FROM user_info WHERE user_id = ? ANF password = ? ";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if(rs.getInt("count") > 0){
				result = true;
			}
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


	//ユーザー情報取得メソッド(ユーザーID、パスワード)
	public UserInfoDTO getUserInfo(String userId, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info WHERE user_id = ? AND password = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setStatus(rs.getInt("status"));
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


	//ユーザー情報取得用メソッド(ユーザーID)
	public UserInfoDTO getUserInfo(String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM user_info WHERE user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setStatus(rs.getInt("status"));
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


	//パスワード再設定用メソッド
	public int resetPassword(String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "UPDATE user_info SET password WHERE user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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


	//ログイン用メソッド
	public int login(String userId, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "UPDATE user_info SET logined = 1 WHERE user_id = ? AND password = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
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


	//ログアウト用メソッド
	public int logout(String userId, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "UPDATE user_info SET logined = 0 WHERE user_id = ? AND password = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
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


	//パスワード隠す用のメソッド
	public String concealPassword(String password){
		int beginIndex = 0;
		int endIndex = 1;
		if(password.length() > 1){
			endIndex = 2;
		}

		StringBuilder stringBuider = new StringBuilder("****************");

		String concealPassword = (stringBuider.replace(beginIndex, endIndex, password.substring(beginIndex, endIndex)).toString());
		return concealPassword;
	}

}
