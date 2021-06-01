<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>지도로 보기</title>
<script type="text/javascript" src="/spw/js/jquery-1.12.0.js"></script>
<style>
	.overInfo{
		position: absolute;
		top: -0.25em;
		left: 0.75em;
		background: #FFF;
		border: solid 1px #CCC;
		border-radius: 0.25em;
		padding: 0.25em;
	}

	.clickInfo{
		position: absolute;
		bottom: 1em;
		background: #FFF;
		border: solid 1px #CCC;
		border-radius: 0.25em;
		padding: 0.25em;
	}

	.clickInfo > h3{
		margin: 0;
	}

	.clickInfo > p{
		margin: 0.125em;
	}
</style>
</head>
<body>
	<div id="map" style="width: 900px; height: 750px"></div>
	<div>
		<select id="regCitPro" name="regCitPro">
			<option value="SEL">시/도</option>
		</select>
		<select id="regCiCoDi" name="regCiCoDi">
			<option value="SEL">시/군/구</option>
		</select>
		
		<input type="button" id="btnFind" value="찾기">
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f02ddfa08ad3a34b08b53cfc78e4dda9"></script>
	<script type="text/javascript" src="/spw/js/reglist.js"></script>
	<script type="text/javascript" src="/spw/js/regAreaMap.js"></script>
	<script type="text/javascript">

		$(document).ready(function(){

			// 지도
			// 지도를 출력할 요소
			var mapContainer = document.getElementById("map");
	
			// 지도 속성
			// (일단은)한반도 전체표시
			var mapOption = {
					// 중심
					center : new kakao.maps.LatLng("36.93693610580019", "127.9387083040443"),
					// 확대 레벨
					level: 14,
					// 더블클릭 확대 막기
					disableDoubleClickZoom: true
			};

			// 지도객체 생성및 표시
			var map = new kakao.maps.Map(mapContainer, mapOption);

			var areaMap = regAreaMap(map, function(regcode){
				console.log("선택된 영역의 법정동코드 => " + regcode);
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
</body>
</html>