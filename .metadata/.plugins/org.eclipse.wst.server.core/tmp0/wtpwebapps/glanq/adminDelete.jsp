<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/admin.css">
<title>商品削除画面</title>
</head>

<body>
<jsp:include page="header.jsp"/>

<div id="contents">
       <h1>削除画面</h1>

<s:if test="#session.checkListErrorMessageList != null">
    <div class="error_c">
    <div class="error-message">
        <s:iterator value="#session.checkListErrorMessageList"><s:property /><br></s:iterator>
    </div>
    </div>
</s:if>

<s:if test="productInfoDtoList==null">
       <div class="info">商品がありません。</div>
</s:if>

<s:else>
       <s:form id="form" action="AdminDeleteCompleteAction">

                    <table class="horizontal-list-table">
                               <thead>
                                     <tr>
                                             <th><s:label value="#" /></th>
                                             <th><s:label value="商品名"/></th>
                                             <th><s:label value="ふりがな"/></th>
                                             <th><s:label value="商品画像"/></th>
                                             <th><s:label value="値段" /></th>
                                             <th><s:label value="発売会社名"/></th>
                                             <th><s:label value="発売年月日"/></th>
                                     </tr>
                               </thead>
                               <tbody>
                               <s:iterator value="#session.productInfoDtoList">
                                     <tr>
                                             <td><s:checkbox name="checkList" value="checked" fieldValue="%{productId}"/></td>
                                             <!-- Product_idにしました。 -->
                                             <s:hidden name="productId" value="%{productId}"/>
                                             <td><s:property value="productName" /></td>
                                             <td><s:property value="productNameKana"/></td>
                                             <td><img src='<s:property value="imageFilePath" />/<s:property value="imageFileName"/>' width="50px" height="50px" /></td>
                                             <td><s:property value="price"/>円</td>
                                             <td><s:property value="releaseCompany"/></td>
                                             <td><s:property value="releaseDate"/></td>
                                     </tr>
                                             <s:hidden name="productName" value="%{productName}"/>
                                             <s:hidden name="productNameKana" value="%{productNameKana}"/>
                                             <s:hidden name="imageFileName" value="%{imageFileName}"/>
                                             <s:hidden name="imageFilePath" value="%{imageFilePath}"/>
                                             <s:hidden name="price" value="%{price}]"/>
                                             <s:hidden name="releaseCompany" value="%{releaseCompany}"/>
                                             <s:hidden name="releaseDate" value="%{releaseDate}"/>
                               </s:iterator>
                               </tbody>
                    </table>

                    <div class="submit_btn_box">
                            <div id=".contents-btn-set">
                                    <s:submit value="削除" class="submit_btn" />
                         </div>
                    </div>

       </s:form>
</s:else>
</div>
<div class="pager2">
<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
    <s:if test="#session.currentPageNo == #pageNo.count">
        <s:property value="%{#pageNo.count}"/>
    </s:if>
    <s:else>
        <a href="<s:url action='AdminDeleteAction'><s:param name='pageNo' value='%{#pageNo.count}'/>
        <s:param name='categoryId' value='%{categoryId}'/></s:url> ">   <s:property value="%{#pageNo.count}"/></a>
    </s:else>
</s:iterator>
</div>
<div id="piston"></div>


<s:include value="footer.jsp"/>
</body>
</html>