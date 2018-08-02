package team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInfoDAO {

	//ユーザー登録用メソッド
	public int createUser(String loginId, String password, String familyName, String firstName, String familyNameKana, String firstNameKana, int sex, String email){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, regist_date, update_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setInt(7, sex);
			ps.setString(8, email);
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


	public boolean isExistUser(String userId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean loginFlg = false;

		String sql = "SELECT COUNT(*) sa count FROM user_info WHERE user_id = ? ANF password = ? ";
	}
}
