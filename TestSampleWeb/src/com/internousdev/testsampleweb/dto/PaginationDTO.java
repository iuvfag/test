package com.internousdev.testsampleweb.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO {
	//全ページ数
	private int totalPageSize;

	//現在のページ数
	private int currentPageNo;
	//全レコード数
	private int totalRecordSize;

	//開始レコード番号
	private int startRecordNo;

	//終了レコード番号
	private int endRecordNo;

	//ページャーに表示するページ番号一覧
	private List<Integer> pageNumberList = new ArrayList<Integer>();

	//1ページ分のリストページ情報（商品情報）
	private List<ProductInfoDTO> currentProductInfoPage;

	//次ページが存在するか
	private boolean hasNextPage;

	//前ページが存在するか
	private boolean hasPreviousPage;

	private int nextPageNo;
	private int previousPageNo;

	public int getPageTotalSize(){
		return totalPageSize;
	}

	public void setPageTotalSize(int totalPageSize){
		this.totalPageSize = totalPageSize;
	}

	public int getCurrentPageNo(){
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo){
		this.currentPageNo = currentPageNo;
	}

	public int getTotalRecordSize(){
		return totalRecordSize;
	}

	public void setTotalRecordSize(int totalRecordSize){
		this.totalRecordSize = totalRecordSize;
	}

	public int getStartRecordNo(){
		return startRecordNo;
	}

	public void setStartRecordNo(int startRecordNo){
		this.startRecordNo = startRecordNo;
	}

	public int getEndRecordNo(){
		return endRecordNo;
	}

	public void setEndRecordNo(int endRecordNo){
		this.endRecordNo = endRecordNo;
	}

	public List<Integer> getPageNumberList(){
		return pageNumberList;
	}

	public void setPageNumberList(List<Integer> pageNumberList){
		this.pageNumberList = pageNumberList;
	}

	public List<ProductInfoDTO> getCurrentProductInfoPage(){
		return currentProductInfoPage;
	}

	public void setCurrentProductInfoPage(List<ProductInfoDTO> currentProductInfoPage){
		this.currentProductInfoPage = currentProductInfoPage;
	}

	public boolean getHasNextPage(){
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage){
		this.hasNextPage = hasNextPage;
	}

	public boolean getHasPreviousPage(){
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage){
		this.hasPreviousPage = hasPreviousPage;
	}

	public int getNextPageNo(){
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo){
		this.nextPageNo = nextPageNo;
	}

	public int getPrevousPageNo(){
		return previousPageNo;
	}

	public void setPreviousPageNo(int previousPageNo){
		this.previousPageNo = previousPageNo;
	}


}