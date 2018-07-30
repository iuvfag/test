package com.internousdev.testsampleweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.testsampleweb.dto.MCategoryDTO;
import com.internousdev.testsampleweb.util.DBConnector;

public class MCategoryDAO {

	//商品カテゴリー情報取得のためのメソッド
	public List<MCategoryDTO> getMCategoryList(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

		String sql = "SELECT * FROM m_category";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(rs.getInt("id"));
				mCategoryDTO.setCategoryId(rs.getInt("category_id"));
				mCategoryDTO.setCategoryName(rs.getString("category_name"));
				mCategoryDTO.setCategoryDescription(rs.getString("category_description"));
				mCategoryDTO.setInsertDate(rs.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(rs.getDate("update_date"));

				mCategoryDTOList.add(mCategoryDTO);
			}
			Iterator<MCategoryDTO> iterator = mCategoryDTOList.iterator();
			/**
			 * Iterator
			 * 要素を反復して処理する場合に使用する
			 * Listのすべての要素に対して処理を行いたい場合などに便利かな
			 */
			if(!(iterator.hasNext())){
				mCategoryDTOList = null;
				/**
				 * Iteratorのメソッド.hasNext()はさらに要素がある場合に
				 * trueを返す
				 * この場合は「iteratorにさらに要素がない場合」という意味
				 * ない場合はListにnullを代入する
				 */
			}
		}catch(SQLException e ){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e ){
			e.printStackTrace();
		}
		return mCategoryDTOList;
	}

}
