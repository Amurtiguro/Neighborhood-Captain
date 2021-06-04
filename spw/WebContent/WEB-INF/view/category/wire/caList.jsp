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
<table border>
	<tr>
		<th>코드</th>
		<th>이름</th>
		<th>선택여부</th>
	</tr>
<c:if test="${empty list}">
	<tr>
		<th colspan="3">카테고리 없음</th>
	</tr>
</c:if>
<c:forEach items="${list}" var="cvo">
	<tr>
		<td>${cvo.cgnum}</td>
		<td>
			<a href="?${qString}cgnum=${cvo.cgnum}">${cvo.cgname}</a>
		</td>
		<td>
			<c:if test="${cvo.cgnum == param.cgnum}">
				○
			</c:if>
		</td>
	</tr>
</c:forEach>
</table>