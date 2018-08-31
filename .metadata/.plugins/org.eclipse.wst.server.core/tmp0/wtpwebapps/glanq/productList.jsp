<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="./css/product.css">

<title>商品一覧画面</title>
</head>
<body>

<s:include value="header.jsp" />


<div id="contents">
	<div id="top_l">
		<h1>商品一覧ページ</h1>
	</div>

	<div id="fadein_c">

	<!-- 検索結果が無い場合 -->
	<s:if test="#session.productInfoDtoList == null">
		<div class="info">
			検索結果がありません。
		</div>
	</s:if>

	<s:else>
		<s:if test="#session.startRecordNo > #session.totalRecordSize">
			<div id="hit">
				<div class="info">[!] このページには商品情報がありません</div>
			</div>
		</s:if>
		<s:else>
		<div id="hit">
			全<s:property value='#session.totalRecordSize'/>件中 <s:property value='#session.startRecordNo'/> ～
					<s:if test="#session.endRecordNo > #session.totalRecordSize">
						<s:property value='#session.totalRecordSize'/>
					</s:if>
					<s:else>
							<s:property value='#session.endRecordNo'/>
					</s:else>
					件目を表示
		</div>
		</s:else>
		<br>
		<div id="newItemList">
			<!-- 商品一覧の部分 -->
			<s:iterator value="#session.productInfoDtoList">
			<div id="hiddenBox">
			<div id="newItemBox">
				<ul>
					<li>
 					<div id="item_image_box">
 					<a href='<s:url action="ProductDetailsAction">
 							<s:param name="productId" value="%{productId}"/>
 							</s:url>'>

 							<img id="item_image" src="<s:property value='imageFilePath'/>/<s:property value='imageFileName'/>">
 					</a>
 					</div>
					</li>
					<li id="i_info"><s:property value="productName" /></li>
					<li id="i_info"><s:property value="productNameKana" /></li>
					<li id="i_info"><s:property value="price" /><span>円</span></li>
				</ul>
			</div>
			</div>
			</s:iterator>
			<br>
			<br>

			<!-- ページ切り替えの数字部分 -->
			<!-- pageNo を1から全ページ数まで。現在のページ数は普通の数字、それ以外は対応したリンク付け -->
			<div class="pager">
			<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
				<s:if test="#session.currentPageNo == #pageNo.count">
					<s:property value="%{#pageNo.count}"/>
				</s:if>
				<s:else>
					<a href="<s:url action='SearchItemAction'>
							<s:param name='pageNo' value='%{#pageNo.count}'/>
							<s:param name='categoryId' value='%{categoryId}'/>
							<s:param name='keywords' value='%{keywords}'/>
							</s:url> ">

						<s:property value="%{#pageNo.count}"/>
					</a>
				</s:else>
			</s:iterator>
			</div>


		</div>

	</s:else>
	</div>
	<div id="piston"></div>
</div>

	<s:include value="footer.jsp" />

</body>
</html>