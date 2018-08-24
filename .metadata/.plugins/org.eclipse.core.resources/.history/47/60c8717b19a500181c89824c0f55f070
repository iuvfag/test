<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/createUser.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>宛先情報入力</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<h1>宛先情報入力画面</h1>
<!--  姓入力エラー -->
<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
    <div class="error">
        <div class="error-message">
            <s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
        </div>
    </div>
</s:if>
<!-- 名前入力エラー -->
<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
     <div class="error">
         <div class="error-message">
             <s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
         </div>
     </div>
</s:if>
<!-- 姓かな入力エラー -->
<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
     <div class="error">
         <div class="error-message">
             <s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
         </div>
     </div>
</s:if>
<!-- 名前かな入力エラー -->
<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
     <div class="error">
         <div class="error-message">
             <s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
         </div>
     </div>
</s:if>
<!-- メールアドレス入力エラー -->
<s:if test="!#session.emailErrorMessageList.isEmpty()">
     <div class="error">
          <div class="error-message">
              <s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
          </div>
     </div>
</s:if>
<!-- 電話番号入力エラー -->
<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
     <div class="error">
         <div class="error-message">
             <s:iterator value="#session.telNumberErrorMessageList"><s:property /><br></s:iterator>
         </div>
     </div>
</s:if>
<!-- 住所入力エラー -->
<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
     <div class="error">
         <div class="error-message">
             <s:iterator value="#session.userAddressErrorMessageList"><s:property /><br></s:iterator>
         </div>
     </div>
</s:if>

<section>

    <s:form action="CreateDestinationConfirmAction" cssClass="form">

	      <!-- 姓入力 -->
	      <div class="field name-box">
	      		<label class="defaultLabel">姓</label>
		        <s:textfield name="familyName"  label="姓" placeholder="姓" class="txt" />
        		<label class="accordion">半角英語、漢字、ひらがな 1文字以上16文字以下</label>
		        <span class="nice">Nice!</span>
	      </div>

	      <!-- 名入力 -->
	      <div class="field name-box">
	      		<label class="defaultLabel">名</label>
		        <s:textfield name="firstName"  label="名" placeholder="名" class="txt" />
        		<label class="accordion">半角英語、漢字、ひらがな 1文字以上16文字以下</label>
		        <span class="nice">Nice!</span>
	      </div>

	      <!-- 姓ふりがな入力 -->
	      <div class="field name-box">
	      		<label class="defaultLabel">姓ふりがな</label>
		        <s:textfield name="familyNameKana"  label="姓ふりがな" placeholder="姓ふりがな" class="txt" />
        		<label class="accordion">ひらがな 1文字以上16文字以下</label>
		        <span class="nice">Nice!</span>
	      </div>

	      <!-- 名ふりがな入力 -->
	      <div class="field name-box">
	      		<label class="defaultLabel">名ふりがな</label>
		        <s:textfield name="firstNameKana"  label="名ふりがな" placeholder="名ふりがな" class="txt" />
        		<label class="accordion">ひらがな 1文字以上16文字以下</label>
		        <span class="nice">Nice!</span>
	      </div>

	      	<!-- 性別入力 -->
	      	<table class="sexbox">
	      	<tr>
	      		<th scope="row" class="sexth">性別</th>
	      		<td class="sextd"><s:radio name="sex" list="sexList" value="defaultSexValue"  placeholder="性別" class="checkbox" /></td>
	      	</tr>
	      	</table>

	      <!-- 住所入力 -->
	      <div class="field name-box">
	      		<label class="defaultLabel">住所</label>
		        <s:textfield name="userAddress"  label="住所" placeholder="住所" class="txt" />
        		<label class="accordion">半角英数字、漢字、ひらがな、カタカナ、半角記号 15文字以上50文字以下</label>
		        <span class="nice">Nice!</span>
	      </div>

	      <!-- 電話番号入力 -->
	      <div class="field name-box">
	      		<label class="defaultLabel">電話番号</label>
		        <s:textfield name="telNumber"  label="電話番号" placeholder="電話番号" class="txt" />
        		<label class="accordion">半角数字のみ 10文字以上13文字以下</label>
		        <span class="nice">Nice!</span>
	      </div>

	      <!-- メールアドレス入力 -->
	      <div class="field name-box">
	      		<label class="defaultLabel">メールアドレス</label>
		        <s:textfield name="email"  label="メールアドレス" placeholder="メールアドレス" class="txt" />
        		<label class="accordion">半角英数字、半角記号 14文字以上32文字以下</label>
		        <span class="nice">Nice!</span>
	      </div>

					<!-- 宛先情報確認ボタン -->
					<div class="submit_btn_box">
						<div id=".contents-btn-set">
							<s:submit value="登録" class="submit_btn" />
						</div>
					</div>

			</s:form>

		</section>
</div>

<s:include value="footer.jsp"/>
	<script type="text/javascript" src="./js/form.js"></script>
</body>
</html>