<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<title>カート</title>

		<script type="text/javascript">

		function goDeleteCartAction(){
			document.getElementById("form").action='DeleteCartAction';
			/* getElementByIdは任意のHTMLタグで指定したIDにマッチする
			ドキュメント要素を取得するメソッド
			 今回はそのID「form」にアクションを指定し、
			 「DeleteCartAction」を呼び出している*/
		}

		</script>

	</head>
	<body>

		<!-- このページでは
			①カートに商品がなければそのメッセージを表示
			②カートに商品があればそれを表示
			が主な役割
			if文で条件分岐させよう -->

		<jsp:include page="header.jsp" />
		<div id="contents">
			<h1>カート画面</h1>
			<s:if test="#session.checkListErrorMessageList != null">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.checkListErrorMessageList"><s:property /></s:iterator>
					</div>
				</div>
			</s:if>

			<!-- エラーメッセージに何か登録されていれば表示する
				今後もよく出てくるよ -->

		<s:if test="#session.cartInfoDTOList.size()>0">
			<s:form id="form" action="SettlementConfirmAction">
				<table class="horizontal-list-table">
					<thead>
						<tr>
							<th><s:label value="#" /></th>
							<th><s:label value="商品名" /></th>
							<th><s:label value="ふりがな" /></th>
							<th><s:label value="商品画像" /></th>
							<th><s:label value="値段" /></th>
							<th><s:label value="発売会社名" /></th>
							<th><s:label value="発売年月日" /></th>
							<th><s:label value="購入個数" /></th>
							<th><s:label value="合計金額" /></th>
						</tr>
					</thead>

					<tbody>
						<s:iterator value="#session.cartInfoDTOList">
							<tr>
								<td><s:checkbox name="checkList" value="checked" fieldValue="%{id}" /></td>
								<s:hidden name="productId" value="%{productId}" />
								<!-- このcheckListはどの商品が選択されたかをJavaファイルに送り
									判別するためのもの
									今回はDeleteCartActionクラスに送るものを判別するため使用
									hiddenでproductIdも渡しておく
									fieldValueは出力されるvalueの属性に反映されるもので
									今回はidとしておく -->

								<td><s:property value="productName" /></td>
								<td><s:property value="productNameKana" /></td>
								<td><img src='<s:property value="imageFilePath" />/<s:property value="imageFileName" />' width="50px" height="50px" /></td>
								<td><s:property value="price"/>円</td>
								<td><s:property value="releaseCompany"/></td>
								<td><s:property value="releaseDate" /></td>
								<td><s:property value="productCount" /></td>
								<td><s:property value="subtotal" />円</td>
							</tr>

							<s:hidden name="productName" value="%{productName}" />
							<s:hidden name="productNameKana" value="%{productNameKana}" />
							<s:hidden name="imageFilePath" value="%{imageFilePath}" />
							<s:hidden name="imageFileName" value="%{imageFileName}" />
							<s:hidden name="price" value="%{price}" />
							<s:hidden name="releaseCompany" value="%{releaseCompany}" />
							<s:hidden name="releaseDate" value="%{releaseDate}" />
							<s:hidden name="productCount" value="%{productCount}" />
							<s:hidden name="subtotal" value="%{subtotal}" />

						</s:iterator>
						<!-- カートに入っている商品をiteratorですべて表示する
							商品情報はhiddenで渡しておく
							さもないと#sessionに値が渡せないよ -->
					</tbody>
				</table>

				<h2><s:label value="カート合計金額：" /><s:property value="#session.totalPrice" />円</h2><br>
				<div class="submit_btn_box">
					<div id=".contents-btn-set">
						<s:submit value="決済" class="submit_btn" />
					</div>
				</div>

				<div class="submit_btn_box">
					<div id=".contents-btn-set">
						<s:submit value="削除" class="submit_btn" onclick="this.form.action='DeleteCartAction';" />
						<!-- このsubmitを押すことでactionを呼び出し -->
					</div>
				</div>
			</s:form>
		</s:if>

		<s:else>
			<div class="info">
				カート情報はありません。
			</div>
		</s:else>

		</div>

		<div id="footer">
			<s:include value="footer.jsp" />
		</div>

	</body>
</html>