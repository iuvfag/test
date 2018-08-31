<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>locationChoice</title>
<link rel="stylesheet" type="text/css" href="css/location.css"/>
</head>
<body>
<!-- ヘッダーをインクルード -->
<jsp:include page="header.jsp" />

<div id="contents">

  <h1>locationChoice画面</h1>

  <!-- とりあえずで作ったからレイアウトは許してほしい -->
 <s:iterator value="#session.destinationInfoDtoList" status="st">
  <div class="location_table_box">


      <table class="location_table">
          <tr>
              <td rowspan="7">
              <s:form class="img_button2" action="LocationChoiceConfirmAction">
                  <s:hidden name="parkId" value="%{id}"/>
                  <s:hidden name="firstName" value="%{firstName}"/>
                  <s:hidden name="firstNameKana" value="%{firstNameKana}"/>
                  <s:hidden name="familyName" value="%{familyName}"/>
                  <s:hidden name="familyNameKana" value="%{familyNameKana}"/>
                  <s:hidden name="email" value="%{email}"/>
                  <s:hidden name="telNumber" value="%{telNumber}"/>
                  <s:hidden name="userAddress" value="%{userAddress}"/>
                  <s:submit type="image" src="./images/bbq%{id}.jpg">
                      <div class="mask">
                          <s:if test="id==1"><div class="caption">家族と</div></s:if>
                          <s:if test="id==2"><div class="caption">友達と</div></s:if>
                          <s:if test="id==3"><div class="caption">恋人と</div></s:if>
	                  </div>
	              </s:submit>
	          </s:form>
              </td>
              <td class="description">会場名</td>
              <td class="property"><s:property value="firstName"/></td>
          </tr>
          <tr>
              <td>会場名かな</td>
              <td><s:property value="firstNameKana"/></td>
          </tr>
          <tr>
              <td>会社名</td>
              <td><s:property value="familyName"/></td>
          </tr>
          <tr>
              <td>会社名かな</td>
              <td><s:property value="familyNameKana"/></td>
          </tr>
          <tr>
              <td>メールアドレス</td>
              <td><s:property value="email"/></td>
          </tr>
          <tr>
              <td>電話番号</td>
              <td><s:property value="telNumber"/></td>
          </tr>
          <tr>
              <td>住所</td>
              <td><s:property value="userAddress"/></td>
          </tr>
      </table>

  </div>
</s:iterator>
<div id="piston"></div>
</div>
<!-- フッターをインクルード -->
<jsp:include page="footer.jsp" />
</body>
</html>