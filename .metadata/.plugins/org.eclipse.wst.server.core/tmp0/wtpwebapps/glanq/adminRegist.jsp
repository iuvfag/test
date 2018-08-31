<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <sx:head cache="false" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" >
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/admin.css">
<title>商品登録・追加</title>
</head>

<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>商品登録・追加画面</h1>

<s:if test="!#session.productNameErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.productNameErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.productNameKanaErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.productNameKanaErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.productDescriptionErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.productDescriptionErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.priceErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.priceErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.releaseCompanyErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.releaseCompanyErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<s:if test="!#session.releaseDateErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.releaseDateErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>
<!-- 画像が入ってない場合でもエラーが出るように -->
<s:if test="!#session.userImageFileNameErrorMessageList.isEmpty()">
    <div class="error">
    <div class="error-message">
        <s:iterator value="#session.userImageFileNameErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>

<script>
document.getElementsByName("releaseDate").value = "1970/01/01";
document.getElementsByName("dojo.releaseDate").value = "1970/01/01";
</script>

<s:form action="AdminRegistConfirmAction" method="post" enctype="multipart/form-data">

<table class="vertical-list-table">
<tr>
    <th scope="row">商品カテゴリ</th>
    <td>○既存のカテゴリーから選択 <s:select name="categoryId" list="%{#session.mCategoryDtoList}" listValue="categoryName" listKey="categoryId" class="cs-div" id="categoryId" /><br>

<tr>
    <th scope="row">商品名</th>
    <td><s:textfield name="productName" value="%{#session.productName}" label="商品名" placeholder="商品名" class="txt"/></td>
</tr>
<tr>
    <th scope="row">商品名ふりがな</th>
    <td><s:textfield name="productNameKana" value="%{#session.productNameKana}" label="商品名ふりがな" placeholder="商品名ふりがな" class="txt"/></td>
</tr>
<tr>
    <th scope="row">商品詳細</th>
    <td><s:textarea name="productDescription" value="%{#session.productDescription}" label="商品詳細" placeholder="商品詳細"  class="area"/></td>
</tr>
<tr>
    <th scope="row">価格</th>
    <td><s:textfield name="price" value="%{#session.price}" label="価格" placeholder="価格" class="txt"/></td>
</tr>
<tr>
    <th scope="row">発売会社名</th>
    <td><s:textfield name="releaseCompany" value="%{#session.releaseCompany}" label="発売会社名" placeholder="発売会社名" class="txt"/></td>
</tr>
<tr>
    <th scope="row">発売年月日</th>
    <!--<s:textfield name="releaseDate" value="%{#session.releaseDate}" label="発売年月日" placeholder="発売年月日" class="txt"/></td> -->
   <td><sx:datetimepicker name="releaseDate"  displayFormat="yyyy/MM/dd"  /><span class="Description">【XXXX/XX/XXのフォーマットで入力してください。】</span></td>
</tr>
<!-- value="%{#session.releaseDate}" -->
<tr>
    <th scope="row">画像ファイル</th>
    <td><s:file name="userImage" label="画像ファイル" placeholder="画像ファイル" class="file"/></td>
</tr> <!-- 画像は選べるようになったが、　この情報をどう送るのかが不明である。 -->

</table>


<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="登録確認画面へ" class="submit_btn" />
</div>
</div>
</s:form>
<div id="piston"></div>
</div>


    <s:include value="footer.jsp" />

</body>
</html>