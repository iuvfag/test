package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;
		sexList.add(MALE);
		sexList.add(FEMALE);

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("familyNameKanaErrorMessageList");
		session.remove("fisrtNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("tellNumberErrorMessageList");
		session.remove("userAddressErrorMessageList");
		/**
		 * すでにメッセージがある場合、それを残したままにすると
		 * 余計な場所でメッセージが発生する場合がある
		 * いったんここではsessionから取り除いておこう
		 */

		result = SUCCESS;
		return result;
	}


	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getDefaultSexValue(){
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue){
		this.defaultSexValue = defaultSexValue;
	}

	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public List<String> getSexList(){
		return sexList;
	}

	public void setSexList(List<String> sexList){
		this.sexList = sexList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
