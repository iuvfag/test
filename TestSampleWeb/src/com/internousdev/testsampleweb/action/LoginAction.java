package com.internousdev.testsampleweb.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.CartInfoDAO;
import com.internousdev.testsampleweb.dao.DestinationInfoDAO;
import com.internousdev.testsampleweb.dao.MCategoryDAO;
import com.internousdev.testsampleweb.dao.UserInfoDAO;
import com.internousdev.testsampleweb.dto.DestinationInfoDTO;
import com.internousdev.testsampleweb.dto.MCategoryDTO;
import com.internousdev.testsampleweb.dto.UserInfoDTO;
import com.internousdev.testsampleweb.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String loginId;
	private String password;
	private boolean savedLoginId;

	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> loginErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;

		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("loginErrorMessageList");

		if(savedLoginId == true){
			session.put("savedLoginId", true);
			session.put("loginId", loginId);
		}else{
			session.put("savedLoginId", false);
			session.put("loginId", loginId);
		}
		//まず、ログイン状態かどうか判別

		/**
		 * ここでは複雑な分岐を行う
		 * ①ユーザー情報が登録済みか、登録済みならログインする
		 * ②ログイン前にすでにカートに商品を登録している場合、IDにカートを紐付ける
		 * ③カートに商品が登録されている場合で宛先情報は登録済みか,登録済みなら決済画面に飛ばす
		 */

		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);
		/**
		 * 入力された文字列が有効かどうかをチェック
		 * 結果はList型で返ってくるためList型変数で受ける
		 */


		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		/**
		 * session内にｍCategoryListのキーが保存されていない場合は
		 * そのキーでmCategoryListを格納
		 */


		UserInfoDAO userInfoDAO = new UserInfoDAO();
		if(userInfoDAO.isExistsUserInfo(loginId, password)){
			if(userInfoDAO.login(loginId, password) > 0){
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId, password);
				session.put("loginId", userInfoDTO.getUserId());

				/**
				 * まず①を確認
				 * UserInfoDAOクラスのisExistsUserInfoメソッドを呼び出す
				 * このメソッドはJSPファイルで入力されたログインIDとパスワードを元に
				 * そのユーザーがDBに存在するかを確認するメソッド
				 *
				 * 存在するならloginメソッドを呼び出す
				 * このメソッドでDB内のカラムloginedを1に設定する
				 * 設定されたカラムが1以上（存在する）か確かめる
				 *
				 * 存在する場合はユーザー情報を取得し
				 * sessionにログインIDを格納
				 */

				int count = 0;
				CartInfoDAO cartInfoDAO = new CartInfoDAO();

				count = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
				/**
				 * ②を実行
				 * String.valueOfは数値を文字列に変換するメソッド
				 * toStringとの違いは値がnullでもそのnullを返すこと
				 * （toStringだとNullPointerが発生してしまう）
				 *
				 * このメソッドを呼び出すことで暫定のIDと登録されたIDを元に
				 * カート情報をひも付ける
				 * （カート情報のユーザーID情報を登録済みのものに置き換える）
				 * これでログイン前のカート情報をログイン後にも引き継ぐことが出来る
				 */
				if(count > 0){
					DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
					try{
						List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
						destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(loginId);
						Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
						/**
						 * ③を確認
						 * カート情報がすでに登録されている場合、
						 * DestinationInfoDAOクラスのgetDestinationInfoメソッドを呼び出し、
						 * その結果をListに格納
						 * 繰り返し処理を行うため、今回はiteratorを利用する
						 */
						if(!(iterator.hasNext())){
							destinationInfoDTOList = null;
							/**
							 * iteratorに入った値がなければ
							 * Listの中身をnullにする
							 */
						}
						session.put("destinationInfoDTOList", destinationInfoDTOList);
						/**
						 * sessionにdestinationInfoDTOListを格納
						 */
					}catch(SQLException e ){
						e.printStackTrace();
					}
					result = "settlement";
				}else{
					result = SUCCESS;
				}
			}
			session.put("logined", 1);
		}else{
				loginErrorMessageList.add("パスワードが異なります。");
		}


		if(loginIdErrorMessageList.size()!=0
				|| passwordErrorMessageList.size()!=0
				|| loginErrorMessageList.size()!=0){
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("loginErrorMessageList", loginErrorMessageList);
			session.put("logined", 0);
		}
		/**
		 * 上記のエラーメッセージリストたちに何か入っていれば
		 * それをsessionに格納
		 */

		return result;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getLoginId(){
		return loginId;
	}

	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}


	public boolean isSavedLoginId(){
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId){
		this.savedLoginId = savedLoginId;
	}

	public List<String> getLoginIdErrorMessageList(){
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList){
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList(){
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList){
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getLoginErrorMessageList(){
		return loginErrorMessageList;
	}

	public void setLoginErrorMessageList(List<String> loginErrorMessageList){
		this.loginErrorMessageList = loginErrorMessageList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
