package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.PurchaseHistoryInfoDAO;
import com.internousdev.testsampleweb.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue;
	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = purchaseHistoryInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
		/**
		 * 購入履歴削除のメソッド
		 * purchaseHistoryInfoDAOのdeleteAllメソッドを呼び出す
		 */

		if(count > 0){
			List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = purchaseHistoryInfoDAO.getPurchaseHistoryList(String.valueOf(session.get("loginId")));
			Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDTOList.iterator();
			/**
			 * 削除が出来れば（削除件数が1件でもあれば）
			 * 購入履歴のListをもう一度取得
			 *
			 * 成功していればListは空になるはずである
			 */

			if(!(iterator.hasNext())){
				purchaseHistoryInfoDTOList = null;
				/**
				 * 取得してきたリストの次の要素がなければ
				 * Listにnullを代入
				 */
			}
			session.put("purchaseHistoryInfoDTOList", purchaseHistoryInfoDTOList);
			//sessionにListを格納する

			sexList.add(MALE);
			sexList.add(FEMALE);

			session.put("sexList", sexList);
			/**
			 * 上記の3文を書いておかないとエラーが発生する
			 * strutsファイルのresult先がuserCreate.jspとなっているが、
			 * ここのファイル内にradioタグ内に「list="%{session.sexList}"」が存在する
			 * radioボタンの選択肢をsession内のsexListから選ぶものであるが、
			 * このjavaファイルによってsexListはputされていないため
			 * 未定義であるというエラーが発生してしまう
			 *
			 * これを避けるためには上のようにsessionにputしなおすか
			 * strutsのresultのリンク先を変更するしかないと思われる
			 */

			result = SUCCESS;
		}
		return result;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
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

	public String getDefaultSexValue(){
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue){
		this.defaultSexValue = defaultSexValue;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
