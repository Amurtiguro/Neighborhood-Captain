<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/main/top1.jsp"%>
<link rel="stylesheet" href="/ijw/include/css/adminform.css">
<%@ include file="/WEB-INF/view/main/top2.jsp"%>

<br>
<br>
    <div class="list_sort">
    	<div class="tab_sort tab_panda">
    		<a href="/ijw/adminSelectAll.ijw">회원 관리</a>
    	</div>
    	<div class="tab_sort tab_saja">
    		<a href="/ijw/chartboard.ijw">상품등록 현황</a>
    	</div>
    	<div class="tab_sort tab_comment">
    		<a href="/ijw/comment/listall.ijw">댓글관리</a>
    	</div>
    </div>
<br>
<br>
<%@ include file="/WEB-INF/view/main/bottom.jsp"%>