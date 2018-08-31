<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>locationOption</title>
<link rel="stylesheet" type="text/css" href="css/location.css"/>
<script src="./js/test.js"></script>
</head>
<body>
<!-- ヘッダーをインクルード -->
<jsp:include page="header.jsp" />

<div id="contents">

  <h1>locationOption画面</h1>

  <!-- 自宅に配送かBBQ場に配送かを選ぶ -->
  <!-- 自宅を選択した場合、SettlementConfirmActionに飛ぶ   -->
  <!-- BBQ場を選択した場合、LocationChoiceActionに飛ぶ -->

  <p>自宅に配送するか、提携しているBBQ場へ直接配送するかを選択できます。</p>



  <div id="fadein_container">
    <div class="img_button">

      <s:form action="SettlementConfirmAction">

	    <s:submit type="image" src="./images/zitaku.jpg">
	        <div class="mask">
	            <div class="caption">自宅に配送</div>
	        </div>
	    </s:submit>

	  </s:form>

	</div>

	<div class="img_button">

      <s:form action="LocationChoiceAction">

	    <s:submit type="image" src="./images/bbqzyo_btn.jpg">
	        <div class="mask">
	            <div class="caption">BBQ場に配送</div>
	        </div>
	    </s:submit>

	  </s:form>

	</div>

  </div>

<div id="piston"></div>
</div>

<!-- フッターをインクルード -->
<jsp:include page="footer.jsp" />
</body>
</html>