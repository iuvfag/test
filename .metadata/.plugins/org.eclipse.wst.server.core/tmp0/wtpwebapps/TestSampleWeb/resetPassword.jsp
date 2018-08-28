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
		<title>パスワード再設定</title>
	</head>
	<body>

	<!-- パスワード再設定のためのページ
		エラーがあればこのページに戻るため
		エラーメッセージの表示もする -->

		<jsp:include page="header.jsp" />
			<div id="contents">
				<h1>パスワード再設定画面</h1>
				<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.loginIdErrorMessageList"><s:property />
							<br></s:iterator>
						</div>
					</div>
				</s:if>

				<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.passwordErrorMessageList"><s:property />
							<br></s:iterator>
						</div>
					</div>
				</s:if>

				<s:if test="!#session.passwordIncorrectErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.passwordIncorrectErrorMessageList"><s:property />
							<br></s:iterator>
						</div>
					</div>
				</s:if>

				<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.newPasswordErrorMessageList"><s:property />
							<br></s:iterator>
						</div>
					</div>
				</s:if>

				<s:if test="!#session.reConfirmPasswordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.reConfirmPasswordErrorMessageList"><s:property />
							<br></s:iterator>
						</div>
					</div>
				</s:if>

				<s:if test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.newPasswordIncorrectErrorMessageList"><s:property />
							<br></s:iterator>
						</div>
					</div>
				</s:if>

				<!-- エラーメッセージがあれば表示 -->

			<section>

			    <s:form action="ResetPasswordConfirmAction" cssClass="form">

				      <div class="field">
				      		<label class="defaultLabel">ログインID</label>
					        <s:textfield name="loginId"  placeholder="ログインID" class="txt" />
			        		<label class="accordion">半角英数字 1文字以上8文字以下</label>
					        <span class="nice">Nice!</span>
				      </div>

				      <div class="field">
				      		<label class="defaultLabel">現在のパスワード</label>
					        <s:password name="password"  placeholder="現在のパスワード" class="txt" />
			        		<label class="accordion">半角英数字 1文字以上16文字以下</label>
					        <span class="nice">Nice!</span>
				      </div>

				      <div class="field">
				      		<label class="defaultLabel">新しいパスワード</label>
					        <s:password name="newPassword"  placeholder="新しいパスワード" class="txt" />
			        		<label class="accordion">半角英数字 1文字以上16文字以下</label>
					        <span class="nice">Nice!</span>
				      </div>

				      <div class="field">
				      		<label class="defaultLabel">（再確認用）</label>
					        <s:password name="reConfirmationPassword"  placeholder="新しいパスワード（再確認用）" class="txt" />
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
			<s:include value="footer.jsp" />
			<script type="text/javascript" src="./js/form.js"></script>
	</body>
</html>