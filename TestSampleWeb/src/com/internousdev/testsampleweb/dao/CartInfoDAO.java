package com.internousdev.testsampleweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.testsampleweb.dto.CartInfoDTO;
import com.internousdev.testsampleweb.util.DBConnector;

public class CartInfoDAO {

	//カート情報取得のためのメソッド(ログインIDを元に)
	public List<CartInfoDTO> getCartInfoDTOList(String loginId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

		String sql = "SELECT ci.id as id, "
				+ "ci.user_id as user_id, "
				+ "ci.temp_user_id as temp_user_id, "
				+ "ci. product_id as product_id, "
				+ "SUM(ci.product_count) as product_count,"
				+ "pi.price as price, "
				+ "pi.regist_date as regist_date, "
				+ "pi.update_date as update_date, "
				+ "pi.product_name as product_name, "
				+ "pi.product_name_kana as product_name_kana, "
				+ "pi.product_description as product_description, "
				+ "pi.category_id as category_id, "
				+ "pi.image_file_path as image_file_path, "
				+ "pi.image_file_name as image_file_name, "
				+ "pi.release_date as release_date, "
				+ "pi.release_company as release_company, "
				+ "pi.status as status, "
				+ "(SUM(ci.product_count) * pi.price) "
				+ "as subtotal "
				+ "FROM cart_info as ci "
				+ "LEFT JOIN product_info as pi "
				+ "ON ci.product_id = pi.product_id "
				+ "WHERE ci.user_id = ? group by product_id";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("cartinfodao-getcartinfodtolist:" + loginId);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO cartInfoDTO = new CartInfoDTO();
				cartInfoDTO.setId(rs.getInt("id"));
				cartInfoDTO.setUserId(rs.getString("user_id"));
				cartInfoDTO.setTempUserId(rs.getString("temp_user_id"));
				cartInfoDTO.setProductId(rs.getInt("product_id"));
				cartInfoDTO.setProductCount(rs.getInt("product_count"));
				cartInfoDTO.setPrice(rs.getInt("price"));
				cartInfoDTO.setRegistDate(rs.getDate("regist_date"));
				cartInfoDTO.setUpdateDate(rs.getDate("update_date"));
				cartInfoDTO.setProductName(rs.getString("product_name"));
				cartInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				cartInfoDTO.setProductDescription(rs.getString("product_description"));
				cartInfoDTO.setCategoryId(rs.getInt("category_id"));
				cartInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				cartInfoDTO.setImageFileName(rs.getString("image_file_name"));
				cartInfoDTO.setReleaseDate(rs.getDate("release_date"));
				cartInfoDTO.setReleaseCompany(rs.getString("release_company"));
				cartInfoDTO.setStatus(rs.getString("status"));
				cartInfoDTO.setSubtotal(rs.getInt("subtotal"));

				cartInfoDTOList.add(cartInfoDTO);
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return cartInfoDTOList;

	}


	//商品の合計金額を算出しDBにその結果を格納するメソッド(ユーザーIDを元に)
	public int getTotalPrice(String userId){

		int totalPrice = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT SUM(product_count * price) AS total_price FROM cart_info WHERE user_id = ? GROUP BY user_id";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				totalPrice = rs.getInt("total_price");
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return totalPrice;
	}


	//カートに商品(個数、価格など)を登録するためのメソッド
	public int regist(String userId, String tempUserId, int productId, String productCount, int price){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "INSERT INTO cart_info(user_id, temp_user_id, product_id, product_count, price, regist_date)"
				+ "VALUES(?,?,?,?,?,now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, tempUserId);
			ps.setInt(3, productId);
			ps.setString(4, productCount);
			ps.setInt(5, price);

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

	//カート情報削除のためのメソッド(IDを元に)
	public int delete(String id){


		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "DELETE FROM cart_info WHERE id =?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	//カート情報削除のためのメソッド(ユーザーIDを元に)
	public int deleteAll(String userId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		String sql = "DELETE FROM cart_info WHERE user_id=?";

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

	public boolean isExistsCartInfo(){
		return false;
	}

	/**
	 * カート情報をユーザーIDに紐付ける
	 * DBのカート情報の暫定ユーザーIDをNullにし、
	 * ユーザーIDを登録してあるものに置き換える
	 */
	public int linkToLoginId(String tempUserId, String loginId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;
		String sql = "UPDATE cart_info SET user_id=?, temp_user_id = null WHERE temp_user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, tempUserId);

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

}
