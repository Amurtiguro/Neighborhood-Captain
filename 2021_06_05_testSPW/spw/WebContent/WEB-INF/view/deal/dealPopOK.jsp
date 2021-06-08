<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object objectDeal = request.getAttribute("dstr");
	Object objectNotice = request.getAttribute("nstr");
	String dstr = (String)objectDeal;
	String nstr = (String)objectNotice;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./include/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	function goIndex(){
		self.close();
	}
</script>
</head>
<body>
<%
	if(dstr!=null&&nstr!=null){
%>
	<input type="button" value="확인" onclick="goIndex()">
<%
	}else{
%>
	error
<%
	}
%>
</body>
</html>