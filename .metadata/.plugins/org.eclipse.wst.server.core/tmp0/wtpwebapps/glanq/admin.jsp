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
<title>管理者ホーム画面</title>
</head>
<body>
 <jsp:include page="header.jsp"/>
<div id="contents">
<h1>管理者ホーム画面</h1>

<!--  ここでボタンを五つ作成しています。 -->
<!--  商品追加・変更・削除・商品一覧・購入履歴一覧の五つのボタンです。 -->
<!--  classとidはボタンは同じにします。 -->
<div class="colorbox">
<div class="submit_btn_box1">
    <div id=".contents-btn-set">
    <s:form action="AdminRegistAction">
        <s:submit value="商品追加画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>


<div class="submit_btn_box1">
    <div id=".contents-btn-set">
    <s:form action="AdminEditAction">
        <s:submit value="商品更新・編集画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>

<div class="submit_btn_box1">
    <div id=".contents-btn-set">
    <s:form action="AdminDeleteAction">
        <s:submit value="商品削除画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>

<div class="submit_btn_box1">
    <div id=".contents-btn-set">
    <s:form action="AdminProductSelectAction">
        <s:submit value="商品一覧画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>

<div class="submit_btn_box1">
    <div id=".contents-btn-set">
    <s:form action="AdminPurchaseSelectAction">
        <s:submit value="購入履歴一覧画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>

<div class="submit_btn_box1">
    <div id=".contents-btn-set">
    <s:form action="AdminAllSelectAction">
        <s:submit value="データ確認画面" class="submit_btn2"/>
    </s:form>
    </div>
</div>
</div>
<div id="piston"></div>
</div>

<s:include value="footer.jsp"/>




</body>
</html>