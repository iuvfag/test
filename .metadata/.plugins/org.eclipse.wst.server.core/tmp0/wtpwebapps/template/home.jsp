<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Style-Type" content="text/css" />
		<!-- cssを使用したい場合に記入するタグ -->

		<meta http-equiv="Content-Script-Type" content="text/javascript" />
		<!-- javascriptを使用したい場合に記入するタグ -->

		<meta http-equiv="imagetoolbar" content="no" />
		<!-- イメージツールバーの有効、無効を指定
			IE6にて採用されたシステムで、 文章中の画像に
			マウスポインタを覆わせると小さなツールバーが出てくる
			というもの
			IE6で廃止された-->

		<meta name="description" content="" />
		<!-- 検索エンジンに対してホームページの内容紹介を表記しておく場合に使う
			content=""の中にホームページの照会文を書く -->

		<meta name="keywords" content="" />
		<!-- 検索エンジンの検索のキーワードとして使用される
			カンマ区切りで複数記入も可能
			content=""内に検索キーワードを書く -->

		<title>Home画面</title>

		<style type="text/css">
		/* この文でcssが利用可能 */

			/* ========TAG LAYOUT ======== */
			body{
			margin: 0;
			padding: 0;
			line-height: 1.6;
			letter-spacing: 1px;
			font-family: Vardana, Helvetica, sans-serif;
			font-size: 12px;
			color: #333;
			background: #fff;
			}

			table{
			text-align: center;
			margin: 0 auto;
			}

			/* ========ID LAYOUT======== */
			#top{
			width: 780px;
			margin: 30px auto;
			border: 1px solid #333;
			}

			#header{
			width: 100%;
			height: 80px;
			background-color: black;
			}

			#main{
			width: 100%;
			height: 500px;
			text-align: center;
			}

			#footer{
			width: 100%;
			height: 80px;
			background-color: black;
			clear: both;
			}

		</style>
	</head>
	<body>

		<div id="header">
			<div id="pr">
			</div>
		</div>

		<div id="main">
			<div id="top">
				<p>Home</p>
			</div>

			<div>
				<s:form action="HomeAction">
					<s:submit value="商品購入" />
				</s:form>
			</div>
		</div>

		<div id="footer">
			<div id="pr">
			</div>
		</div>

	</body>
</html>