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
<title>管理者データ確認</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>管理者データ確認画面</h1>


<h2>カートデータ</h2>
<!-- カートの中身がある時。 -->
<s:if test="#session.CartInfoAllDtoList.size() > 0">
<table class="horizontal-list-table">

<!-- テーブルの頭 -->
<thead>
<tr>
<th><s:label value="ID"/></th>
<th><s:label value="ユーザーID"/></th>
<th><s:label value="仮ユーザーID"/></th>
<th><s:label value="商品ID"/></th>
<th><s:label value="個数"/></th>
<th><s:label value="金額"/></th>
<th><s:label value="登録日"/></th>
<th><s:label value="更新日"/></th>
</tr>
</thead>

<!-- セッションからの表示項目 -->
<tbody>
<s:iterator value="#session.CartInfoAllDtoList">
<tr>
<td><s:property value="id"/></td>
<td><s:property value="userId"/></td>
<td><s:property value="tempUserId"/></td>
<td><s:property value="productId"/></td>
<td><s:property value="productCount"/></td>
<td><s:property value="price"/></td>
<td><s:property value="registDate"/></td>
<td><s:property value="updateDate"/></td>
</tr>
</s:iterator>
</tbody>
</table>
</s:if>

<!-- カートの中身がなかった場合 -->
<s:else>
<div class="info">
カートに情報はありません。
</div>
</s:else>


<h2>宛先情報データ</h2>
<!-- 宛先情報データがある時。 -->
<s:if test="#session.DestinationInfoAllDtoList.size() > 0">
<table class="horizontal-list-table">

<!-- 宛先情報の頭 -->
<thead>
<tr>
<th><s:label value="ID"/></th>
<th><s:label value="ユーザーID"/></th>
<th><s:label value="姓"/></th>
<th><s:label value="名"/></th>
<th><s:label value="姓かな"/></th>
<th><s:label value="名かな"/></th>
<th><s:label value="メールアドレス"/></th>
<th><s:label value="電話番号"/></th>
<th><s:label value="住所"/></th>
<th><s:label value="登録日"/></th>
<th><s:label value="更新日"/></th>
</tr>
</thead>

<!-- セッションからの表示項目 -->
<tbody>
<s:iterator value="#session.DestinationInfoAllDtoList">
<tr>
<td><s:property value="Id"/></td>
<td><s:property value="userId"/></td>
<td><s:property value="familyName"/></td>
<td><s:property value="firstName"/></td>
<td><s:property value="familyNameKana"/></td>
<td><s:property value="firstNameKana"/></td>
<td><s:property value="email"/></td>
<td><s:property value="telNumber"/></td>
<td><s:property value="userAddress"/></td>
<td><s:property value="registDate"/></td>
<td><s:property value="updateDate"/></td>
</tr>
</s:iterator>
</tbody>
</table>
</s:if>

<!-- 宛先情報の中身がなかった場合 -->
<s:else>
<div class="info">
宛先情報のデータはありません。
</div>
</s:else>


<h2>カテゴリーデータ</h2>
<!-- 宛先情報データがある時。 -->
<s:if test="#session.mCategoryAllDtoList.size() > 0">
<table class="horizontal-list-table">

<!-- カテゴリ情報の頭 -->
<thead>
<tr>
<th><s:label value="ID"/></th>
<th><s:label value="カテゴリID"/></th>
<th><s:label value="カテゴリ名"/></th>
<th><s:label value="カテゴリ名詳細"/></th>
<th><s:label value="登録日"/></th>
<th><s:label value="更新日"/></th>
</tr>
</thead>

<!-- セッションからの表示項目 -->
<tbody>
<s:iterator value="#session.mCategoryAllDtoList">
<tr>
<td><s:property value="Id"/></td>
<td><s:property value="categoryId"/></td>
<td><s:property value="categoryName"/></td>
<td><s:property value="categoryDescription"/></td>
<td><s:property value="insertDate"/></td>
<td><s:property value="updateDate"/></td>
</tr>
</s:iterator>
</tbody>
</table>
</s:if>


<h2>ユーザーデータ</h2>
<!-- ユーザーデータがある時 -->
<s:if test="#session.UserInfoAllDtoList.size() > 0">
<table class="horizontal-list-table">

<!-- ユーザー情報の頭 -->
<thead>
<tr>
<th><s:label value="ID"/></th>
<th><s:label value="ユーザーID"/></th>
<th><s:label value="パスワード"/></th>
<th><s:label value="姓"/></th>
<th><s:label value="名"/></th>
<th><s:label value="姓ふりがな"/></th>
<th><s:label value="名ふりがな"/></th>
<th><s:label value="性別"/></th>
<th><s:label value="ステータス"/></th>
<th><s:label value="ログインフラグ"/></th>
<th><s:label value="登録日"/></th>
<th><s:label value="更新日"/></th>
</tr>
</thead>

<!-- セッションからの表示項目 -->
<tbody>
<s:iterator value="#session.UserInfoAllDtoList">
<tr>
<td><s:property value="Id"/></td>
<td><s:property value="userId"/></td>
<td><s:property value="password"/></td>
<td><s:property value="familyName"/></td>
<td><s:property value="firstName"/></td>
<td><s:property value="familyNameKana"/></td>
<td><s:property value="firstNameKana"/></td>
<td><s:property value="sex"/></td>
<td><s:property value="status"/></td>
<td><s:property value="logined" /></td>
<td><s:property value="registDate"/></td>
<td><s:property value="updateDate"/></td>
</tr>
</s:iterator>
</tbody>
</table>
</s:if>

<div id="piston"></div>

</div>
<s:include value="footer.jsp"/>
</body>
</html>