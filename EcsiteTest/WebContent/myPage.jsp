<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<meta http-equiv="Content-Script-Type" content="text/javascript" />
		<meta http-equiv="imagetoolbar" content="no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>マイページ</title>
	</head>
	<body>

		<div id="header">
			<div id="pr">
			</div>
		</div>

		<div id="main">
			<div id="top">
				<p><h2>ようこそ、<s:property value="session.login_user_id" />さん！</h2><p>
			</div>

			<div>
				<p>商品購入は<a href='<s:url action="BuyItemAction" />'>こちら</a></p>
			</div>

			<div>
				<p>購入履歴は<a href='<s:url action="UserBuyInfoAction" />'>こちら</a></p>
			</div>

			<div>
				<s:form action="LogoutAction"><s:submit value="ログアウト" /></s:form>
			</div>

		</div>

		<div id="footer">
			<div id="pr">
			</div>
		</div>

	</body>
</html>