<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="./css/product.css">

<title>商品詳細画面</title>

<script type="text/javascript">
	function confirmAlert() {
		if(confirm("カートに商品を追加します。よろしいですか？")){
			document.getElementById("addCart").action="AddCartAction";
		}
	}
</script>

</head>
<body>

	<s:include value="header.jsp" />


<div id="contents">
	<div id="top_d">
		<h1>商品詳細ページ</h1>
	</div>

	<br><br>

	<div id="fadein_c">

	<!-- ～商品詳細を表示～ -->
	<div id="item_detail">
		<div id="left_box">
			<table>
			<tr>
				<th scope="col">商品画像</th>
			</tr>
			<tr>
				<td><div id="item_image_box"> <img id="item_image" src="<s:property value='#session.imageFilePath'/>/<s:property value='#session.imageFileName'/>"></div></td>
			</tr>
			</table>
		</div>

		<div id="right_box">
			<div id="sub_title_i">
			<h2>～ 商品情報 ～</h2>
			</div>
			<s:form id="addCart">
			<s:hidden name="productId" value="%{#session.productId}"/>
			<s:hidden name="productName" value="%{#session.productName}"/>
			<s:hidden name="productNameKana" value="%{#session.productNameKana}"/>
			<s:hidden name="imageFilePath" value="%{#session.imageFilePath}"/>
			<s:hidden name="imageFileName" value="%{#session.imageFileName}"/>
			<s:hidden name="releaseDate" value="%{#session.releaseDate}"/>
			<s:hidden name="releaseCompany" value="%{#session.releaseCompany}"/>
			<s:hidden name="price" value="%{#session.price}"/>
			<s:hidden name="categoryId" value="%{#session.categoryId}"/>
			<table id="item_info">
				<tr>
					<th scope="row">商品名</th>
					<td><s:property value="#session.productName"/></td>
				</tr>
				<tr>
					<th scope="row">商品名ふりがな</th>
					<td><s:property value="#session.productNameKana"/></td>
				</tr>
				<tr>
					<th scope="row">値段</th>
					<td><s:property value="#session.price"/><span>円</span></td>
				</tr>
				<tr>
					<th scope="row">発売会社</th>
					<td><s:property value="#session.releaseCompany"/></td>
				</tr>
				<tr>
					<th scope="row">発売年月日</th>
					<td><s:property value="#session.releaseDate"/></td>
				</tr>
				<tr>
					<th scope="row">商品詳細情報</th>
					<td height="52"><div id="description"><s:property value="#session.productDescription"/></div></td>
				</tr>
			</table>
			<table id="buy">
				<tr>
					<th><s:select name="productCount" list="%{#session.productCountList}"/>個</th>
					<s:token/>
					<td><s:submit type="button" value="カートに追加" class="submit_btn" onclick="confirmAlert()"/></td>
				</tr>
			</table>



			</s:form>
		</div>
	</div>
	<br><br>
	<!-- ～関連商品を表示～ -->
	<s:if test="relate_noneFlg=='true'">
		<div id="relate_none">
			<div>
				同カテゴリの関連商品はありません。
			</div>
		</div>
	</s:if>
	<s:else>
	<div id="relate_logo">
		<a id="logo">関連商品</a>
	</div>
	<div id="related_product_list">
		<s:iterator value="#session.relatedProductList">
			<div id="product_box">
				<ul>
					<li>
					<div id="product_image_box">
					<a href='<s:url action="ProductDetailsAction">
							<s:param name="productId" value="%{productId}"/>
							</s:url>'>

							<img id="product_image" src="<s:property value='imageFilePath'/>/<s:property value='imageFileName'/>">
					</a>
					</div>
					</li>
					<li id="i_info"><s:property value="productName" /></li>
				</ul>
			</div>
		</s:iterator>
	</div>
	</s:else>

	</div>
<div id="piston"></div>
</div>

	<s:include value="footer.jsp" />

</body>
</html>