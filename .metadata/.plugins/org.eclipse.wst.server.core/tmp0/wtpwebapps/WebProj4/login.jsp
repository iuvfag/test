<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/style.css">
		<title>LOGIN</title>
	</head>
	<body>

		<s:property value="LoginDTOList.get(0).username"/>さん、ようこそ！
		<!-- 今回の場合、Listに代入される組み合わせは
			index(0)に「username」と「password」というひとつのみであり、
			値を取り出したい場合に指定するindexも(0)である -->

		<br>
		<table>

			<tbody>
				<tr>
					<th>USERNAME</th>
					<th>PASSWORD</th>
				</tr>
				<tr>
					<s:iterator value="loginDTOList">
					<!-- 今回Listに代入された要素を取得 -->

					<td><s:property value="username" /></td>
					<td><s:property value="password" /></td>
					</s:iterator>
				</tr>
			</tbody>

		</table>

	</body>
</html>