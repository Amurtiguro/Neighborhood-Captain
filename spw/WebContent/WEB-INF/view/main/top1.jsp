<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 타이틀 설정
	String siteTitle = "사자판다";

	String siteTitleParam = (String)request.getAttribute("siteTitle");

	if(siteTitleParam != null && siteTitleParam.length() > 0){
		siteTitle = siteTitleParam;
	}
	HttpSession hs =request.getSession();
	String sessionNum = (String)hs.getAttribute("mnum");
	//System.out.println("세션 회원번호 : "+sessionNum);
%>
<!-- 버튼, 메뉴, 하단바, 검색창 색상은 아직 안정해짐 -->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><%=siteTitle %></title>
<link rel="shortcut icon" href="/spw/include/img/favicon.ico">
<link rel="icon" href="/spw/include/img/favicon.ico">
<script type="text/javascript" src="/spw/include/js/jquery-1.12.0.js"></script>
<link rel="stylesheet" href="/spw/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="/spw/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script src="/spw/calendar_datepicker/jquery-ui-1.12.1/datepicker-ko.js"></script>
<link rel="stylesheet" href="/spw/include/css/dimlayer.css">
<link rel="stylesheet" href="/spw/include/css/mainbaner.css">
<link rel="stylesheet" href="/spw/include/css/login.css">
<link rel="stylesheet" href="/spw/include/css/mainstyle.css">
<link rel="stylesheet" href="/spw/include/css/memberinsert.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>