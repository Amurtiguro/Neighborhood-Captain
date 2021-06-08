<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object objectDeal = request.getAttribute("noticeStr");
	Object objectNotice = request.getAttribute("dealStr");
	Object objectGnum = request.getAttribute("gnum");
	String noticeStr = (String)objectDeal;
	String dealStr = (String)objectNotice;
	String gnum = (String)objectGnum;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./include/js/jquery-1.12.0.js"></script>

</head>
<body>
<%
	if(noticeStr!=null&&dealStr!=null){
%>
	<script>
		alert("거래신청되었습니다.");
		history.go(-1);
	</script>
<%
	}else{
%>
	error
<%
	}
%>
</body>
</html>