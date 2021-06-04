<%@page import="com.spw.general.vo.GeneralVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동네별 목록</title>
<script type="text/javascript" src="/spw/js/jquery-1.12.0.js"></script>
</head>
<body>
<jsp:include page="/category/list.spw">
	<jsp:param name="qString" value="gregcode=${gvo.gregcode}&gsort=${gvo.gsort}"/>
</jsp:include>
<form method="GET" action="/spw/general/local.spw" id="formQstr">
	<input type="text" id="gregcodeT" name="gregcode" value="${gvo.gregcode}" readonly>
	<input type="text" id="gsortT" name="gsotr" value="${gvo.gsort}" readonly>
	<input type="text" id="cgnumT" name="cgnum" value="${gvo.cgnum}" readonly>
	<input type="text" id="startdateT" name="startdate" value="${gvo.setSdate}" readonly>
	<input type="text" id="enddateT" name="enddate" value="${gvo.detEdate}" readonly>
</form>
<div>
	<a href="/spw/general/local.spw?gregcode=${gvo.gregcode}&gsort=1">사자</a>
	<a href="/spw/general/local.spw?gregcode=${gvo.gregcode}&gsort=2">판다</a>
</div>
<div id="regInfo">
	선택한 지역 :
	<span>${regInfo.regname}</span>
	<input type="button" value="변경" id="btnRegChange">
</div>
<div id="regSelect">
	<select id="regCitPro" name="regCitPro">
		<option value="SEL">시/도</option>
	</select>
	<select id="regCiCoDi" name="regCiCoDi">
		<option value="SEL">시/군/구</option>
	</select>
	<select id="regToToNe" name="regToToNe">
		<option value="SEL">읍/면/동</option>
	</select>
	<input type="button" value="조회" id="btnRegSearch">
	<input type="button" value="취소" id="btnRegChangeCancel">
</div>
<script type="text/javascript" src="/spw/js/reglist.js"></script>
<script>
	$(document).ready(function(){
		// 드롭박스 객체
		var $selCitPro = $("#regSelect #regCitPro");
		var $selCiCoDi = $("#regSelect #regCiCoDi");
		var $selToToNe = $("#regSelect #regToToNe");
		//var $selVillage = $("#regVillage");

		// 시/도 목록 가져와서 드롭박스에 출력하기
		setSelectList($selCitPro, null, "CP");

		// 드롭박스에 이벤트 할당하기
		// 시/도 -> 시/군/구
		$selCitPro.change(function(){
			console.log("[시/도 change]");
			setSelectList($selCiCoDi, $selCitPro, "CCD");
		});

		// 시/군/구 -> 읍/면/동
		$selCiCoDi.change(function(){
			console.log("[시/군/구 change]");
			setSelectList($selToToNe, $selCiCoDi, "TTN");
		});

		$("#btnRegSearch").click(function(){
			var totoneVal = $selToToNe.val();
			if(totoneVal != null && totoneVal != "" && totoneVal != "SEL"){
				$("#gregcodeT").val(totoneVal);
				$("#formQstr").submit();
			}else{
				alert("지역(읍/면/동)을 설정하세요");
			}
		});

		$("#btnRegChange").click(function(){
			$("#regInfo").hide();
			$("#regSelect").show();
		});

		$("#btnRegChangeCancel").click(function(){
			$("#regSelect").hide();
			$("#regInfo").show();
		});

	<c:if test="${empty regInfo.regname}">
		$("#regInfo").hide();
	</c:if>
	<c:if test="${not empty regInfo.regname}">
		$("#regSelect").hide();
	</c:if>

	});
</script>
<%
	GeneralVO gvo = (GeneralVO)request.getAttribute("gvo");

	// 페이징 쿼리 스트링
	String qStrPaging = "";

	if(gvo != null){
		String grcode = gvo.getGregcode();
		if(grcode != null && grcode.length() > 0 && !"SEL".equals(grcode)){
			qStrPaging = qStrPaging + "gregcode=" + grcode;
		}

		String gsort = gvo.getGsort();
		if(gsort != null && gsort.length() > 0){

			if(qStrPaging.length() > 0){
				qStrPaging = qStrPaging + "&";
			}

			qStrPaging = qStrPaging + "gsort=" + gsort;
		}

		String cgnum = gvo.getCgnum();
		if(cgnum != null && cgnum.length() > 0){

			if(qStrPaging.length() > 0){
				qStrPaging = qStrPaging + "&";
			}

			qStrPaging = qStrPaging + "cgnum=" + cgnum;
		}

		String sdate = gvo.getSetSdate();
		if(sdate != null && sdate.length() > 0){

			if(qStrPaging.length() > 0){
				qStrPaging = qStrPaging + "&";
			}

			qStrPaging = qStrPaging + "startdate=" + sdate;
		}

		String edate = gvo.getDetEdate();
		if(edate != null && edate.length() > 0){

			if(qStrPaging.length() > 0){
				qStrPaging = qStrPaging + "&";
			}

			qStrPaging = qStrPaging + "enddate=" + edate;
		}
	}
%>
<a href="/spw/regAreaMap.spw">지도 보기</a>
<table border>
	<thead>
		<tr>
			<th>일반 상품번호</th>
			<th>구분</th>
			<th>제목</th>
			<th>거래지역</th>
			<th>법정동코드</th>
			<th>사진</th>
			<th>리사이즈 사진</th>
			<th>가격</th>
			<th>설명</th>
			<th>상태</th>
			<th>삭제여부</th>
			<th>등록일</th>
			<th>수정일</th>
			<th>회원번호</th>
			<th>코드</th>
		</tr>
	</thead>
	<tbody>
	<c:if test="${empty gvo.gregcode}">
		<tr>
			<td colspan="15" align="center">검색을 원하는 '읍/면/동'을 선택하세요</td>
		</tr>
	</c:if>
	<c:if test="${empty generalList && not empty gvo.gregcode}">
		<tr>
			<td colspan="15" align="center">상품이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${generalList}" var="genvo">
		<tr>
			<td>${genvo.gnum}</td>
			<td>${genvo.gsort}</td>
			<td>${genvo.gtitle}</td>
			<td>${genvo.gloc}</td>
			<td>${genvo.gregcode}</td>
			<td>${genvo.gphoto}</td>
			<td>${genvo.grephoto}</td>
			<td>${genvo.gprice}</td>
			<td>${genvo.gcontents}</td>
			<td>${genvo.gstatus}</td>
			<td>${genvo.gdelyn}</td>
			<td>${genvo.gregdate}</td>
			<td>${genvo.gupdate}</td>
			<td>${genvo.mnum}</td>
			<td>${genvo.cgnum}</td>
		</tr>
		<c:set var="totalcount" value="${genvo.totalcount}"/>
	</c:forEach>
	</tbody>
</table>

<div>
	페이징
	<p>쿼리스트링
		 : <%=qStrPaging%>
	</p>
	<p>현재 페이지 : ${gvo.curpage}</p>
	<p>그룹 사이즈 : ${gvo.groupsize}</p>
	<p>페이지 사이즈 : ${gvo.pagesize}</p>
	<p>조회된 상품 수 : ${totalcount}</p>
</div>
</body>
</html>