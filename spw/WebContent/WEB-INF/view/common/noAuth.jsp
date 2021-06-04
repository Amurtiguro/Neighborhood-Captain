<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비회원, 일반회원이 관리자 기능에 접근하려고할때처럼 권한이 없을때 보여줄 View --%>
<%--
	관리자가 아닌데 관리자 기능에 접근하려할때처럼
	권한이 없을때 한다면 기능을 실행하는대신 이 View로 보낸다.
	권한이 없다는 메세지와 함께 돌려보낸다.
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류!</title>
</head>
<body>
	<script type="text/javascript">
		alert("권한이 없습니다.");
	
		// 뒤로가기
		history.go(-1);
	</script>
	<h1>오류!</h1>
	<h2>권한이 없습니다.</h2>
	<a href="/spw/">메인화면으로</a>
</body>
</html>