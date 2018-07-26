package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.CartInfoDAO;
import com.internousdev.testsampleweb.dao.PurchaseHistoryInfoDAO;
import com.internousdev.testsampleweb.dto.CartInfoDTO;
import com.internousdev.testsampleweb.dto.DestinationInfoDTO;
import com.internousdev.testsampleweb.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{

	private String id;
	private String categoryId;
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;

		@SuppressWarnings("unchecked")
		ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = (ArrayList<PurchaseHistoryInfoDTO>)session.get("purchaseHistoryInfoDTOList");
		/**
		 * SupressWarningsは警告文を回避するために記述する
		 * 今回の場合はsession(中身はオブジェクト型)をArrayListにキャスト（型を変更）しようすると
		 * エラーが発生するため
		 */

		@SuppressWarnings("unchecked")
		ArrayList<DestinationInfoDTO> destinationInfoDTOList = (ArrayList<DestinationInfoDTO>)session.get("destinationInfoDTOList");

		for(int i=0; i<purchaseHistoryInfoDTOList.size(); i++){
			purchaseHistoryInfoDTOList.get(i).setDestinationId(destinationInfoDTOList.get(0).getId());
		}
		/**
		 * 購入履歴リストの値であるdestinationId(宛先情報のID)に
		 * 宛先リストの0番目のID(最初のID)をputしていく
		 * for文でリストの長さ分回し、すべての宛先ID
		 * をputしていく
		 */


		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = 0;

		for(int i=0; i < purchaseHistoryInfoDTOList.size(); i++){
			count += purchaseHistoryInfoDAO.regist(String.valueOf(session.get("loginId")),
					purchaseHistoryInfoDTOList.get(i).getProductId(),
					purchaseHistoryInfoDTOList.get(i).getProductCount(),
					purchaseHistoryInfoDTOList.get(i).getDestinationId(),
					purchaseHistoryInfoDTOList.get(i).getSubtotal()
					);
		}
		/**
		 * 商品購入履歴に情報を登録していく
		 * purchaseHistoryInfoDTOListから
		 * ログインID、商品ID、商品購入数、宛先ID、合計を取り出し
		 * countに代入していく
		 *
		 * このcountはif文の判定に使うために用意したものであり、
		 * 後で上書きしても問題ない
		 */

		if(count > 0){
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			count = cartInfoDAO.deleteAll(String.valueOf("loginId"));
			/**
			 * 商品購入履歴に情報が登録できたら
			 * カート情報は削除する
			 */

			if(count > 0){
			List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
			cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(String.valueOf(session.get("loginId")));
			Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

			if(!(iterator.hasNext())){
				cartInfoDTOList = null;
			}
			session.put("cartInfoDTOList", cartInfoDTOList);

			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(String.valueOf(session.get("loginId")))));
			session.put("totalPrice", totalPrice);
			result = SUCCESS;

			}
		}

		return result;

	}


	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}