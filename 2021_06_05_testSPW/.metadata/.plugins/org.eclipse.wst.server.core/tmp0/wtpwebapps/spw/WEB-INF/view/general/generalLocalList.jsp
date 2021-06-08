<%@page import="java.util.List"%>
<%@page import="com.spw.general.vo.GeneralVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("siteTitle", "동네 목록");
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
<!-- 상품리스트(그리드) -->
<div class="list_contents">
	<div class="list_top">

		<h2 class="list_title">동네별 조회</h2>

		<!-- 카테고리 -->
		<jsp:include page="/category/list.spw">
			<jsp:param name="qString" value="gregcode=${gvo.gregcode}&gsort=${gvo.gsort}"/>
		</jsp:include>
		<div class="reg_find">
			<form method="GET" action="/spw/local.spw" id="formQstr">
				<input type="text" id="gregcodeT" name="gregcode" value="${gvo.gregcode}" readonly>
				<input type="text" id="gsortT" name="gsotr" value="${gvo.gsort}" readonly>
				<input type="text" id="cgnumT" name="cgnum" value="${gvo.cgnum}" readonly>
				<input type="text" id="setSdateT" name="dateFrom" value="${gvo.dateFrom}" readonly>
				<input type="text" id="detEdateT" name="dateTo" value="${gvo.dateTo}" readonly>
			</form>
			<div id="regInfo" class="reg_info">
				<span>선택한 지역 :</span>
				<span class="reg_name">
					<c:if test="${empty regInfo.regname}">
						없음
					</c:if>
					${regInfo.regname}
				</span>
				<input type="button" value="변경" id="btnRegChange" class="sitebtn">
			</div>
			<div id="regSelect" class="reg_select">
				<select id="regCitPro" name="regCitPro" class="siteselect">
					<option value="SEL">시/도</option>
				</select>
				<select id="regCiCoDi" name="regCiCoDi" class="siteselect">
					<option value="SEL">시/군/구</option>
				</select>
				<select id="regToToNe" name="regToToNe" class="siteselect">
					<option value="SEL">읍/면/동</option>
				</select>
				<input type="button" value="조회" id="btnRegSearch" class="sitebtn">
				<input type="button" value="취소" id="btnRegChangeCancel" class="sitebtn">
			</div>
			<div class="reg_area">
				<input type="button" id="btnShowSearchDate" class="sitebtn" value="기간 검색">
				<a href="/spw/regAreaMap.spw" class="sitebtn">지도로 보기</a>
			</div>
			<div class="search_by_date search_popup" id="searchByDate">
				날짜입력
				<input type="text" id="startime" class="sitetxt" size="15">
				~
				<input type="text" id="endtime" class="sitetxt" size="15">
				<input type="button" value="조회" id="btnSerachDate" class="sitebtn">
				<input type="button" value="취소" id="btnSerachDateCancel" class="sitebtn">
			</div>
			<script type="text/javascript" src="/spw/include/js/reglist.js"></script>
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

					// 읍면동 선택시 지역검색에 반영
					$selToToNe.change(function(){
						var totoneVal = $selToToNe.val();
						if(totoneVal != null && totoneVal != "" && totoneVal != "SEL"){
							$("#gregcodeT").val(totoneVal);
						}
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

					$("#btnShowSearchDate").click(function(){
						$("#searchByDate").slideDown(100);
					});

					$("#btnSerachDateCancel").click(function(){
						$("#searchByDate").slideUp(100);
					});

					// DatePicker
					$("#startime").datepicker({
						dateFormat: "yy/mm/dd",
						maxDate: 0,
						onSelect: function(){
							console.log("시작일 선택");
							$("#endtime").datepicker("option", "minDate", $("#startime").datepicker("getDate"));
						}
					});

					$("#endtime").datepicker({
						dateFormat: "yy/mm/dd",
						maxDate: 0,
						onSelect: function(){
							console.log("종료일 선택");
							$("#startime").datepicker("option", "maxDate", $("#endtime").datepicker("getDate"));
						}
					});

					$("#endtime").datepicker("setDate", "0");

					$("#btnSerachDate").click(function(){
						console.log("기간 검색");
						var sDate = $("#startime").val();
						var eDate = $("#startime").val();
						console.log(sDate, eDate);

						$("#setSdateT").val(sDate);
						$("#setSdateT").val(eDate);

						$("#formQstr").submit();
					});

				});
			</script>
		</div>
	</div>
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
	
			String sdate = gvo.getDateFrom();
			if(sdate != null && sdate.length() > 0){
	
				if(qStrPaging.length() > 0){
					qStrPaging = qStrPaging + "&";
				}
	
				qStrPaging = qStrPaging + "dateFrom=" + sdate;
			}
	
			String edate = gvo.getDateTo();
			if(edate != null && edate.length() > 0){
	
				if(qStrPaging.length() > 0){
					qStrPaging = qStrPaging + "&";
				}
	
				qStrPaging = qStrPaging + "dateTo=" + edate;
			}
		}
	
		int totalcnt = 0;
		int totalpage = 0;
		List<GeneralVO> genList = (List<GeneralVO>)request.getAttribute("generalList");
		if(genList != null && genList.size() > 0){
			GeneralVO gen = genList.get(0);
			if(gen != null && gen.getTotalcount() != null){
				totalcnt = Integer.parseInt(gen.getTotalcount());
				int pageSize = Integer.parseInt(gen.getPagesize());
				totalpage = (int)Math.ceil(totalcnt / (double)pageSize);
			}
		}

		String curpage = "1";
		String cpage = request.getParameter("curpage");
		if(cpage != null && cpage.length() > 0){
			curpage = cpage;
		}
	%>

<c:if test="${not empty param.gregcode}">
	<!-- 조회된 상품수 카운터 -->
	<div class="list_count">
		조회된 상품 수 : <span><%=totalcnt %></span>개
	</div>
	<h5>총 <%=totalpage %>페이지 중 현재 <%=curpage %>페이지</h5>

	<div class="list_sort">
	<c:if test="${param.gsort != '1' && param.gsort != '2'}">
		<div class="tab_sort tab_sel">전체</div>
	</c:if>
	<c:if test="${param.gsort == '1' || param.gsort == '2'}">
		<div class="tab_sort"><a href="/spw/local.spw?gregcode=${param.gregcode}&cgnum=${param.cgnum}">전체</a></div>
	</c:if>
	<c:if test="${param.gsort == '1'}">
		<div class="tab_sort tab_saja tab_sel">사자</div>
	</c:if>
	<c:if test="${param.gsort != '1'}">
		<div class="tab_sort tab_saja"><a href="/spw/local.spw?gregcode=${param.gregcode}&gsort=1&cgnum=${param.cgnum}">사자</a></div>
	</c:if>
	<c:if test="${param.gsort == '2'}">
		<div class="tab_sort tab_panda tab_sel">판다</div>
	</c:if>
	<c:if test="${param.gsort != '2'}">
		<div class="tab_sort tab_panda"><a href="/spw/local.spw?gregcode=${param.gregcode}&gsort=2&cgnum=${param.cgnum}">판다</a></div>
	</c:if>
	</div>
</c:if>
<c:if test="${empty param.gregcode}">
	<div class="list_msg">
		<h3>검색을 원하는 '읍/면/동'을 선택하세요</h3>
	</div>
</c:if>
<c:if test="${empty generalList && not empty param.gregcode}">
	<div class="list_msg">
		<h3>상품이 없습니다.</h3>
	</div>
</c:if>
<c:if test="${not empty generalList}">
	<div class="list_grid">
		<ul>
			<c:forEach items="${generalList}" var="genvo">
				<li class="grid_item">
					<a href="/spw/generalDetailForm.spw?gnum=${genvo.gnum}">
						<div class="grid_item_box">
							<div class="grid_img">
							<c:if test="${genvo.gsort == '1'}">
								<div class="grid_img_label label_saja">
									사자
								</div>
							</c:if>
							<c:if test="${genvo.gsort == '2'}">
								<div class="grid_img_label label_panda">
									판다
								</div>
							</c:if>
								<img src="/spw/uploadImages/Thumb_${genvo.gphoto}">
							</div>
							<div class="grid_label">
								<h3 class="grid_title">
									${genvo.gtitle}
								</h3>
								<p class="grid_balance">
									<span>${genvo.gprice}</span>원
								</p>
							</div>
						</div>
					</a>
				</li>
				<c:set var="totalcount" value="${genvo.totalcount}"/>
			</c:forEach>
		</ul>
	</div>
	<c:if test="${param.gsort != '1' && param.gsort != '2'}">
		<div class="list_paging">
	</c:if>
	<c:if test="${param.gsort == '1'}">
		<div class="list_paging paging_saja">
	</c:if>
	<c:if test="${param.gsort == '2'}">
		<div class="list_paging paging_panda">
	</c:if>
			<jsp:include page="paging.jsp" flush="true">
				<jsp:param name="url" value="/spw/generalPList.spw"/>
				<jsp:param name="str" value="<%=qStrPaging%>"/>
				<jsp:param name="groupsize"   value="${gvo.groupsize}"/>
				<jsp:param name="pagesize"    value="${gvo.pagesize}"/>
				<jsp:param name="curpage"     value="${gvo.curpage}"/>
				<jsp:param name="totalcount"  value="${totalcount}"/>
			</jsp:include>
		</div>
</c:if>
</div>

<%@ include file="/WEB-INF/view/main/bottom.jsp" %>