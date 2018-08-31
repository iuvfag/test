<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
        <title>ヘッダー</title>

<script type="text/javascript">

    var sessionTimeout = function() {
    	location.href = "TimeoutAction"
    }
    setTimeout(sessionTimeout, 600000)

</script>

<script>
function goAdminRegistAction(){
	document.getElementById("form").action="AdminRegistAction";
}
function goAdminEditAction(){
	document.getElementById("form").action="AdminEditAction";
}
function goAdminDeleteAction(){
	document.getElementById("form").action="AdminDeleteAction";
}
function goAdminProductSelectAction(){
	document.getElementById("form").action="AdminProductSelectAction";
}
function goAdminPurchaseSelectAction(){
	document.getElementById("form").action="AdminPurchaseSelectAction";
}
function goAdminAllSelectAction(){
	document.getElementById("form").action="AdminAllSelectAction";
}
function goLoginAction(){
	document.getElementById("form").action="GoLoginAction";
}
function goMyPageAction(){
	document.getElementById("form").action="MyPageAction";
}
function goCartAction(){
	document.getElementById("form").action="CartAction";
}
function goProductListAction(){
	document.getElementById("categoryId").value=1;
	document.getElementById("form").action="ProductListAction";
}
function goLogoutAction(){
	document.getElementById("form").action="LogoutAction";
}
function goSearchItemAction(){
	document.getElementById("form").action="SearchItemAction";
}
function goAdminAction(){
	document.getElementById("form").action="GoAdminAction";
}
</script>
<style type="text/css">
.headerLogo:link { color:#96e6a1; text-decoration:none }
.headerLogo:visited { color:#96e6a1; text-decoration:none }
.headerLogo:hover { color:#96e6a1; text-decoration:none }
.headerLogo:active { color:#96e6a1; text-decoration:none }
</style>

</head>

<body>
<header>
  <div id="header">
       <div id="header-title">
       <s:if test="#session.status==1"><a class="headerLogo" href="GoAdminAction">GLANQ</a></s:if>
       <s:else><a class="headerLogo" href="HomeAction">GLANQ</a></s:else>
       </div>

       <input type="checkbox" class="check" id="checked">
	          <label class="menu-btn" for="checked">
		             <span class="bar top"></span>
		             <span class="bar middle"></span>
		             <span class="bar bottom"></span>
		             <span class="menu-btn__text">MENU</span>
	          </label>
	          <label class="close-menu" for="checked"></label>
	<nav class="drawer-menu">
		<ul>
            <s:form id="form" name="form">
                    <s:if test="#session.status==1">
                          <li><s:submit value="管理者ホーム" class="header_btn" onclick="goAdminAction();"/></li>
                          <li><s:submit value="商品追加画面" class="header_btn" onclick="goAdminRegistAction();"/></li>
                          <li><s:submit value="商品更新・編集画面" class="header_btn" onclick="goAdminEditAction();"/></li>
                          <li><s:submit value="商品削除画面" class="header_btn" onclick="goAdminDeleteAction();"/></li>
                          <li><s:submit value="商品一覧画面" class="header_btn" onclick="goAdminProductSelectAction();"/></li>
                          <li><s:submit value="購入履歴画面" class="header_btn" onclick="goAdminPurchaseSelectAction();"/></li>
                          <li><s:submit value="データ確認画面" class="header_btn" onclick="goAdminAllSelectAction();"/></li>
                    </s:if>
                    <s:if test='#session.containsKey("mCategoryDtoList") && #session.status!=1'>
                          <li><s:select name="categoryId" list="#session.mCategoryDtoList" listValue="categoryName" listKey="categoryId" class="cs-div" id="categoryId"/></li>
                    </s:if>
                    <s:if test="#session.logined==0 || #session.status==0">
                          <li><s:textfield name="keywords" class="txt-keywords" placeholder="検索ワード" />
                    <s:submit value="検索" class="header_search_btn" onclick="goSearchItemAction();"/></li>
                    </s:if>
                    <s:if test="#session.logined==1">
                          <li><s:submit value="ログアウト" class="header_btn" onclick="goLogoutAction();"/></li>
                    </s:if>
                    <s:else>
                          <li><s:submit value="ログイン" class="header_btn" onclick="goLoginAction();"/></li>
                    </s:else>
                    <s:if test="#session.logined==0 || #session.status==0">
                          <li><s:submit value="カート" class="header_btn" onclick="goCartAction();"/></li>
                          <li><s:submit value="商品一覧" class="header_btn" onclick="goProductListAction();"/></li>
                    </s:if>
                    <s:if test="#session.logined==1 && #session.status==0">
                          <li><s:submit value="マイページ" class="header_btn" onclick="goMyPageAction();"/></li>
                    </s:if>
            </s:form>
        </ul>
	</nav>
         <div id="menu-background"></div>
         </div>
</header>
</body>
</html>