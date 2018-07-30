package com.internousdev.testsampleweb.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.testsampleweb.dao.MCategoryDAO;
import com.internousdev.testsampleweb.dao.ProductInfoDAO;
import com.internousdev.testsampleweb.dto.MCategoryDTO;
import com.internousdev.testsampleweb.dto.PaginationDTO;
import com.internousdev.testsampleweb.dto.ProductInfoDTO;
import com.internousdev.testsampleweb.util.InputChecker;
import com.internousdev.testsampleweb.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	private String categoryId;
	private String keywords;
	private String pageNo;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;


	public String execute(){
		String result = ERROR;

		InputChecker inputChecker = new InputChecker();
		if(keywords==null){
			keywords = "";
		}
		keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false, true, true);

		/**
		 * まず入力されたキーワードに応じて場合分け
		 * キーワードが空欄の場合は空欄をkeywordsに代入
		 * そうでない場合は入力された情報のチェック
		 *
		 * その後のswitch分の分岐で
		 * ①商品カテゴリーが「すべて」で検索されている場合
		 * ②それ以外のカテゴリーが選択されている場合
		 * に分けて検索を行う
		 */

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		switch(categoryId){
			case"1":
				productInfoDTOList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
				/**
				 * JSPから送られている値が1の場合(すべての商品が選択されている場合)
				 * すべての商品情報を取得する
				 *
				 * replaceAllは文字列を置換するもの(正規表現を変換する際に使う)
				 * カッコ内の最初の引数(正規表現であること)をカンマの後のものに変換する
				 *
				 * splitは指定した要素で(カッコ内の要素)で文字列を区切るもの
				 *
				 * 今回は「まず全角のスペースを半角に変換、その後半角のスペースで
				 * キーワードを区切る」ということをやっているよ
				 */
				result = SUCCESS;
				break;

			default:
				productInfoDTOList = productInfoDAO.getProductInfoListByKeyWords(keywords.replaceAll("　", " ").split(" "), categoryId);
				/**
				 * カテゴリーIDに1以外が選択されている場合は
				 * 引数にカテゴリーIDを渡し、キーワード検索を行う
				 */
				result = SUCCESS;
				break;
		}

		Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
		if(!(iterator.hasNext())){
			productInfoDTOList = null;
		}
		/**
		 * 取得したリストに次の要素がなければNullを代入
		 * キーワードが空欄の場合はSQL文がうまく実行されないため
		 * 必然的にnullになってしまうが？？
		 */

		session.put("keywordsErrorMessageList", keywordsErrorMessageList);


		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		/**
		 * 商品カテゴリーのリストがsessionになければ取得してsessionに代入
		 *
		 * 次にページャーに必要な値を取得する
		 */


		if(!(productInfoDTOList==null)){
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO= new PaginationDTO();
			if(pageNo==null){
				paginationDTO = pagination.initalize(productInfoDTOList, 9);
			}else{
				paginationDTO = pagination.getPage(productInfoDTOList, 9, pageNo);
			}
			/**
			 * Listに値が入っていれば
			 * pageNoの中身にあいたが入っているかどうかに応じて
			 * (いずれの場合にも対応させておく)
			 * ページャーに必要な情報を取得する
			 */

			session.put("productInfoDTOList", paginationDTO.getCurrentProductInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("previousPage", paginationDTO.getHasPreviousPage());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			session.put("nextPage", paginationDTO.getHasNextPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
		}else{
			session.put("productInfoDTOList", null);
		}
		return result;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public String getPageNo(){
		return pageNo;
	}

	public void setPageNo(String pageNo){
		this.pageNo = pageNo;
	}

	public List<MCategoryDTO> getMCategoryDTOList(){
		return mCategoryDTOList;
	}

	public void setMCategoryDTOList(List<MCategoryDTO> mCategoryDTOList){
		this.mCategoryDTOList = mCategoryDTOList;
	}

	public List<String> getKeywordsErrorMessageList(){
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList){
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	public List<ProductInfoDTO> getProductInfoDTOList(){
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList){
		this.productInfoDTOList = productInfoDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}



}
