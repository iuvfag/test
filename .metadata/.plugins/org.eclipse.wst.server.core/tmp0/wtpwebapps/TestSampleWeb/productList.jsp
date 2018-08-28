<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>商品一覧</title>
	</head>
	<body>

	<!-- 商品一覧表次ページ
		商品の画像を押すと商品詳細に飛ぶようにする -->

		<jsp:include page="header.jsp" />

		<div id="contents">
			<h1>商品一覧画面</h1>
			<s:if test="productInfoDTOList==null">
				<div class="info">
					検索結果がありません。
				</div>
			</s:if>

			<s:else>
				<div id="product-list">
					<s:iterator value="#session.productInfoDTOList">
						<div class="product-list-box">
							<ul>
								<li>
									<a href='<s:url action="ProductDetailsAction">
									<s:param name="productId" value="%{productId}" /></s:url>'>
									<!-- 上のように書くことでクリックするとアクションクラスに値を渡すurlリンクを作ることが出来る
										画像をクリックすると商品詳細ページに飛ぶようにできる -->
									<img src='<s:property value="imageFilePath" />/<s:property value="imageFileName" />' class="item-image-box-200" /></a><br>
									<s:property value="productName" /><br>
									<s:property value="productNameKana" /><br>
									<s:property value="price"/>円<br>
								</li>
							</ul>
						</div>
					</s:iterator>

					<!-- Iteratorを利用することでリスト内のすべての値を取得することが出来る
						今回は全商品数分取得する -->

				</div>

				<div class="pager">
					<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
					<!-- 上記のようにsタグ内にstatusを設定すると繰り返しの状態を取得できる
						pageNoがstatusということになる
						下記のようにsタグ内で呼び出し、使用することも可能
						1から全ページ数まで繰り返す -->

						<s:if test="#session.currentPageNo == #pageNo.count">
							<s:property value="%{#pageNo.count}" />
							<!-- 先ほど登場したstatusを使用
							countは1から数えて何番目かというのを判定するもの
							現在自分のいるページと1から数えたページ番号が一致する場合は
							countを表示
							つまり「現在自分がいるページを黒字にして選択できないようにする」
							ということをやっている -->
						</s:if>

						<s:else>
							<a href="<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}' /><s:param name='categoryId' value='%{categoryId}' /></s:url> ">	<s:property value="%{#pageNo.count}" /></a>
						</s:else>
						<!-- 上記の文は自分が現在いるページ以外のページ番号の動作を決めるもの
							URLでactionクラスへのリンクをつくり、表示する文字は
							先でも出てきたcountを使う
							これで自分がいるページ以外の番号はすべてリンクにすることが出来る -->

					</s:iterator>
				</div>
			</s:else>

		</div>

		<s:include value="footer.jsp" />

	</body>
</html>