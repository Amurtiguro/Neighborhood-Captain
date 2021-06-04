<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spw.member.vo.MemberVO" %>
<%
	request.setAttribute("siteTitle", "마이 페이지");
%>
<%
	System.out.println("<myPage>");
	// 회원 아이디 가져오기.
	Object obj = request.getAttribute("mvo");
	MemberVO mvo = (MemberVO)obj;
	String mid = mvo.getMid();
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<link rel="stylesheet" href="./include/css/myPage.css">
<script type="text/javascript">
	$(document).ready(function(){
		console.log("jQuery 실행 : ");
		
		// 회원 수정 버튼.
		$('#myUpdate').click(function(){
			//console.log("수정버튼 실행 : ");
			$('#myPageForm').attr('action','/spw/myInfo.spw');
			$('#myPageForm').submit();
		});
		var urls="/spw/myNotice.spw";
		var datas;
		$.ajax({
			url:urls,
			type:"GET",
			data:datas,
			success:whenSuccess,
			error:whenError
		});
		function whenSuccess(res){
			console.log("success");
			console.log(res);
			$('.notice_list').html(res);
		}
		function whenError(res){
			console.log("error");
			console.log(res);
		}
		
	});

</script>

<!-- 상단 바. -->
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<!-- 마이페이지.  -->
<div class="mypage_contents">
<h2 align="left">마이페이지</h2>
	<!-- 회원정보.  -->
	<div class="myinfo">
		<div class="myinfo_list">
			<form id="myPageForm" name="myPageForm">
			<input type="hidden" name="mnum" id="mnum" value="<%=sessionNum %>"/>
			<h3>회원정보</h3>
			
			<div class="myinfo_pic">
				<img src="/spw/include/img/mypage.png">
			</div>
			<br>
			<div class="myinfo_id">
				<span><%=mid %></span><br>
			</div>
			<div class="myinfo_btn">
				<input type="button" name="myUpdate" id="myUpdate" value="회원정보수정" class="sitebtn"/>
			</div>
			</form>
		</div>
		<!-- 알림목록.  -->
		<div class="mynotice_list">
			<h3>알림</h3>
			<hr>
			<div class="notice_list">
				
			</div>
		</div>
	</div>
	<br>
	<div class="btn_container">
		<div class="tab_sort tab_saja"><a href="/spw/myGeneral.spw?gsort=1">사자</a></div>
		<div class="tab_sort tab_panda"><a href="/spw/myGeneral.spw?gsort=2">판다</a></div>
		<div class="tab_sort tab_auction"><a href="/spw/myAuction.spw?asort=3">경매</a></div>
		<div class="tab_sort tab_pick"><a href="/spw/myPick.spw">찜</a></div>
	</div>

</div>
<!-- 하단 바. -->
<%@ include file="/WEB-INF/view/main/bottom.jsp" %>
</body>
</html>