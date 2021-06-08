<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("siteTitle", "동네별 조회 - 지도로 보기");
%>
<%@include file="/WEB-INF/view/main/top1.jsp" %>
<%@include file="/WEB-INF/view/main/top2.jsp" %>
	<h2 class="list_title">동네별 조회 - 지도로 보기</h2>
	<div class="regarea_sel">
		<select id="regCitPro" name="regCitPro" class="siteselect">
			<option value="SEL">시/도</option>
		</select>
		<select id="regCiCoDi" name="regCiCoDi" class="siteselect">
			<option value="SEL">시/군/구</option>
		</select>
		<input type="button" id="btnFind" class="sitebtn label_default" value="찾기">
	</div>
	<div class="regarea_wrap">
		<div id="map" class="areamap"></div>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b4172322671d1cc9e49a261f3c75475"></script>
	<script type="text/javascript" src="/spw/include/js/reglist.js"></script>
	<script type="text/javascript" src="/spw/include/js/regAreaMap.js"></script>
	<script type="text/javascript">

		$(document).ready(function(){

			// 지도
			// 지도를 출력할 요소
			var mapContainer = document.getElementById("map");
	
			// 지도 속성
			// (일단은)한반도 전체표시
			var mapOption = {
					// 중심
					center : new kakao.maps.LatLng("36.19603455891698", "127.40809317666739"),
					// 확대 레벨
					level: 13,
					// 더블클릭 확대 막기
					disableDoubleClickZoom: true
			};

			// 지도객체 생성및 표시
			var map = new kakao.maps.Map(mapContainer, mapOption);

			var areaMap = regAreaMap(map, function(regcode){
				console.log("선택된 영역의 법정동코드 => " + regcode);
				location.href="/spw/local.spw?gregcode=" + regcode;
			});

			// 찾기버튼
			$("#btnFind").click(function(){
				console.log("[찾기버튼 Click]");

				var regCiCoDi = $selCiCoDi.val();
				var regToToNe = $selToToNe.val();
				console.log("regCiCoDi => ", regCiCoDi);
				console.log("regToToNe => ", regToToNe);

				var regcode = null;

				if(regCiCoDi != null && regCiCoDi != "SEL"){
					if(regToToNe != null && regToToNe != "SEL"){
						regcode = regToToNe;
					}else{
						regcode = regCiCoDi;
					}
				}

				console.log("regcode => ", regcode);
				if(regcode != null && regcode != ""){
					areaMap.getArea(regcode);
				}else{
					alert("시/군/구를 선택하세요");
				}
			});

			// 드롭박스
			// 드롭박스 객체
			var $selCitPro = $("#regCitPro");
			var $selCiCoDi = $("#regCiCoDi");
			var $selToToNe = $("#regToToNe");
	
			// 시/도 목록 가져와서 드롭박스에 출력하기
			setSelectList($selCitPro, null, "CP");
	
			// 드롭박스에 이벤트 할당하기
			// 시/도 -> 시/군/구
			$selCitPro.change(function(){
				setSelectList($selCiCoDi, $selCitPro, "CCD");
			});
		});

	</script>
<%@include file="/WEB-INF/view/main/bottom.jsp" %>