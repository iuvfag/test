package com.internousdev.testsampleweb.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.testsampleweb.dto.PaginationDTO;
import com.internousdev.testsampleweb.dto.ProductInfoDTO;

public class Pagination {

	public PaginationDTO initalize(List<ProductInfoDTO> list, int pageSize){
		//このpageSizeは1ページに表示する商品の数！！

		PaginationDTO paginationDTO = new PaginationDTO();

		//全ページ数
		paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));
		/**
		 * ceilは与えられた数字を四捨五入して、double型で返す
		 * 式の内容はListのサイズ（商品すべての数）÷1ページの商品数を整数にしたもの
		 * すべての商品を表示するのに必要な全ページ数が計算できる
		 */

		//現在のレコード番号
		paginationDTO.setCurrentPageNo(1);

		//全レコード数(商品数)
		paginationDTO.setTotalRecordSize(list.size() - 1);

		//現在のページ番号に対する開始レコード番号（オフセット）
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() - 1));

		//現在のページ番号に対する終了レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize - 1));

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1;pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++){
			pageNumberList.add(pageNumber);
		}
		/**
		 * 全ページ数の数だけfor文をまわし、
		 * まわしている回数分順番にpageNumberListに格納し続ける
		 * 全ページの数だけListに格納される
		 */

		List<ProductInfoDTO> productInfoPages = new ArrayList<ProductInfoDTO>();
		for(int pageNumberOffset = paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++){
			productInfoPages.add(list.get(pageNumberOffset));
		}
		/**
		 * 開始レコード番号から終了レコード番号の数だけfor文をまわし
		 * まわしている回数分値をListに格納する
		 * 1度に表示させたい商品数だけ商品情報をListにいれていく
		 *
		 * startRecordNoとendRecordNoはそれぞれ実際の表示数からそれぞれ1引いた数を
		 * 代入している
		 * これは後にListのindex番号に基づいてgetするためである
		 */
		paginationDTO.setCurrentProductInfoPage(productInfoPages);
		/**
		 * 1ページ分のリストページに上のListを格納
		 * これで1ページに必要な商品のindexが並べられる
		 */

		if((paginationDTO.getStartRecordNo() - 1) <= 0){
			paginationDTO.setHasPreviousPage(false);
		}else{
			paginationDTO.setHasPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}
		/**
		 * 前ページの表示の必要・不必要を判別するためif文の分岐を使用する
		 * 開始レコード番号の前ページがない場合（-1が0以下）「前ページが存在するか」はfalse
		 * そうでない場合はtrueであり、現在のページから1引いた数を
		 * 前ページ番号に格納する
		 */

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalPageSize()){
			paginationDTO.setHasNextPage(false);
		}else{
			paginationDTO.setHasNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}
		/**
		 * 次ページの必要・不必要を判別するためif文の分岐を使用する
		 * 1ページに表示する最後の商品の番号と
		 * 1ページあたりの商品表示数の合計が
		 * 全ページ数を超えてしまう場合は
		 * 「次のページが存在するか」はfalse
		 * そうでない場合はtrueとなり、現在のページに1足した数を
		 * 次ページ番号へ格納する
		 */

		return paginationDTO;

	}


	public PaginationDTO getPage(List<ProductInfoDTO> list, int pageSize, String pageNo){

		PaginationDTO paginationDTO = new PaginationDTO();

		//全ページ数
		paginationDTO.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));

		//現在のページ番号
		paginationDTO.setCurrentPageNo(Integer.parseInt(pageNo));

		//全レコード数
		paginationDTO.setTotalRecordSize(list.size() - 1);

		//現在のページ番号に対する開始レコード番号（オフセット）
		paginationDTO.setStartRecordNo(pageSize * (paginationDTO.getCurrentPageNo() -1));

		//現在のページ番号に対する開始レコード番号
	//  paginationDTO.setStartRecordNo((pageSize * paginationDTO.getCurrentPageNo()) + 1);

		//現在のページ番号に対する開始レコード番号
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + (pageSize -1));

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= paginationDTO.getTotalPageSize(); pageNumber++){
			pageNumberList.add(pageNumber);
		}

		List<ProductInfoDTO> productInfoPages = new ArrayList<ProductInfoDTO>();
		for(int pageNumberOffset = paginationDTO.getStartRecordNo(); pageNumberOffset <= paginationDTO.getEndRecordNo(); pageNumberOffset++){
			productInfoPages.add(list.get(pageNumberOffset));
		}
		paginationDTO.setCurrentProductInfoPage(productInfoPages);

		if((paginationDTO.getStartRecordNo() - 1) <= 0){
			paginationDTO.setHasPreviousPage(false);
		}else{
			paginationDTO.setHasPreviousPage(true);
			paginationDTO.setPreviousPageNo(paginationDTO.getCurrentPageNo() - 1);
		}

		if(paginationDTO.getEndRecordNo() + pageSize > paginationDTO.getTotalRecordSize()){
			paginationDTO.setHasNextPage(false);
		}else{
			paginationDTO.setHasNextPage(true);
			paginationDTO.setNextPageNo(paginationDTO.getCurrentPageNo() + 1);
		}

		return paginationDTO;

	}

}
