<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>マイページ</title>
	</head>
	<body>

	<!-- 登録者情報を表示
		また、購入情報へのリンク機能も実装する -->

		<jsp:include page="header.jsp" />
		<div id="contents">
			<h1>マイページ画面</h1>

			<s:form action="PurchaseHistoryAction">
				<table class="vertical-list-table">
					<tr>
						<th scope="row"><s:label value="姓" /></th>
						<td><s:property value="#session.familyName" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="名" /></th>
						<td><s:property value="#session.firstName" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="ふりがな" /></th>
						<td><s:property value="#session.familyNameKana"/><span>　</span><s:property value="#session.firstNameKana" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="性別" /></th>
						<td><s:if test="#session.sex==0">男性</s:if><s:if test="#session.sex==1">女性</s:if></td>

						<!-- 性別に関してはDB上では0か1で管理しているため、
							ここでも0か1かで性別を判別する -->

					</tr>

					<tr>
						<th scope="row"><s:label value="メールアドレス" /></th>
						<td><s:property value="#session.email" /></td>
					</tr>

				</table>
				<div class="submit_btn_box">
					<s:submit value="購入履歴" class="submit_btn" />
				</div>

			</s:form>

		</div>

		<s:include value="footer.jsp" />

	</body>
</html>