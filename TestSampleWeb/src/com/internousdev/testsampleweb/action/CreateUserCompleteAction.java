package com.internousdev.testsampleweb.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.CartInfoDAO;
import com.internousdev.testsampleweb.dao.UserInfoDAO;
import com.internousdev.testsampleweb.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;
	private String password;
	private String categoryId;
	private Map<String ,Object> session;

	public String execute(){
		String result = SUCCESS;
		UserInfoDAO userInfoDAO = new UserInfoDAO();

		int count = userInfoDAO.createUser(familyName, firstName, familyNameKana, firstNameKana, sex, email, loginId, password);
		if(count > 0){
			result = SUCCESS;
		}

		if(userInfoDAO.isExistsUserInfo(loginId, password)){
			if(userInfoDAO.login(loginId, password) > 0){
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId, password);
				session.put("loginId", userInfoDTO.getUserId());

				/**
				 * 次にそのままログイン状態へと移行する
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

				@SuppressWarnings("unused")
				int check = 0;
				CartInfoDAO cartInfoDAO = new CartInfoDAO();

				check = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
				/**
				 * カート情報をユーザーIDに紐付ける
				 * String.valueOfは数値を文字列に変換するメソッド
				 * toStringとの違いは値がnullでもそのnullを返すこと
				 * （toStringだとNullPointerが発生してしまう）
				 *
				 * このメソッドを呼び出すことで暫定のIDと登録されたIDを元に
				 * カート情報をひも付ける
				 * （カート情報のユーザーID情報を登録済みのものに置き換える）
				 * これでログイン前のカート情報をログイン後にも引き継ぐことが出来る
				 */

				}
			}else{
				result = SUCCESS;
			session.put("logined", 1);
			//ログインフラグを付ける
		}

		return result;
		/**
		 * 入力内容をDBに登録
		 * 登録できたら成功！
		 */
	}


	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getFamilyName(){
		return familyName;
	}

	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana = firstNameKana;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
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

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}



}
