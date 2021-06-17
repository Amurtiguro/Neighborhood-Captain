<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("<myPickInsert>");
%>
<%
	Object objCnt = request.getAttribute("myPickInsert");
	System.out.println("objCnt null확인 : "+objCnt);
	int iCnt =((Integer)objCnt).intValue();
	
	Object objGnum = request.getAttribute("gnum");
	System.out.println("objGnum null확인 : "+objGnum);
	String gnum = (String)objGnum;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/ijw/include/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
<%
	if(iCnt>0){
%>
		<script>
			location.href="/ijw/generalDetailForm.ijw?gnum=<%=gnum%>";
		</script>
<%		
	}
%>
</body>
</html>