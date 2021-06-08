<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("<myPickUpdate>");
%>
<%
	Object objCnt = request.getAttribute("myPickUpdate");
	System.out.println("objCnt null확인 : "+objCnt);
	int uCnt =((Integer)objCnt).intValue();
	
	Object objGnum = request.getAttribute("gnum");
	System.out.println("objGnum null확인 : "+objGnum);
	String gnum = (String)objGnum;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/spw/include/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
<%
	if(uCnt>0){
%>
		<script>
			location.href="/spw/myPage.spw";
		</script>
<%		
	}
%>
</body>
</html>