<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("<myDeleteOK>");
 %>
<%
	Object obj = request.getAttribute("dCnt");
	System.out.println("obj null확인 : "+obj);
	int dCnt =((Integer)obj).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(dCnt>0){
%>
	삭제 성공.
<%
	}
%>
<div align="center">
	<a href="/spw/myPage.spw">마이페이지</a>
</div>
</body>
</html>