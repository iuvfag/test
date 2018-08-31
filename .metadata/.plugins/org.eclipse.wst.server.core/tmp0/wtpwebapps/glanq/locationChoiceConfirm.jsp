<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ロケーション場所確認</title>
<link rel="stylesheet" type="text/css" href="css/location.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="contents">

    <h1>ロケーション場所確認画面</h1>

    <!-- 場所を確認し、完了にするのか場所を選択し直すのかボタンを追加する -->
    <!-- 以前から入っているsession情報を読み込ませ、内容を表示させる。 -->
    <div id="fadein_container">

    <s:form action="SettlementCompleteAction">

    <table class="location_table">

    <tr>
        <td rowspan="7">
        <s:if test="parkId==1"><img src="./images/bbq1.jpg"></s:if>
        <s:if test="parkId==2"><img src="./images/bbq2.jpg"></s:if>
        <s:if test="parkId==3"><img src="./images/bbq3.jpg"></s:if>

        </td>
        <td><s:property value="familyName"/></td>
    </tr>
    <tr>
        <td><s:property value="firstName"/></td>
    </tr>
    <tr>
        <td><s:property value="familyNameKana"/></td>
    </tr>
    <tr>
        <td><s:property value="firstNameKana"/></td>
    </tr>
    <tr>
        <td><s:property value="email"/></td>
    </tr>
    <tr>
        <td><s:property value="telNumber"/></td>
    </tr>
    <tr>
        <td><s:property value="userAddress"/></td>
    </tr>
    </table>
    <s:hidden name="id" value="%{parkId}"/>
    <br><br>

    <s:submit value="決済" class="submit_btn"/>
    </s:form>

<h2>やり直したい方はこちら</h2>
    <s:form action="LocationChoiceAction">
    <s:submit value="場所選択画面へ" class="submit_btn"/>
    </s:form>
    </div>
<div id="piston"></div>
</div>

<s:include value="footer.jsp"/>
</body>
</html>