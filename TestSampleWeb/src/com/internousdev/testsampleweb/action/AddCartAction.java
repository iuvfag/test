package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.CartInfoDAO;
import com.internousdev.testsampleweb.dto.CartInfoDTO;
import com.internousdev.testsampleweb.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String productCount;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;

	private String categoryId;

	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;
		String userId = null;
		String tempUserId = null;

		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserOd"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRandomValue());
		}

		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}

		if(!(session.containsKey("loginId")) && session.containsKey("tempUserId")){
			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}

		productCount = String.valueOf((productCount.split(" ,", 0))[0]);

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int count = cartInfoDAO.regist(userId, tempUserId, productId, productCount, price);

		if(count > 0){
			result = SUCCESS;
		}

		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(userId);
		Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();

		if(!(iterator.hasNext())){
			cartInfoDTOList = null;
		}

		session.put("cartInfoDTOlist", cartInfoDTOList);
		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
 	}

}