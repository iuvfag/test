package com.internousdev.webproj3.action;

import com.internousdev.webproj3.dao.HelloStrutsDAO;
import com.internousdev.webproj3.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HelloStrutsAction extends ActionSupport{

	private String result;

	public String execute(){
		String ret = ERROR;
		/**
		 * struts.xmlに渡すexecuteの結果をString型の変数に代入
		 * デフォルトはerrorにしておく
		 */
		HelloStrutsDAO dao = new HelloStrutsDAO();
		HelloStrutsDTO dto = new HelloStrutsDTO();
		// DAOとDTOをそれぞれインスタンス化しておく

		dto = dao.select();
		System.out.println(dto.getResult());
		/**
		 * DTOにDAOのデータベース接続の実行結果を代入
		 * DTOクラスにあるgetterを利用してresultを取り出し 出力
		 */

		result = dto.getResult();
		/**
		 * このクラスのresultにDTOのresult
		 * （DAOでのデータベース接続結果を代入してあるもの）を代入
		 * 結果は「MySQLに接続できます」、「MySQLに接続できません」
		 * の2択になる
		 */


		if(result.equals("MySQLと接続できます")){
			ret = SUCCESS;
		}else{
			ret = ERROR;
		}
		/**
		 * 接続ができていればsuccess
		 * できていなければerrorの結果を戻す
		 */

		return ret;
	}

	public String getResult(){
		return result;
	}

	public void setResult(String result){
		this.result = result;
	}

}
