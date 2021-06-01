<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("siteTitle", "목록 레이아웃");
%>
<%@include file="/WEB-INF/view/main/top.jsp" %>
<%-- <jsp:include page="/category/list.spw">
	<jsp:param name="qString" value="gregcode=${gvo.gregcode}&gsort=${gvo.gsort}"/>
</jsp:include> --%>

<!-- 상품리스트(그리드) -->
<div class="list_contents">
	<div class="list_top">

		<h2 class="list_title">동네별 조회</h2>

		<!-- 카테고리 -->
		<div class="categoryList">
			<ul>
				<li class="cglistRow">
					<a href="#임시">전체</a>
				</li>
				<li class="cglist">
					<a href="#임시">패션잡화</a>
				</li>
				<li class="cglist">
					<a href="#임시">여성의류</a>
				</li>
				<li class="cglist">
					<a href="#임시">남성의류</a>
				</li>
				<li class="cglist">
					<span>디지털/가전</span>
				</li>
				<li class="cglist">
					<a href="#임시">도서/티켓/취미/애완</a>
				</li>
				<li class="cglist">
					<a href="#임시">생활/문구/가구/식품</a>
				</li>
				<li class="cglist">
					<a href="#임시">유아동/출산</a>
				</li>
				<li class="cglist">
					<a href="#임시">스포츠/레저</a>
				</li>
				<li class="cglist">
					<a href="#임시">뷰티/미용</a>
				</li>
				<li class="cglist">
					<a href="#임시">기타</a>
				</li>
			</ul>
		</div>
		<div class="search_by_date">
			날짜
			<input type="text" id="startime" class="sitetxt" size="15">
			~
			<input type="text" id="endTime" class="sitetxt" size="15">
			<input type="button" value="조회" id="btnSerachByDate" class="sitebtn">
		</div>
		<div class="reg_find">
			<form method="GET" action="/spw/general/local.spw" id="formQstr">
				<input type="text" id="gregcodeT" name="gregcode" value="${gvo.gregcode}" readonly>
				<input type="text" id="gsortT" name="gsotr" value="${gvo.gsort}" readonly>
				<input type="text" id="cgnumT" name="cgnum" value="${gvo.cgnum}" readonly>
				<input type="text" id="startdateT" name="startdate" value="${gvo.startdate}" readonly>
				<input type="text" id="enddateT" name="enddate" value="${gvo.enddate}" readonly>
			</form>
			<div id="regInfo" class="reg_info">
				<span>선택한 지역 :</span>
				<span class="reg_name">서울특별시 금천구 가산동</span>
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
				<a href="#임시" class="sitebtn">지도로 보기</a>
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

					$("#regInfo").show();
					$("#regSelect").hide();

				});
			</script>
		</div>
	</div>
	<div class="list_grid">
		<div class="list_grid_count">
			조회된 상품 수 : <span>127</span>개
		</div>
		<ul>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<div class="grid_img_label label_saja">
								사자
							</div>
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<div class="grid_img_label label_panda">
								판다
							</div>
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
			<li class="grid_item">
				<a href="#임시">
					<div class="grid_item_box">
						<div class="grid_img">
							<img src="imgplaceholder.png">
						</div>
						<div class="grid_label">
							<h3 class="grid_title">
								제목
							</h3>
							<p class="grid_balance">
								<span>1,000,000</span>원
							</p>
						</div>
					</div>
				</a>
			</li>
		</ul>
	</div>
	<div class="list_paging paging_saja">
		<span class="sitebtn">◁◁</span>
		<span class="sitebtn">◁</span>
		<a href="#페이징" class="sitebtn">1</a>
		<a href="#페이징" class="sitebtn">2</a>
		<span class="sitebtn paging_selected">3</span>
		<a href="#페이징" class="sitebtn">4</a>
		<a href="#페이징" class="sitebtn">5</a>
		<a href="#페이징" class="sitebtn">▶</a>
		<a href="#페이징" class="sitebtn">▶▶</a>
	</div>
</div>

<%@ include file="/WEB-INF/view/main/bottom.jsp" %>