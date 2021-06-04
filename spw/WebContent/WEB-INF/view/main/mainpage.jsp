<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("siteTitle", "사자판다");
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<script type="text/javascript" src="/spw/include/js/mainbaner.js"></script>
<%@include file="/WEB-INF/view/main/top2.jsp" %>

<!-- 밀어내기  -->
<div class="slideshow-container">
	<!-- 슬라이드 이미지. -->
	<div class="mySlides fade2">
		<img class="main_slideImg" src="/spw/include/img/baner1.jpg">
		
	</div>
	<div class="mySlides fade2">
		<img class="main_slideImg" src="/spw/include/img/baner2.jpg">
		
	</div>
	<div class="mySlides fade2">
		<img class="main_slideImg" src="/spw/include/img/baner5.png">
		
	</div>
	<!-- 좌우 버튼. -->
	<a class="prev" onclick="plusSlides(-1)">❮</a>
	<a class="next"onclick="plusSlides(1)">❯</a>
</div>
	<br>
<!-- 하단 버튼.  -->
<div style="text-align: center">
	<span class="dot" onclick="currentSlide(1)"></span> 
	<span class="dot" onclick="currentSlide(2)"></span>
	<span class="dot" onclick="currentSlide(3)"></span>
</div>

<div class="bar_list">
	<h3 class="bar_title">최근 판다</h3>
	<div class="list_contents">
		<c:if test="${empty pandaList}">
		<div class="list_msg">
			<h3>최근 게시된 판다글이 없습니다.</h3>
		</div>
		</c:if>
		<c:if test="${not empty pandaList}">
		<div class="list_grid">
			<ul>
				<c:forEach items="${pandaList}" var="gvoPanda">
				<li class="grid_item">
					<a href="/spw/generalDetailForm.spw?gnum=${gvoPanda.gnum}">
						<div class="grid_item_box">
							<div class="grid_img">
								<div class="grid_img_label label_panda">
									판다
								</div>
								<img src="/spw/editImages/Thumb_${gvoPanda.gphoto}">
							</div>
							<div class="grid_label">
								<h3 class="grid_title">
									${gvoPanda.gtitle}
								</h3>
								<p class="grid_local">
									<span>${gvoPanda.gloc}</span>
								</p>
								<p class="grid_balance">
									<span>${gvoPanda.gprice}</span>원
								</p>
							</div>
						</div>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
		</c:if>
	</div>
</div>
<div class="bar_list">
	<h3 class="bar_title">최근 사자</h3>
	<div class="list_contents">
		<c:if test="${empty sajaList}">
		<div class="list_msg">
			<h3>최근 게시된 사자글이 없습니다.</h3>
		</div>
		</c:if>
		<c:if test="${not empty sajaList}">
		<div class="list_grid">
			<ul>
				<c:forEach items="${sajaList}" var="gvoSaja">
				<li class="grid_item">
					<a href="/spw/generalDetailForm.spw?gnum=${gvoSaja.gnum}">
						<div class="grid_item_box">
							<div class="grid_img">
								<div class="grid_img_label label_saja">
									사자
								</div>
								<img src="/spw/editImages/Thumb_${gvoSaja.gphoto}">
							</div>
							<div class="grid_label">
								<h3 class="grid_title">
									${gvoSaja.gtitle}
								</h3>
								<p class="grid_local">
									<span>${gvoSaja.gloc}</span>
								</p>
								<p class="grid_balance">
									<span>${gvoSaja.gprice}</span>원
								</p>
							</div>
						</div>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
		</c:if>
	</div>
</div>

<div class="bar_list">
	<h3 class="bar_title">최근 경매</h3>
	<div class="list_contents">
		<c:if test="${empty auctionList}">
		<div class="list_msg">
			<h3>최근 게시된 경매글이 없습니다.</h3>
		</div>
		</c:if>
		<c:if test="${not empty auctionList}">
		<div class="list_grid">
			<ul>
				<c:forEach items="${auctionList}" var="gvoAuction">
				<li class="grid_item">
					<a href="/spw/auctionViewDetail.spw?anum=${gvoAuction.anum}">
						<div class="grid_item_box">
							<div class="grid_img">
								<div class="grid_img_label label_auction">
									경매
								</div>
								<img src="/spw/editImages/Thumb_${gvoAuction.aphoto}">
							</div>
							<div class="grid_label">
								<h3 class="grid_title">
									${gvoAuction.atitle}
								</h3>
								<p class="grid_local">
									<span>${gvoAuction.aloc}</span>
								</p>
								<p class="grid_balance">
									<span>${gvoAuction.apricemin}</span>원
								</p>
							</div>
						</div>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
		</c:if>
	</div>
</div>

<%@ include file="/WEB-INF/view/main/bottom.jsp" %>