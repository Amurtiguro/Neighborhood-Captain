<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.spw.general.vo.GeneralVO" %>
<%
	String gnum = request.getParameter("gnum");
	System.out.println("<selectGeneral>");
	System.out.println("해당 글번호 : "+gnum);
	String mnum = "M202007300001";
	Object obj = request.getAttribute("selectGeneral");
	List<GeneralVO> list = (List<GeneralVO>)obj;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./include/js/jquery-1.12.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("jQuery 실행 : ");
		
	});
	function Home(){
		document.selectForm.method="POST";
		document.selectForm.action="/spw/myPick.spw";
		document.selectForm.submit();
	}
</script>
</head>
<body>
<div align="center">
<form name="selectForm" id="selectForm"> 
<input type="hidden" name="mnum" id="mnum" value="<%=mnum %>"/>
<table border="1">
	<thead>
		<tr>
			<td colspan="6" align="center">
				<h2>상세 페이지 조회</h2>
			</td>
		</tr>
		
	</thead>
<%
	if(list!=null && list.size()>0){
		for(int i=0;i<list.size();i++){
			GeneralVO mgvo = (GeneralVO)list.get(i);
%>
	<tbody>
		<tr>
			<td>글번호</td>
			<td><%=mgvo.getGnum()%></td>
		</tr>
		<tr>
			<td>글카테고리</td>
			<td><%=mgvo.getCgnum()%></td>
		</tr>
		<tr>
			<td>글제목</td>
			<td><%=mgvo.getGtitle() %></td>
		</tr>
		<tr>
			<td>사진</td>
			<td><%=mgvo.getGphoto()%></td>
		</tr>
		<tr>
			<td>금액</td>
			<td><%=mgvo.getGprice() %></td>
		</tr>	
	</tbody>
<%
		}
	}
%>
	<tfoot>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="뒤로" onclick="Home()"/>
			</td>
		</tr>
	</tfoot>
</table>
</form>
</div>
</body>
</html>