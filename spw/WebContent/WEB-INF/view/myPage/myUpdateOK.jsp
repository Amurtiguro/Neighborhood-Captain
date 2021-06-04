<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("<myUpdateOK>");
%>
<%
	Object obj = request.getAttribute("uCnt");
	System.out.println("obj null확인 : "+obj);
	int uCnt =((Integer)obj).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(uCnt>0){
%>
	수정 성공.
<%
	}
%>
<div align="center">
	<a href="/spw/myPage.spw">마이페이지</a>
</div>
</body>
</html>