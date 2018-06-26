<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- s:タグとは、strutsフレームワークで使える専用のHTMLタグ -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン画面</title>
	</head>
	<body>
		<s:form action="LoginAction">
		<!-- s:formで囲まれたタグに入力された情報が「action=""」で指定された
			 「action」クラスへ渡される -->
			<s:textfield name="name"/>
			<s:password name="password"/>
			<s:submit value="ログイン"/>
			<!-- name属性の情報とactionクラスのフィールドメソッド名が紐づいて情報を渡す
				 inputタグ、「type="text"」「type="pasword"」「type="submit"」
				 としてブラウザで認識
				 「/」を忘れないように-->
		</s:form>
		<!-- formタグとしてブラウザが認識 -->
	</body>
</html>