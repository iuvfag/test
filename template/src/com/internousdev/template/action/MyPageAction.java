package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	public String deleteFlg;
	private String result;
	/**
	 * deleteFlgは後にデータ削除をするかどうかの判定に使用
	 * JSPファイル側で削除したい場合は1をこちらに送ってくる
	 */

	public String execute() throws SQLException{
		MyPageDAO myPageDAO = new MyPageDAO();
		MyPageDTO myPageDTO = new MyPageDTO();

		//商品履歴を削除しない場合
		if(deleteFlg == null){
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();
			/**
			 * ログイン時に取得したID、ユーザーIDをそれぞれ格納する
			 */

			myPageDTO = myPageDAO.getMyPageUserInfo(item_transaction_id, user_master_id);
			/**
			 * 格納されたデータを基にしてデータベースへのアクセス
			 * （ユーザー情報の取得用メソッドを実行）
			 */

			session.put("buyItem_name", myPageDTO.getItemName());
			session.put("total_price", myPageDTO.getTotalPrice());
			session.put("total_count", myPageDTO.getTotalCount());
			session.put("total_payment", myPageDTO.getPayment());
			session.put("message", "");
			/**
			 * 情報の取得の際（DAOのメソッドの実行時）にDTOクラスに格納された
			 * 情報をsessionに代入
			 * この際、sessionに空のメッセージも入れておく
			 */


		//商品履歴を削除する場合
		}else if(deleteFlg.equals("1")){
			delete();
			/**
			 * 後述のdeleteメソッドを走らせる
			 */
		}
		result = SUCCESS;
		return result;
	}

	public void delete()throws SQLException{

		MyPageDAO myPageDAO = new MyPageDAO();

		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);
		/**
		 * myPageDAOのdeleteメソッドの戻り値を受け取る
		 */

		if(res > 0){
			session.put("message", "商品情報を正しく削除しました。");
		}else if(res == 0){
			session.put("message", "商品情報の削除に失敗しました。");
		}
		/**
		 * メッセージにはif文の分岐にあわせて
		 * 商品情報の削除に成功したかどうかを入れる
		 */

	}

	public String getDeleteFlg(){
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> loginSessionMap){
		this.session = loginSessionMap;
	}

}
