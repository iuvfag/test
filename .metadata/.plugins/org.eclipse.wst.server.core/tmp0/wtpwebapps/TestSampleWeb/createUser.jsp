<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">
		<link rel="stylesheet" href="./css/createUser.css">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


		<title>ユーザー情報入力</title>
	</head>
	<body>

		<!-- ヘッダー -->
		<jsp:include page="header.jsp" />
		<div id="contents">

			<div class="lock">

					<h1>ユーザー情報入力画面</h1>


					<!-- エラーメッセージがあれば表示したい -->
					<!-- まず姓 -->
					<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- 名 -->
					<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- 姓かな -->
					<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- 名かな -->
					<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- メールアドレス -->
					<s:if test="!#session.emailErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- ログインID -->
					<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- パスワード -->
					<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>


					<!-- ログインIDが使用されている場合はエラーメッセージ表示 -->
					<s:if test="!#session.duplicateList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.duplicateList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>



					<!-- ここから送信フォーム -->
		<section>

		    <s:form action="CreateUserConfirmAction" cssClass="form">
			      <div class="field name-box">
			      		<label class="defaultLabel">姓</label>
				        <s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓" class="txt" />
		        		<label class="accordion">半角英語、漢字、ひらがな 1文字以上16文字以下</label>
				        <span class="nice">Nice!</span>
			      </div>

			      <div class="field name-box">
			      		<label class="defaultLabel">名</label>
				        <s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名" class="txt" />
		        		<label class="accordion">半角英語、漢字、ひらがな 1文字以上16文字以下</label>
				        <span class="nice">Nice!</span>
			      </div>

			      <div class="field name-box">
			      		<label class="defaultLabel">姓ふりがな</label>
				        <s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt" />
		        		<label class="accordion">ひらがな 1文字以上16文字以下</label>
				        <span class="nice">Nice!</span>
			      </div>

			      <div class="field name-box">
			      		<label class="defaultLabel">名ふりがな</label>
				        <s:textfield name="firstNameKana" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt" />
		        		<label class="accordion">ひらがな 1文字以上16文字以下</label>
				        <span class="nice">Nice!</span>
			      </div>

			      	<table class="sexbox">
			      	<tr>
			      		<th scope="row" class="sexth">性別</th>
			      		<td class="sextd"><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}"  placeholder="性別" class="checkbox" /></td>
			      	</tr>
			      	</table>

			      <div class="field name-box">
			      		<label class="defaultLabel">メールアドレス</label>
				        <s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス" class="txt" />
		        		<label class="accordion">半角英数字、半角記号 14文字以上32文字以下</label>
				        <span class="nice">Nice!</span>
			      </div>

			      <div class="field name-box">
			      		<label class="defaultLabel">ログインID</label>
				        <s:textfield name="loginId" value="%{#session.loginId}" label="ログインID" placeholder="ログインID" class="txt" />
		        		<label class="accordion">半角英数字 1文字以上8文字以下</label>
				        <span class="nice">Nice!</span>
			      </div>

			      <div class="field name-box">
			      		<label class="defaultLabel">パスワード</label>
				        <s:password name="password" value="%{#session.password}" label="パスワード" placeholder="パスワード" class="txt" />
		        		<label class="accordion">半角英数字 1文字以上16文字以下</label>
				        <span class="nice">Nice!</span>
			      </div>
					<br><br><br>
							<!-- session内に格納された情報を表示
								すでに入力された情報があり、入力エラーなどでこのページに戻された際に
								再度入力する手間を省く -->

							<div class="submit_btn_box">
								<div id=".contents-btn-set">
									<s:submit value="登録" class = "submit_btn" />
								</div>
							</div>

					</s:form>

				</section>

			</div>

		</div>

		<s:include value="footer.jsp" />

	<script type="text/javascript" src="./js/form.js"></script>

	</body>
</html>