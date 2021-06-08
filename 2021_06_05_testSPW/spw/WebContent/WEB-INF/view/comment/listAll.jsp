<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// 쿼리스트링
	String ccontents = request.getParameter("ccontents");
	
	String qStr = "";
	if(ccontents != null && ccontents.length() > 0){
		qStr = "ccontents=" + ccontents;
	}

	request.setAttribute("siteTitle", "페이지 타이틀");
%>
<%@ include file="/WEB-INF/view/main/top1.jsp" %>
<script>
	$(document).ready(function(){
		// 삭제
		$(".delCmt").click(function(){
			if(confirm("삭제하시겠습니까?") == true){
				var delURL = $(this).attr("href");
	
				function delSuccess(data){
					if(data.status == "OK"){
						location.reload();
					}else{
						console.log(data.msg);
					}
				}
	
				function delFail(){
					console.log("삭제요청 전송도중 오류가 발생했습니다.");
				}

				$.ajax({
					url: delURL,
					dataType: "JSON",
					method: "GET",
					success: delSuccess,
					error: delFail
				});
			}

			return false;
		});

		$("#commSearch").submit(function(){
			if($("#ccontents").val() == ""){
				alert("검색할 내용을 입력하세요");
				return false;
			}
		});
	});
</script>
<%@ include file="/WEB-INF/view/main/top2.jsp" %>
<br>
<br>
<div class="list_sort">
	<div class="tab_sort tab_panda">
		<a href="/spw/adminSelectAll.spw">회원관리</a>
	</div>
	<div class="tab_sort tab_saja">
		<a href="/spw/chartboard.spw">상품등록 현황</a>
	</div>
	<div class="tab_sort tab_comment tab_sel">
		댓글 관리
	</div>
</div>
<br>
<br>
<table class="table_list table_hover">
	<colgroup>
		<col>
		<col width="50%">
		<col>
		<col>
		<col width="10%">
		<col width="10%">
		<col>
	</colgroup>
	<thead>
		<tr>
			<td class="col_right" colspan="7">
				<form method="GET" action="/spw/comment/listall.spw" id="commSearch">
					<input type="text" name="ccontents" id="ccontents" class="sitetxt" value="${param.ccontents}">
					<input type="submit" class="sitebtn" value="검색">
				</form>
			</td>
		</tr>
		<tr>
			<th>댓글 번호</th>
			<th>댓글 내용</th>
			<th>상품 번호</th>
			<th>입력일</th>
			<th>회원명</th>
			<th>회원 ID</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
<c:if test="${empty commentList}">
		<tr>
			<td colspan="7" align="center">댓글이 없습니다.</td>
		</tr>
</c:if>
<c:forEach items="${commentList}" var="cvo">
			<tr>
				<td>${cvo.cnum}</td>
				<td class="col_left">${cvo.ccontents}</td>
				<td>${cvo.cpnum}</td>
				<td>${cvo.cindate}</td>
				<td class="col_center">${cvo.mname}</td>
				<td class="col_center">${cvo.mid}</td>
				<td>
					<a href="/spw/comment/delete.spw?cnum=${cvo.cnum}" class="delCmt sitebtn">삭제</a>
				</td>
			</tr>
			<c:set var="totalcount" value="${cvo.totalcount}"/>
</c:forEach>
	</tbody>
</table>
<div class="list_paging">
	<p style="text-align: right;">
		<jsp:include page="paging.jsp">
			<jsp:param name="url" value="comment/listall.spw"/>
			<jsp:param name="qStr" value="<%=qStr%>"/>
			<jsp:param name="curpage" value="${cmvo.curpage}"/>
			<jsp:param name="groupsize" value="${cmvo.groupsize}"/>
			<jsp:param name="pagesize" value="${cmvo.pagesize}"/>
			<jsp:param name="totalcount" value="${totalcount}"/>
		</jsp:include>
	</p>
</div>
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>