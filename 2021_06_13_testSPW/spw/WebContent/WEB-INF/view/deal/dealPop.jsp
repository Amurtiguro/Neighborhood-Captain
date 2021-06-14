<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spw.deal.vo.DealVO" %>
<%
	System.out.println("< dealPop >");
	Object obj = request.getAttribute("dvo");
	DealVO dvo = (DealVO)obj;
	System.out.println("dvo : "+dvo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./include/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	console.log("jQuery 시작 : ");
	function dealReq(){
		console.log("dealForm : ");
		//document.dealForm.target
	/* 	document.dealForm.method="GET";
		document.dealForm.action="/spw/dealInsert.spw";
		document.dealForm.submit(); */
		var pick = confirm("등록하시겠습니까?");
		if(pick==true){
			document.dealForm.method="GET";
			document.dealForm.action="/spw/dealInsert.spw";
			document.dealForm.submit();
			
		}
		else{
			location.reload();
		}
	}
</script>
</head>

<body>
<h2>거래신청 - 알림</h2>
<form id="dealForm" name="dealForm">
	거래신청번호 : <input type="text" disabled><br>
	연락처 : <input type="text" name="dcontact" id="dcontact"><br>
	날짜 : <input type="text" disabled><br> 
	타겟회원번호 : <input type="text" name="mnum" id="mnum" value="<%=dvo.getMnum()%>"><br>
	타겟일반상품번호 : <input type="text" name="gnum" id="gnum" value="<%=dvo.getGnum()%>"><br>
	<hr>
	알림에 들어갈 아이디 : <input type="text" name="nmid" id="nmid"><br>
	알림에 들어갈 내용 : <input type="text" name="ncontents" id="ncontents" value="1"><br>
	알림에 들어갈 url : <input type="text" name="nurl" id="nurl" value="spw/generalDetailForm.spw?gnum=<%=dvo.getGnum()%>"><br>
	<input type="button" value="등록" onclick="dealReq()">
</form>
</body>
</html>