<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Success: Upload User Image</title>
	</head>
	<body>

		<div id="contents">
			<h2>アップロード画像</h2>
			画像:<s:property value="userImage" /><br>
			Content Type:<s:property value="userImageContentType" />
			ファイル名：<s:property value="userImageFileName" />
			画像イメージ:<img src='userImages/<s:property value="userImageFileName" />' width="100" height="100" />
		</div>

		<div id="footer">
			<s:include value="footer.jsp" />
		</div>

	</body>
</html>