package com.internousdev.ecsitetest.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsitetest.dao.LoginDAO;
import com.internousdev.ecsitetest.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String, Object> session;
	private String errorMessage;


	public String execute(){
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		result = ERROR;
		dto = dao.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", dto);

		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;

			session.put("login_user_id", dto.getLoginId());
			session.put("errorMessage", "");
			return result;
		}
		errorMessage = "入力内容が正しくありません。";
		session.put("errorMessage", errorMessage);
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
