<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/admin.css">
<title>商品編集画面</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>商品編集画面</h1>
<div id="product-list">

<table class="horizontal-list-table2">
<!-- テーブルで表示する予定 -->
<thead>
	<tr>
		<th><s:label value="商品画像" /></th>
		<th><s:label value="商品名" /></th>
		<th><s:label value="ふりがな" /></th>
		<th><s:label value="値段" /></th>
		<th><s:label value="発売会社名" /></th>
		<th><s:label value="発売年月日" /></th>
	</tr>
</thead>
<tbody>
<s:iterator value="#session.productInfoDtoList">
	<tr>
		<td><a href='<s:url action="AdminEditDetailsAction">
			<s:param name="productId" value="%{productId}"/>
			</s:url>'><img src='<s:property value="imageFilePath" />/<s:property value="imageFileName" />' class="item-image-box-100" /></a><br></td>
		<td><s:property value="productName"/></td>
		<td><s:property value="productNameKana"/></td>
		<td><s:property value="price"/>円</td>
		<td><s:property value="releaseCompany"/></td>
		<td><s:property value="releaseDate"/></td>
	</tr>
</s:iterator>
</tbody>
</table>
</div>
<div class="pager">
<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
    <s:if test="#session.currentPageNo == #pageNo.count">
        <s:property value="%{#pageNo.count}"/>
    </s:if>
    <s:else>
        <a href="<s:url action='AdminEditAction'><s:param name='pageNo' value='%{#pageNo.count}'/>
        <s:param name='categoryId' value='%{categoryId}'/></s:url> "> <s:property value="%{#pageNo.count}"/></a>
    </s:else>
</s:iterator>
</div>
<div id="piston"></div>
</div>

		<s:include value="footer.jsp"/>

</body>
</html>