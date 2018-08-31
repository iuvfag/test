<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta charset=UTF-8>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/cart.css">
<title>カート</title>


<script type="text/javascript">
	/*
	 * document.getElementById()メソッドで()内のidを取得、
	 *().actionで取得した値を特定のタグに記載した形と同じように戻す
	 *.action以下で特定のアクションにアクセスして、実行させる
	 */

	function goDeleteCartAction() {
		document.getElementById("form").action = 'DeleteCartAction';
	}
</script>

</head>
<body>

	<s:if test="#session.token != null">
		<script type="text/javascript">
			var sessionTimeout = function() {
				location.href = "HomeAction"
			}
			setTimeout(sessionTimeout, 0)
		</script>
	</s:if>
	<s:else>


		<!-- ヘッダーとの関連付け -->
		<jsp:include page="header.jsp" />

		<!-- メインコンテンツの編集 -->
		<div id="contents">
			<h1>カート画面</h1>

			<!-- エラーメッセージがあるときは表示をする
				 メッセージそのものはsessionから取得 -->
			<s:if test="#session.checkListErrorMessageList != null">
				<div class="error_c">
					<div class="error-message">
						<s:iterator value="#session.checkListErrorMessageList">
							<s:property />
						</s:iterator>
					</div>
				</div>
			</s:if>

			<!-- カートの中身がある時 -->
			<s:if test="#session.cartInfoDtoList.size() > 0">
				<s:form id="form" action="LocationOptionAction">
					<table class="horizontal-list-table">

						<!-- テーブルの表題 -->
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

						<!-- 表示項目 -->
						<tbody>
							<s:iterator value="#session.cartInfoDtoList">
								<tr>
									<td><s:checkbox name="checkList" value="checked"
											fieldValue="%{id}" /></td>
									<s:hidden name="productId" value="%{productId}" />
									<td><s:property value="productName" /></td>
									<td><s:property value="productNameKana" /></td>
									<td><img
										src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
										width="50px" height="50px" /></td>
									<td><s:property value="price" />円</td>
									<td><s:property value="releaseCompany" /></td>
									<td><s:property value="releaseDate" /></td>
									<td><s:property value="productCount" /></td>
									<td><s:property value="subtotal" />円</td>
								</tr>

								<!-- 実際のデータの移動 -->
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
						</tbody>
					</table>

					<h2>
						<s:label value="カート合計金額 :" />
						<s:property value="#session.totalPrice" />
						円
					</h2>
					<br>

					<!-- 決済ボタン -->
					<div class="submit_btn_box_c">
						<div id=".contents-btn-set">
							<s:submit value="決済" class="submit_btn" />
						</div>
					</div>

					<!-- 削除ボタン -->
					<div class="submit_btn_box_c">
						<div id=".contents-btn-set">
							<s:submit value="削除" class="submit_btn"
								onclick="this.form.action='DeleteCartAction';" />
						</div>
					</div>

				</s:form>
			</s:if>

			<!-- カートの中身がなかった場合 -->
			<s:else>
				<div class="info_c">カートに情報はありません</div>
			</s:else>

<div id="piston"></div>
		</div>
	</s:else>

	<!-- フッターとの関連付け -->
	<s:include value="footer.jsp" />


</body>
</html>
