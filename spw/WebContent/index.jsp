<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
	HttpSession hs =request.getSession();
	String sessionNum = (String)hs.getAttribute("mnum");
	System.out.println("세션 회원번호 : "+sessionNum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./include/css/mainstyle.css">
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
					<a href="/spw/index.jsp">
						<!-- 로고이미지 위치 확정되면 변경 -->
						<img src="./include/img/logo.png" id="sitelogo">
					</a>
				</div>
				<!-- 검색바 -->
				<div id="searchbar">
					<form>
						<!-- 드롭다운 -->
						<select>
							<option>사자</option>
							<option>판다</option>
							<option>경매</option>
						</select>
						<!-- 텍스트필드 -->
						<div id="searchtext">
							<input type="text">
						</div>
						<!-- 검색버튼 -->
						<input type="submit" value="검색" id="searchbtn">
					</form>
				</div>
			</div>
			<div id="btnarea">
<%
				if(sessionNum!=null&&sessionNum.length()>0){
%>
					<a href="/spw/logout.spw" class="sitebtn">로그아웃</a>
					<a href="/spw/myPage.spw" class="sitebtn">마이페이지</a>
					<a href="#임시" class="sitebtn">글쓰기</a>
<%					
				}else{
%>
					<a href="loginform.spw" class="sitebtn">로그인</a>
					<a href="/spw/meminsertform.spw" class="sitebtn">회원가입</a>
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
					<a href="/spw/generalSList.spw">
						<div class="nav_btn">
							사자
						</div>
					</a>
				</li>
				<li>
					<a href="/spw/generalPList.spw">
						<div class="nav_btn">
							판다
						</div>
					</a>
				</li>
				<li>
					<a href="/spw/local.spw">
						<div class="nav_btn">
							동네
						</div>
					</a>
				</li>
				<li>
					<a href="/spw/auctionList.spw">
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
			<div>
				[내용]
			</div>
		</div>
	</div>
</div>

<!-- 하단바 -->
<footer id="footerarea">
	<div class="wrapper">
		<div>
			[하단바]
			<br>아이콘 제작자 :
			<a href="http://www.freepik.com/" title="Freepik">Freepik</a>
			from
			<a href="https://www.flaticon.com/kr/" title="Flaticon"> www.flaticon.com</a>
		</div>
	</div>
</footer>
</body>
</html>