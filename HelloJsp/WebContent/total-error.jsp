<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問題が発生しました！</title>
</head>
<body>
<!-- 数値が入力されないなどエラーが起きた際に表示されるページ -->

	<%@page isErrorPage="true" %>
		<!--
		isErrorPageを指定することで、このページに来る前に発生した
		例外をexceptionで受け取ることができるようになる
	 	-->

	<p>数値を入力してください</p>
	<button onclick="history.back()">戻る</button>
	<!-- history.back＝「前のページに戻るhtmlのメソッド」 -->

	<br>

	<p><%= exception %></p>
	<table border=1>

	<tr>
		<td><strong>エラーメッセージ</strong></td>
		<td><%= exception.getMessage() %><td>
		<!-- 例外を受け取るメソッド.printStackTraceよりもシンプル -->
	</tr>

	<tr>
		<td><strong>例外を文字列に変換</strong></td>
		<td><%= exception.toString() %></td>
		<!-- 例外を文字列にして返すメソッド -->
	</tr>

	<tr>
		<td><strong>スタックトレース</strong></td>
		<td>
			<%
				exception.printStackTrace(new PrintWriter(out));
			%>
			<!-- printStackTraceで出力される文字列を取得するためのメソッド -->

		</td>
	</tr>
	</table>

</body>
</html>