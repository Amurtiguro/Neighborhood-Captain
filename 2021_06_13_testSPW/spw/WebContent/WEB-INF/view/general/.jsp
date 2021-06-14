<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사자, 판다 입력 폼</title>
<link/>
<script type="text/javascript">
	$(function(){
		/* 게시글 등록 func */
		/* 체크 이벤트 등록할 것*/ 
		$("#generalInsert").click(function(){
			alert("generalInsert 클릭");
			location.href="general/generalInsert";
		});
		
		/* 목록으로 func */
		$("#generalList").click(function(){
			alert("generalList 클릭");
			location.href="general/generalList";
			
		});
		
	});


</script>
</head>
<body>
	<div id="voardTit"><h3>글쓰기</h3></div>
	<form id="generalWriteForm" name="" enctype="multipart.form-data" >
		<table id="generalWrite" border=1>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="mnum" id="mnum" readonly="readonly"></td>
			</tr>
			<tr>
				<td>구분</td>
				<td>
				<input type="radio"  id="gsort" name="gsort" value="사자">
				<label for="saja">사자</label>
				<input type="radio"  id="gsort" name="gsort" value="판대">
				<label for="panda">판다</label>
				<input type="radio"  id="gsort" name="gsort" value="경매">
				<label for="auction">경매</label>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="gpw" id="gpw">
				<input type="button" name="gpw2" id="gpw2" value="비밀번호 체크"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="gtitle" id="gtitle"></td>
			</tr>
			<tr>
				<td>카테고리</td>
				<td><input type="text" name="cgnum" id="cgnum" value="어케해??"></td>
			</tr>
			<tr>
				<td>거래지역1</td>
				<td><input type="button" name="gloc" id="gloc" value="지도api구현1">
				<input type="button" name="gloc" id="gloc" value="지도api구현2"></td>
			</tr>
			
			<tr>
				<td>사진</td>
				<td><input type="file" name=gphoto id="gphoto"></td><br>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="gprice" id="gprice">원</td>
			</tr>
			<tr>
				<td>설명</td>
				<td><textarea name="gcontent" id="gcontent" rows="10" cols="50"></textarea><br/></td>
			</tr>
		</table>
	</form>
	<div id = "boardBut">
		<input type="button" value="게시글 등록" class="but" id="generalInsert">
		<input type="button" value="목록으로" class="but" id="generalList">
	</div>
</body>
</html>