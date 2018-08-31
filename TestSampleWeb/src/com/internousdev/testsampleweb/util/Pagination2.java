package com.internousdev.testsampleweb.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.testsampleweb.dto.PaginationDTO;
import com.internousdev.testsampleweb.dto.ProductInfoDTO;

// [!]動作未確認
public class Pagination2 {

	// getPage は、[[ 任意のページ番号における、商品一覧のページ情報
	// ]]を取得する。（商品リストproductList、１ページの表示数pageSize、表示するページ番号pageNoが必要）
	public PaginationDTO getPage(List<ProductInfoDTO> productList, int pageSize, int pageNo) {

		PaginationDTO paginationDTO = new PaginationDTO();

		// 例として右に「全20件を9件ずつ表示する場合の、2ページ目の値」のイメージをそれぞれ追記。
		int a = productList.size();
		int b = pageSize;
		@SuppressWarnings("unused")
		int c = (int) (Math.ceil(a / b));
		int d = (a + b - 1) / b;
		paginationDTO.setTotalPageSize(d); // 全ページ数3
		paginationDTO.setCurrentPageNo(pageNo); // 表示するページ番号2
		paginationDTO.setTotalRecordSize(productList.size()); // 商品情報数20 [?]怪しめ
		paginationDTO.setStartRecordNo((pageSize * (pageNo - 1)) + 1); // 10番目の商品から表示
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + pageSize - 1); // 18番目の商品まで表示

		// ページ下部に表示する数字のリストを準備。
		List<Integer> nList = new ArrayList<Integer>();
		for (int i = 1; i <= paginationDTO.getTotalPageSize(); i++) {
			int pageN = i;
			nList.add(pageN);
		}
		paginationDTO.setPageNumberList(nList);

		// ページに表示する商品リストを準備。
		List<ProductInfoDTO> currentProductInfoPage = new ArrayList<ProductInfoDTO>();
		int startI = paginationDTO.getStartRecordNo() - 1;
		// int endI = paginationDTO.getEndRecordNo();
		int endI2 = Math.min(paginationDTO.getEndRecordNo(), paginationDTO.getTotalRecordSize());
		for (int i = startI; i < endI2; i++) {
			// i番目の要素（商品情報）を add していく。
			ProductInfoDTO pInfoDTO = productList.get(i);
			currentProductInfoPage.add(pInfoDTO);
		}
		paginationDTO.setCurrentProductInfoPage(currentProductInfoPage);

		// 次ページ、前ページが存在するかどうか。
		boolean hasNextPage;
		boolean hasPreviousPage;
		if (pageNo <= 1) {
			hasPreviousPage = false;
		} else {
			hasPreviousPage = true;
		}
		if (pageNo >= paginationDTO.getTotalPageSize()) {
			hasNextPage = false;
		} else {
			hasNextPage = true;
		}
		paginationDTO.setHasNextPage(hasNextPage);
		paginationDTO.setHasPreviousPage(hasPreviousPage);

		// 次ページ、前ページの番号。
		paginationDTO.setNextPageNo(pageNo + 1);
		paginationDTO.setPreviousPageNo(pageNo - 1);

		return paginationDTO;
	}
	// getPage おわり。

	// initialize は、商品一覧の[[ 1ページ目のページ情報
	// ]]を取得する。（商品リストproductList、１ページの表示数pageSizeが必要）
	public PaginationDTO initialize(List<ProductInfoDTO> productList, int pageSize) {

		PaginationDTO paginationDTO = new PaginationDTO();

		// 例として右に「20件を9件ずつ表示する場合の、1ページ目の値」のイメージをそれぞれ追記。
		int a = productList.size();
		int b = pageSize;
		@SuppressWarnings("unused")
		int c = (int) (Math.ceil(a / b));
		int d = (a + b - 1) / b;
		paginationDTO.setTotalPageSize(d); // 全ページ数3
		paginationDTO.setCurrentPageNo(1); // 現在のページ番号1
		paginationDTO.setTotalRecordSize(productList.size()); // 商品情報数20
		paginationDTO.setStartRecordNo((pageSize * (1 - 1)) + 1); // 1番目の商品から表示
		paginationDTO.setEndRecordNo(paginationDTO.getStartRecordNo() + pageSize - 1); // 9番目の商品まで表示

		// ページ下部に表示する数字のリストを準備。
		List<Integer> nList = new ArrayList<Integer>();
		for (int i = 1; i <= paginationDTO.getTotalPageSize(); i++) {
			int pageN = i;
			nList.add(pageN);
		}
		paginationDTO.setPageNumberList(nList);

		// ページに表示する商品リストを準備。
		List<ProductInfoDTO> currentProductInfoPage = new ArrayList<ProductInfoDTO>();
		int startI = paginationDTO.getStartRecordNo() - 1;
		// int endI = paginationDTO.getEndRecordNo();
		int endI2 = Math.min(paginationDTO.getEndRecordNo(), paginationDTO.getTotalRecordSize());
		for (int i = startI; i < endI2; i++) {
			ProductInfoDTO pInfoDTO = productList.get(i);
			currentProductInfoPage.add(pInfoDTO);
		}
		paginationDTO.setCurrentProductInfoPage(currentProductInfoPage);

		// 次ページ、前ページが存在するかどうか。
		boolean hasNextPage = true;
		boolean hasPreviousPage = false;
		paginationDTO.setHasNextPage(hasNextPage);
		paginationDTO.setHasPreviousPage(hasPreviousPage);

		// 次ページ、前ページの番号。
		paginationDTO.setNextPageNo(1 + 1);
		paginationDTO.setPreviousPageNo(1 - 1);

		return paginationDTO;
	}
	// initialize おわり。

}
// Pagination おわり。