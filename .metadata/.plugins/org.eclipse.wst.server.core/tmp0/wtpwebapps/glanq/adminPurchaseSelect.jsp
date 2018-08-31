<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/admin.css">
<title>商品購入履歴一覧</title>
</head>
<body>
  <jsp:include page="header.jsp"/>
<div id="contents">
<h1>商品購入履歴一覧画面</h1>

<!-- これは商品履歴が０より大きい場合にif文が働く -->
<s:if test="#session.purchaseHistoryInfoDtoList.size()>0">
<!-- 頭のテーブルを作成 -->
<table class="horizontal-list-table">
<thead>
<tr>
    <th><s:label value="ユーザー名"/></th>
    <th><s:label value="商品名"/></th>
    <th><s:label value="ふりがな"/></th>
    <th><s:label value="商品画像"/></th>
    <th><s:label value="個数"/></th>
    <th><s:label value="値段"/></th>
    <th><s:label value="発売会社名"/></th>
    <th><s:label value="発売年月日"/></th>
</tr>
</thead>
<tbody>
<!-- iteratorを用いてsessionの商品履歴リストで表示。 -->
<s:iterator value="#session.purchaseHistoryInfoDtoList">
<tr>
    <td><s:property value="userId"/></td>
    <td><s:property value="productName"/></td>
    <td><s:property value="productNameKana"/></td>
    <td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px"/></td>
    <td><s:property value="productCount"/>個</td>
    <td><s:property value="price * ProductCount"/>円</td>
    <td><s:property value="releaseCompany"/></td>
    <td><s:property value="releaseDate"/></td>
</tr>
</s:iterator>
</tbody>
</table>

</s:if>
<s:else>
<div class="info">
商品購入履歴情報はありません。
</div>
</s:else>
<div id="piston"></div>
</div>
<s:include value="footer.jsp"/>

</body>
</html>