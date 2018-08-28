<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSTL(Java Server Page Tag Library)を利用するため呼び出す
	一般的によく利用されるカスタムタグをまとめ配布されているもの -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="refresh" content="0;url='HomeAction'" />
		<!-- リダイレクト機能
			ユーザーを指定のサイトに飛ばすことが出来る
			用法は
			<meta http-equiv="refresh" content="秒数;url=URL">
		 -->

		<link rel="stylesheet" href="./css/style.css">
		<title>testsampleweb</title>
	</head>
	<body>

		<div id="footer">
			<s:include value="footer.jsp" />
			<!-- JSPから他のJSPなどを呼び出すことができる
				ファイル指定はCSSなどと一緒 -->

		</div>

	</body>
</html>