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
<title>登録内容確認</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>登録内容確認画面</h1>
<s:form action="AdminRegistCompleteAction">
<table class="vertical-list-table">
<tr>
    <th scope="row"><s:label value="商品カテゴリ"/></th>
    <td><s:property value="#session.categoryName" /></td>
</tr>
<tr>
    <th scope="row"><s:label value="商品名"/></th>
    <td><s:property value="productName"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="商品名ふりがな"/></th>
    <td><s:property value="productNameKana"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="商品詳細"/></th>
    <td><div id="description"><s:property value="productDescription"/></div></td>
</tr>
<tr>
    <th scope="row"><s:label value="価格"/></th>
    <td><s:property value="price"/><span>円</span></td>
</tr>
<tr>
    <th scope="row"><s:label value="発売会社名"/></th>
    <td><s:property value="releaseCompany"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="発売年月日"/></th>
    <td><s:property value="releaseDate"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="画像ファイル名"/></th>
    <td><s:property value="userImageFileName"/></td>
</tr>
<tr>
    <th scope="row"><s:label value="画像ファイル"/></th>
    <!--  imagesの場所がフォルダの名前で　userImageFileNameで～～.jpgを入れている。 -->
    <td><img src="images/<s:property value="userImageFileName"/>" width="500" height="300" /></td>
</tr>

</table>
<div class="submit_btn_box">
<div id="./contents-btn-set">
<s:submit value="登録" class="submit_btn"/>
</div>
</div>
<s:hidden name="productName" value="%{productName}"/>
<s:hidden name="productNameKana" value="%{productNameKana}"/>
<s:hidden name="productDescription" value="%{productDescription}"/>
<s:hidden name="price" value="%{price}"/>
<s:hidden name="imageFileName" value="%{imageFileName}"/>
<s:hidden name="imageFilePath" value="%{imageFilePath}"/>
<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
<s:hidden name="releaseDate" value="%{releaseDate}"/>

</s:form>
<div id="piston"></div>
</div>




    <s:include value="footer.jsp"/>


</body>
</html>