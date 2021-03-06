package com.internousdev.ecsitetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsitetest.dto.LoginDTO;
import com.internousdev.ecsitetest.util.DBConnector;

public class LoginDAO {

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO dto = new LoginDTO();

		String sql = "SELECT * FROM login_user_transaction WHERE login_id=? AND login_pass=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));

				if(!(rs.getString("login_id").equals(null))){
					dto.setLoginFlg(true);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return dto;
	}

}
