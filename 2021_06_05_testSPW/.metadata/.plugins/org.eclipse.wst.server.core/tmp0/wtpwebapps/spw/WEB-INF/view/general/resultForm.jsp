<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<%
	Object objStr = request.getAttribute("resultStr");
	Object objSort = request.getAttribute("sort");
    String result = (String)objStr;
    String sort = (String)objSort;
    if(result.equals("완료")){
    	if(sort.equals("1")){
%>
    		<script>
    			location.href="/spw/generalSList.spw";
    		</script>
<%  		
    	}
    	if(sort.equals("2")){
%>
    		<script>
    			location.href="generalPList.spw";
    		</script>
<%  		    		
    	}
    }else{
%>
		<script>
			history.go(-1);
		</script>
<%	
    }
%>
</body>
</html>