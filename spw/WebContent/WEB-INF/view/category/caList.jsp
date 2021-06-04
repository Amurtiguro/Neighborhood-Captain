<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 쿼리스트링
	String qString = null;

	Object obj = request.getParameter("qString");
	if(obj != null){
		qString = (String)obj;
	}

	if(qString != null && qString.length() > 0){
		qString = qString + "&";
	}

	request.setAttribute("qString", qString);
%>
<div class="categoryMobile">
	<input type="button" class="sitebtn" id="btnCategoryList" value="카테고리 접기/펴기">
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnCategoryList").click(function(){
			$(".categoryList").slideToggle(100);
		});
	});
</script>
<div class="categoryList">
	<ul>
		<li class="cglistRow">
			<c:if test="${not empty param.cgnum}">
				<a href="?${qString}cgall" >전체</a>
			</c:if>
			<c:if test="${empty param.cgnum}">
				<span>전체</span>
			</c:if>
		</li>
	<c:if test="${empty list}">
		<li class="cglistRow">
			<span>카테고리가 없습니다.</span>
		</li>
	</c:if>
	<c:forEach items="${list}" var="cvo">
		<li class="cglist">
			<c:if test="${cvo.cgnum != param.cgnum}">
				<a href="?${qString}cgnum=${cvo.cgnum}" >${cvo.cgname}</a>
			</c:if>
			<c:if test="${cvo.cgnum == param.cgnum}">
				<span>${cvo.cgname}</span>
			</c:if>
		</li>
	</c:forEach>
	</ul>
</div>