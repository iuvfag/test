<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>宛先情報完了</title>
<meta http-equiv="refresh" content="3;URL='SettlementConfirmAction'"/> <!-- 3秒後、自動的にホーム画面へ遷移 -->
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>宛先情報完了画面</h1>

<!-- 完了画面表示 -->
<div class="success">
<div>
	<img class = "kusa" src= "images/kusa.svg">
	<img class = "ushi" src= "images/ushi.svg">
	<img class = "kusa" src= "images/kusa.svg">
</div>
<p>宛先情報の登録が完了しました。</p>
</div>
<div id="piston"></div>
</div>

<s:include value="footer.jsp"/>


</body>
</html>