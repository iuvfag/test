package com.internousdev.testsampleweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.testsampleweb.dto.ProductInfoDTO;
import com.internousdev.testsampleweb.util.DBConnector;

public class ProductInfoDAO {

	public List<ProductInfoDTO> getProductInfoList(){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getInt("status"));
				productInfoDTO.setRegistDate(rs.getDate("regist_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));

				productInfoDTOList.add(productInfoDTO);

			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return productInfoDTOList;
	}


	//商品情報を取得するメソッド(商品IDを元に)
	public ProductInfoDTO getProductInfo(int productId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT * FROM product_info WHERE product_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getInt("status"));
				productInfoDTO.setRegistDate(rs.getDate("regist_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));

			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTO;
	}


	/**
	 * カテゴリーID、商品IDを元に指定の数の商品情報を取得するメソッド
	 * ただし、ここでの商品情報はお勧めとして表示するもの！
	 */
	public List<ProductInfoDTO> getProductInfoListByCategoryId(int categoryId, int productId, int limitOffset, int limitRowCount){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info WHERE category_id = ? AND product_id  NOT IN(?) ORDER BY RAND() LIMIT ?,?";
		/**
		 * not in～は特定の値以外のデータを取得したい場合に使用する
		 * 今回はその後の値を？にし、引数で渡されたものを使用する
		 *
		 * order by rand はランダムに値を取得したい場合に使用する
		 *
		 * limit を使用することで取得件数を指定できる
		 * コンマで区切って2つ指定する場合は
		 * 「?番目から?件分取得する」
		 * という意味になる
		 *
		 */

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, productId);
			ps.setInt(3, limitOffset);
			ps.setInt(4, limitRowCount);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany("release_company");
				productInfoDTO.setStatus(rs.getInt("status"));
				productInfoDTO.setRegistDate(rs.getDate("regist_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));

				productInfoDTOList.add(productInfoDTO);

			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return productInfoDTOList;
	}


	/**
	 * 商品情報取得のメソッド
	 * カテゴリー「すべて」の場合
	 * 場合に応じてSQL文を分岐させているためややこしいかも
	 */
	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordList){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info WHERE";
		boolean initializeFlag = true ;

		for(String keyword : keywordList){
			if(initializeFlag){
				sql += "(product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
				initializeFlag = false;
			}else{
				sql += "AND (product_name like '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
			}
		}
		/**
		 * 拡張for文を使用する
		 * keywordリストに格納されている要素の数だけ要素を取り出し
		 * SQL文に代入している
		 */

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getInt("status"));
				productInfoDTO.setRegistDate(rs.getDate("regist_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));

				productInfoDTOList.add(productInfoDTO);
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return productInfoDTOList;
	}


	/**
	 * 商品情報取得のメソッド
	 * カテゴリー「すべて」以外の何かが選択されている場合
	 * 場合に応じてSQL文を分岐させているためややこしいかも
	 */
	public List<ProductInfoDTO> getProductInfoListByKeyWords(String[] keywordsList, String categoryId){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info WHERE";
		boolean initializeFlag = true;

		for(String keyword : keywordsList){
			if(initializeFlag){
				sql += " category_id = " + categoryId + " AND(product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
				initializeFlag = false;
			}else{
				sql += " AND(product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
			}
		}
		/**
		 * 今回の場合はカテゴリーIDを代入している
		 * それ以外は基本的には上のメソッドと同じ
		 */

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
				productInfoDTO.setStatus(rs.getInt("status"));
				productInfoDTO.setRegistDate(rs.getDate("regist_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));

				productInfoDTOList.add(productInfoDTO);
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

}
