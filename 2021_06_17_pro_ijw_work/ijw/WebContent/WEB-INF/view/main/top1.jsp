<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 타이틀 설정
	String siteTitle = "구매판매";

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
<link rel="shortcut icon" href="/ijw/include/img/favicon.ico">
<link rel="icon" href="/ijw/include/img/favicon.ico">
<script type="text/javascript" src="/ijw/include/js/jquery-1.12.0.js"></script>
<link rel="stylesheet" href="/ijw/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="/ijw/calendar_datepicker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script src="/ijw/calendar_datepicker/jquery-ui-1.12.1/datepicker-ko.js"></script>
<link rel="stylesheet" href="/ijw/include/css/dimlayer.css">
<link rel="stylesheet" href="/ijw/include/css/mainbaner.css">
<link rel="stylesheet" href="/ijw/include/css/login.css">
<link rel="stylesheet" href="/ijw/include/css/mainstyle.css">
<link rel="stylesheet" href="/ijw/include/css/memberinsert.css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>