<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- insert/update/delete등의 작업후 메세지를 표시하는 View --%>
<%--
		msg : 사용자에게 출력할 메세지
		url : 사용자를 이동시킬 URL
		url이 없으면 뒤로가기
--%>
<%
	Object objMsg = request.getAttribute("msg");
	Object objUrl = request.getAttribute("url");

	String msg = null;
	String url = null;

	if(objMsg != null){
		msg = (String)objMsg;
	}

	if(objUrl != null){
		url = (String)objUrl;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안내</title>
</head>
<body>
	<script>
<%
	if(msg != null && msg.length() > 0){
%>
		alert("<%=msg%>");
<%
	}

	if(url != null && url.length() > 0){
%>
		location.href = "/spw/<%=url%>";
<%
	}else{
%>
		history.go(-1);
<%
	}
%>
	</script>
</body>
</html>