package com.internousdev.glanq.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.glanq.dto.CartInfoDTO;
import com.internousdev.glanq.util.DBConnector;


public class CartInfoDAO {

	/*
	 * 設計書に記載されている内容は以下
	 * 1.DBからカートの内容を取得
	 * 2.カート内の情報をテーブルに追加
	 * 3.カート内の合計金額を表示
	 * 4.カート中身を削除(項目毎)
	 * 5.カートの中身を削除(全項目)
	 * 6.カートの中身が存在するかの確認
	 * 7.仮のIdが発行されているユーザーを決済画面で本Idのユーザーと置き換える
	 */

	/*1.カートの内容を取得する*/
	public List<CartInfoDTO> getCartInfoDtoList(String loginId){
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		List<CartInfoDTO> CartInfoDtoList = new ArrayList<CartInfoDTO>();

		/*
		 * stelec文でasを使用してカラムの名前を変更
		 * 抜き出す要素についてはCartInfoDTOを参照
		 * cart_infoを基点として、product_infoを結合
		 * cart_infoとproduct_infoのproduct_count(購入個数)とprice(値段)を
		 * 掛け合わせたものをsubtotal(合計金額)として新しいカラムを作成
		 * 両テーブルに共通するproduct_idを単純結合
		 * その中でuser_idと一致する項目を取得
		 */
		String sql = "select"
				+ " ci.id,"
				+ " ci.user_id,"
				+ " ci.temp_user_id,"
				+ " ci.product_id,"
				+ " sum(ci.product_count) as product_count,"/*購入個数の合計値*/
				+ " pi.price,"
				+ " pi.regist_date,"
				+ " pi.update_date,"
				+ " pi.product_name,"
				+ " pi.product_name_kana,"
				+ " pi.product_description,"
				+ " pi.category_id,"
				+ " pi.image_file_path,"
				+ " pi.image_file_name,"
				+ " pi.release_date,"
				+ " pi.release_company,"
				+ " pi.status,"
				+ " (sum(ci.product_count) * pi.price) as subtotal"/*合計金額*/
				+ " FROM cart_info as ci"
				+ " LEFT JOIN product_info as pi"
				+ " ON ci.product_id = pi.product_id"
				+ " WHERE ci.user_id = ?"
				+ " group by product_id";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			//コンソールでユーザーIDを確認
			System.out.println("cartinfodao-getcartinfodtolist:" + loginId);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO ciDTO = new CartInfoDTO();
				ciDTO.setId(rs.getInt("id"));
				ciDTO.setUserId(rs.getString("user_id"));
				ciDTO.setTempUserId(rs.getString("temp_user_id"));
				ciDTO.setProductId(rs.getInt("product_id"));
				ciDTO.setProductCount(rs.getInt("product_count"));
				ciDTO.setPrice(rs.getInt("price"));
				ciDTO.setRegistDate(rs.getDate("regist_date"));
				ciDTO.setUpdateDate(rs.getDate("update_date"));
				ciDTO.setProductName(rs.getString("product_name"));
				ciDTO.setProductNameKana(rs.getString("product_name_kana"));
				ciDTO.setProductDescription(rs.getString("product_description"));
				ciDTO.setCategoryId(rs.getInt("category_id"));
				ciDTO.setImageFilePath(rs.getString("image_file_path"));
				ciDTO.setImageFileName(rs.getString("image_file_name"));
				ciDTO.setReleaseDate(rs.getDate("release_date"));
				ciDTO.setReleaseCompany(rs.getString("release_company"));
				ciDTO.setStatus(rs.getString("status"));
				ciDTO.setSubtotal(rs.getInt("subtotal"));
				CartInfoDtoList.add(ciDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return CartInfoDtoList;
	}

	/*2.カート内の情報をテーブルに追加する*/
	public int regist(String userId,String tempUserId, int productId,String productCount,int price){
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		int count = 0;

		/*
		 * カートに追加する情報は以下
		 *【user_id(ユーザーID)、temp_user_id(仮ユーザーID)】が
		 *【product_id(商品ID=商品の情報とひもづくので名前がわり)】を
		 *【product_count(購入個数)】と【price(値段)】と供に
		 *【regist_date(購入日)】と一緒に登録される
		 */
		String sql = "INSERT INTO cart_info(user_id, temp_user_id, product_id, product_count, price, regist_date)"
				+ " values (?,?,?,?,?,now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, tempUserId);
			ps.setInt(3, productId);
			ps.setString(4, productCount);
			ps.setInt(5, price);

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

	/*3.カートの合計金額を出す*/
	public int getTotalPrice (String userId){
		int totalPrice = 0;
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();

		/*
		 * ログインしているuser_idと紐づく、
		 * cart_info内のproduct_count(購入個数)とprice(値段)を掛け合わせた
		 * total_priceを取得する
		 * sum(変数*変数)の処理は、変数のかけ算を行毎に行い、その後足し合わせることで合計金額を算出する
		 */
		String sql = "SELECT SUM(product_count * price) as total_price FROM cart_info WHERE user_id=? group by user_id";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			/* テーブル内の商品ごとのレコードを回すことで全ての値を取得する*/
			if(rs.next()){
				totalPrice = rs.getInt("total_price");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//合計金額の値を返す
		return totalPrice;
	}


	/*4.カート中身を削除(項目毎)*/
	public int delete(String Id){
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		int count = 0;

		 /* jspからきたidを元に
		 * user_idとproduct_idの一致するテーブルを生成
		 *一致したレコードのIDを抽出し、全て削除
		 */

		//user_idとprodunt_idを両方格納するための変数
		ResultSet result = null;

		//最初にidに紐づくuser_idとproduct_idを取り出し、その値を戻す(チェックされた一件分)
		String sqlGetAboutId = "select user_id, product_id from cart_info where id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sqlGetAboutId);
			ps.setString(1,Id);
			result = ps.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
		}

		String user_id = "";
		int product_id = 0;

		//初期化した変数に取得したuser_idとproduct_idをセット
		try {
			while (result.next()){
					user_id = result.getString("user_id");
					product_id = result.getInt("product_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//値を取得できているか確認
		System.out.println("user_id：" + user_id);
		System.out.println("product_id：" + product_id);

		//同一のuser_idとproduct_idのidを格納用の変数
		ResultSet result2 = null;

		//同一のuser_idとproduct_idのレコードを全て取り出す
		String sqlSameId = "select id from cart_info where user_id=? and  product_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sqlSameId);
			ps.setString(1,user_id);
			ps.setInt(2, product_id);
			result2 = ps.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
		}

		/*
		 *上記SQL文で取得した、user_idとproduct_idの
		 *一致するレコード全てを削除するためにresult2の値が空にになるまで
		 *next()で回す
		 */
		try {
			while (result2.next()){
				String deleteId = result2.getString("id");
				String sql = "DELETE FROM cart_info WHERE id = ?";

				try{
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,deleteId);
					count = ps.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//更新件数を返す
		return count;
	}

	/*5.カートの中身を削除(全項目)*/
	public int deleteAll(String userId){
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		int count = 0;

		/*
		 * カートの情報の紐づいているuser_idそのものを削除することで
		 * 該当ユーザーのカート情報を全て削除する
		 */
		String sql = "DELETE FROM cart_info WHERE user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
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

	/*6.カートの中身が存在するかの確認*/
	public boolean isExistsCartInfo(){
		return false;
	}

	/*7.仮のIdが発行されているユーザーを決済画面で本Idのユーザーと置き換える*/
	public int linkToLoginId(String tempUserId, String loginId){
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		int count = 0;

		/*
		 *tempUserId(仮ID)にnullを代入して、ログイン画面で入力したuser_idを
		 *更新する
		 */
		String sql = "UPDATE cart_info SET user_id=?,temp_user_id = null WHERE temp_user_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, tempUserId);
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

	/*
	 * 以下管理者用メソッド
	 * AdminAllSelectActionで使う用
	 */
	public List<CartInfoDTO> getCartInfoAllDtoList(){
		DBConnector dbc = new DBConnector();
		Connection con = dbc.getConnection();
		List<CartInfoDTO> CartInfoDtoList = new ArrayList<CartInfoDTO>();

		/*
		 * stelec文でasを使用してカラムの名前を変更
		 * 抜き出す要素についてはCartInfoDTOを参照
		 * cart_infoを基点として、product_infoを結合
		 * cart_infoとproduct_infoのproduct_count(購入個数)とprice(値段)を
		 * 掛け合わせたものをsubtotal(合計金額)として新しいカラムを作成
		 * 両テーブルに共通するproduct_idを単純結合
		 * その中でuser_idと一致する項目を取得
		 */
		String sql = "select * from cart_info";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO ciDTO = new CartInfoDTO();
				ciDTO.setId(rs.getInt("id"));
				ciDTO.setUserId(rs.getString("user_id"));
				ciDTO.setTempUserId(rs.getString("temp_user_id"));
				ciDTO.setProductId(rs.getInt("product_id"));
				ciDTO.setProductCount(rs.getInt("product_count"));
				ciDTO.setPrice(rs.getInt("price"));
				ciDTO.setRegistDate(rs.getDate("regist_date"));
				ciDTO.setUpdateDate(rs.getDate("update_date"));
				CartInfoDtoList.add(ciDTO);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return CartInfoDtoList;
	}

}
