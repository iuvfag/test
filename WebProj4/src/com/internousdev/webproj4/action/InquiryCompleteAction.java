package com.internousdev.webproj4.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.webproj4.dao.InquiryCompleteDAO;
import com.internousdev.webproj4.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InquiryCompleteAction extends ActionSupport{

	private String name;
	private String qtype;
	private String body;

	List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

	public String execute(){
		String ret = ERROR;
		InquiryCompleteDAO dao = new InquiryCompleteDAO();
		int count = dao.insert(name, qtype, body);
		/**
		 * countにDAOクラスのinsertメソッドの実行結果を代入
		 * insertメソッドの戻り値はint型であるため
		 * int型で受ける
		 */

		if(count > 0){
			inquiryDTOList = dao.select();
			ret = SUCCESS;
			/**
			 * 代入されたものが1つでもある場合は
			 * DTOクラス型のListにDAOクラスのselectメソッド
			 * （データベースの中にある情報をすべて取り出す）
			 * の実行結果を代入
			 * retにSUCCESSを代入
			 */
		}
		return ret;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getQtype(){
		return qtype;
	}

	public void setQtype(String qtype){
		this.qtype = qtype;
	}

	public String getBody(){
		return body;
	}

	public void setBody(String body){
		this.body = body;
	}

	public List<InquiryDTO> getInquiryDTOList(){
		return inquiryDTOList;
	}

	public void setInquiryDTOList(List<InquiryDTO> inquiryDTOList){
		this.inquiryDTOList = inquiryDTOList;
	}

}
