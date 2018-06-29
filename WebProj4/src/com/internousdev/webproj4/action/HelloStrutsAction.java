package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.HelloStrutsDAO;
import com.internousdev.webproj4.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport{

	private List<HelloStrutsDTO> HelloStrutsDTOList = new ArrayList<HelloStrutsDTO>();
	/**
	 * List型の変数HelloStrutsDTOListを宣言する
	 * 「helloStrutsDTOList」と区別するため、先頭は大文字にする
	 */

	public String execute(){

		String ret = ERROR;
		HelloStrutsDAO dao = new HelloStrutsDAO();

		HelloStrutsDTOList = dao.select();
		/**
		 * DAOクラスのselectメソッドを呼び出す
		 * selectメソッドの戻り値はList方であるため、
		 * List型の変数HelloStrutsDTOListに代入する
		 */

		if(HelloStrutsDTOList.size() > 0){
			// 代入された値が1以上（存在するなら）という条件式
			ret = SUCCESS;
		}else{
			ret = ERROR;
		}

		return ret;


	}

	public List<HelloStrutsDTO> getHelloStrutsDTOList(){
		return HelloStrutsDTOList;
	}

	public void setHelloStrutsDTOList(List<HelloStrutsDTO> helloStrutsDTOList){
		HelloStrutsDTOList = helloStrutsDTOList;
	}


}
