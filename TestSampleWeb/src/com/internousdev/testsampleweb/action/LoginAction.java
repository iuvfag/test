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

	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;

		if(savedLoginId == true){
			session.put("savedLoginId", true);
			session.put("loginId", loginId);
		}else{
			session.put("savedLoginId", false);
			session.put("loginId", loginId);
		}

		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);

		if(loginIdErrorMessageList.size()!=0
				&& passwordErrorMessageList.size()!=0){
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("logined", 0);
		}

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}


		UserInfoDAO userInfoDAO = new UserInfoDAO();
		if(userInfoDAO.isExistsUserInfo(loginId, password)){
			if(userInfoDAO.login(loginId, password) > 0){
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId, password);
				session.put("loginId", userInfoDTO.getUserId());
				int count = 0;
				CartInfoDAO cartInfoDAO = new CartInfoDAO();

				count = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
				/**
				 * String.valueOfは数値を文字列に変換するメソッド
				 * toStringとの違いは値がnullでもそのnullを返すこと
				 * （toStringだとNullPointerが発生してしまう）
				 */
				if(count > 0){
					DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
					try{
						List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
						destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(loginId);
						Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
						/**
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

		}
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

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
