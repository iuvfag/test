<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%! static int countA=0;%>

	<%
		int countB=0;
	countA++;
	countB++;
	%>

	<p>宣言による変数 countA=<%= countA %></p>
	→更新するたびに増えていく<br>
	始めてリクエストがあったときに一度だけ呼び出されるため、<br>
	その後のリクエストにおいても変数の値は変化することはなく<br>
	JSPコンテナ（Tomcatなど）を再起動するまで値が保持される。

	<p>スクリプトレットによる変数countB=<%= countB %></p>
	→更新しても変化なし<br>
	スクリプトレッドで宣言された変数はリクエストのたびに呼び出されるため、<br>
	その後リクエストがあるたびに変数の値が初期化される

</body>
</html>