<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object res = request.getAttribute("res");
	int result =((Integer)res).intValue();
	System.out.println("delete result : "+result);
	
	
	if(result==1){
		System.out.println("게시판 페이지롱 이동");
%>
	<script>
		location.href="/spw/auctionList.spw";
	</script>
<%
	}else{
		System.out.println("이전 페이지롱 이동");
%>
	<script>
		history.go(-1);
	</script>
<%
	}
%>

