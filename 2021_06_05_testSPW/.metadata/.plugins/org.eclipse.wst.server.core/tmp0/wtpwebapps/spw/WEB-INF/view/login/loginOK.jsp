<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
function logout(){
	
	 window.document.logout1.action ="/spw/logout.spw";
	 window.document.logout1.method = "post";
	 window.document.logout1.submit();
}
</script>
</head>
<body>
<script>
 	/* MainPage Controller에 들어가서 RequestMapping으로 index를 찾아갑니다. */
	location.href="/spw/";
</script>
</body>
</html>