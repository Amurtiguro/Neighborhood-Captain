<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>

</head>
<body>
<!-- 상단바와 내용 -->
<div id="sitearea">
	<!-- 상단바 -->
	<header id="topbar">
		<div class="wrapper">
			<!-- 상단바 로고영역(로고, 검색) -->
			<div id="logoarea">
				<!-- 로고 -->
				<div id="toplogo">
					<a href="/ijw/index.ijw">
						<img src="/ijw/include/img/logo.png" id="sitelogo">
					</a>
				</div>
				<div id="mobilebtns">
					<input type="button" value="◎" class="sitebtn" id="btnSearchBar">
					<input type="button" value="●" class="sitebtn" id="btnBtnArea">
					<input type="button" value="▤" class="sitebtn" id="btnNaviArea">
				</div>
				<!-- 검색바 -->
				<div id="searchbar">
<%
	String topSearchText = "";
	String topAtitle = request.getParameter("atitle");
	String topGtitle = request.getParameter("gtitle");

	if(topGtitle != null && topGtitle.length() > 0){
		topSearchText = topGtitle;
	}else if(topAtitle != null && topAtitle.length() > 0){
		topSearchText = topAtitle;
	}
%>
	<form method="GET" id="topSearchform">
		<!-- 드롭다운 -->
		<select id="topSearchsel">
			<option value="1">구매</option>
			<option value="2">판매</option>
			<option value="3">경매</option>
		</select>
		<!-- 텍스트필드 -->
		<div id="searchtext">
			<input type="text" id="topSearchtxt" value="<%=topSearchText %>">
		</div>
		<!-- 검색버튼 -->
		<input type="submit" value="검색" id="searchbtn">
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			$("form#topSearchform").submit(function(){
				// 폼
				var topSearchform = $("form#topSearchform")

				// 셀렉트
				var topSearchSel = $("#topSearchsel");

				// 텍스트
				var topSearchtxt = $("#topSearchtxt");

				if(topSearchtxt.val() != null && topSearchtxt.val() != ""){
					// 셀렉트 내용
					var selectVal = topSearchSel.val();

					if(selectVal == "3"){
						// 경매
						// 텍스트필드 name속성 지정
						topSearchtxt.attr("name", "atitle");

						// 경로지정
						topSearchform.attr("action", "/ijw/auctionList.ijw");

						// 전송
						topSearchform.submit();
					}else{
						// 텍스트필드 name속성 지정
						topSearchtxt.attr("name", "gtitle");
						if(selectVal == "1"){
							// 구매

							// 경로지정
							topSearchform.attr("action", "/ijw/generalSList.ijw");

							// 전송
							topSearchform.submit();
							
						}else if(selectVal == "2"){
							// 판매

							// 경로지정
							topSearchform.attr("action", "/ijw/generalPList.ijw");

							// 전송
							topSearchform.submit();
						}
					}
				}else{
					alert("검색어를 입력해 주세요");
				}
				return false;
			});

						
			$("#btnSearchBar").click(function(){
				if($("#searchbar").css("display") == "none"){
					$("#btnarea").slideUp(100);
					$("#naviarea").slideUp(100);
					$("#searchbar").slideDown(200);
				}else{
					$("#searchbar").slideUp(200);
				}
			});
			$("#btnBtnArea").click(function(){
				if($("#btnarea").css("display") == "none"){
					$("#searchbar").slideUp(100);
					$("#naviarea").slideUp(100);
					$("#btnarea").slideDown(200);
				}else{
					$("#btnarea").slideUp(200);
				}
			});
			$("#btnNaviArea").click(function(){
				if($("#naviarea").css("display") == "none"){
					$("#searchbar").slideUp(100);
					$("#btnarea").slideUp(100);
					$("#naviarea").slideDown(200);
				}else{
					$("#naviarea").slideUp(200);
				}
			});
		});
	</script>
				</div>
			</div>
			<div id="btnarea">
<%
	HttpSession hs2 =request.getSession();
	String sessionNum2 = (String)hs2.getAttribute("mnum");
	System.out.println("세션 회원번호 : "+sessionNum2);
%>
<%				
					
				String admin="M202007300001";
				if(sessionNum2!=null&&sessionNum2.length()>0){
					if(admin.equals(sessionNum2)){
%>
						<a href="/ijw/logout.ijw" class="sitebtn">로그아웃</a>
						<a href="/ijw/adminSelectAll.ijw" class="sitebtn">관리자페이지</a> 
<%					
					}else{
%>
						<a href="/ijw/logout.ijw" class="sitebtn">로그아웃</a>
						<a href="/ijw/myPage.ijw" class="sitebtn">마이페이지</a>
						<a href="/ijw/generalInsertForm.ijw" class="sitebtn">글쓰기</a>
<%					
					}
				}else{
%>
					<a href="/ijw/loginform.ijw" class="sitebtn">로그인</a>
					<a href="/ijw/meminsertform.ijw" class="sitebtn">회원가입</a>
<%
				}
%>					
			</div>
		</div>
		<!-- 메뉴 -->
		<div id="naviarea">
			<ul class="wrapper">
				<!-- 메뉴버튼들 -->
				<li>
					<a href="/ijw/generalSList.ijw">
						<div class="nav_btn">
							구매
						</div>
					</a>
				</li>
				<li>
					<a href="/ijw/generalPList.ijw">
						<div class="nav_btn">
							판매
						</div>
					</a>
				</li>
				<li>
					<a href="/ijw/local.ijw">
						<div class="nav_btn">
							동네
						</div>
					</a>
				</li>
				<li>
					<a href="/ijw/auctionList.ijw">
						<div class="nav_btn">
							경매
						</div>
					</a>
				</li>
			</ul>
		</div>
	</header>
	<!-- 내용 -->
 	<div id="sitecontent">
		<div class="wrapper">
