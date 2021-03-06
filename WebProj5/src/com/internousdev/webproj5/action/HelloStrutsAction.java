package com.internousdev.webproj5.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webproj5.dao.HelloStrutsDAO;
import com.internousdev.webproj5.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport implements SessionAware{
	/**
	 * SessionAwareインターフェースを実装することで
	 * Mapでセッションオブジェクトにアクセスできるようになる
	 * アクションクラスからもJSPファイルからもアクセスできるようになる
	 */

	private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();
	private Map<String, Object> session;
	/**
	 * Map<String, Oblect>の型には1対1の関係が格納される
	 * 格納される情報の数には制限がない
	 */

	public String execute(){
		String ret = ERROR;

		HelloStrutsDAO dao = new HelloStrutsDAO();

		helloStrutsDTOList = dao.select();

		if(helloStrutsDTOList.size() > 0){
			session.put("helloStrutsDTOList", helloStrutsDTOList);
			/**
			 *  今回の場合は「userId」「userName」「password」「result」に対応した値
			 * がそれぞれ格納されることになる
			 * keyをhelloStrutsDTOListに指定して登録する
			 */
			ret = SUCCESS;
		}else{
			ret = ERROR;
		}
		return ret;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
