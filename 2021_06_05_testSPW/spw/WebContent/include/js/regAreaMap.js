function regAreaMap(map, fnClickMore){
	// 선택된 다각형
	var polySelected = null;

	// 선택된 다각형의 법정동 코드
	var codeSelected = null;

	// 선택된 다각형의 스타일
	var styleSelected = null;

	// 다각형들을 저장한 배열
	var polygonArray = null;

	// 다각형 스타일
	var polyStyle = {
		// 기본(둘다 0이거나 같을때)
		same: {
			// 일반
			normal: {
				fillColor: '#DDD', // 채우기 색깔
			},
			// 마우스가 올라감
			hover: {
				fillColor: '#AAA', // 채우기 색깔
			},
			// 선택됨
			selected: {
				fillColor: '#1994FF', // 채우기 색깔
			}
		},
		// 사자가 더 많을때
		sajaMore: {
			// 일반
			normal: {
				fillColor: '#EE6B28', // 채우기 색깔
			},
			// 마우스가 올라감
			hover: {
				fillColor: '#DD651B', // 채우기 색깔
			},
			// 선택됨
			selected: {
				fillColor: '#1994FF', // 채우기 색깔
			}
		},
		// 판다가 더 많을때
		pandaMore: {
			// 일반
			normal: {
				fillColor: '#454F59', // 채우기 색깔
			},
			// 마우스가 올라감
			hover: {
				fillColor: '#343E48', // 채우기 색깔
			},
			// 선택됨
			selected: {
				fillColor: '#1994FF', // 채우기 색깔
			}
		}
	};

	// 다각형에 마우스 오버시 표시될 오버레이 (호버 오버레이)
	var overInfo = new kakao.maps.CustomOverlay({
		removable: false,
		content: "<div class='overInfo' id='overInfo'>"
					+ "<span class='nameTxt'>Text</span>"
					+ "[<span class='sajaTxt'>000</span>"
					+ "/<span class='pandaTxt'>000</span>]"
					+ "</div>"
	});

	var clickInfoContent = $("<div class='clickInfo' id='clickInfo'>"
							+ "<h3 class='fullName'>Text</h3>"
							+ "<p class='sajaTxt'>사자 : <span>000</span>건</p>"
							+ "<p class='pandaTxt'>판다 : <span>000</span>건</p>"
							+ "<div class='clickInfoBtn'></div>"
							+ "</div>");

	var clickInfoBtnMore = $("<input type='button' id='btnInfoMore' class='sitebtn' value='더보기'>");
	var clickInfoBtnClose = $("<input type='button' id='btnInfoClose' class='sitebtn' value='닫기'>");

	clickInfoContent.find(".clickInfoBtn").append(clickInfoBtnMore);
	clickInfoContent.find(".clickInfoBtn").append(clickInfoBtnClose);

	// 다각형 클릭시 표시될 오버레이 (클릭 오버레이)
	var clickInfo = new kakao.maps.CustomOverlay({
		clickable: true,
		removable: false,
		content: clickInfoContent[0]
	});

	// 클릭 오버레이 닫기
	function closeClickOverlay(){
		console.log("closeClickOverlay");
		// 오버레이 닫기

		// 텍스트 제거 
		$("#clickInfo > .fullName").text("");
		$("#clickInfo > .sajaTxt > span").text("");
		$("#clickInfo > .pandaTxt > span").text("");

		// 맵에서 없애기
		clickInfo.setMap(null);

		// 영역 색 변경(원상복구)
		polySelected.setOptions(styleSelected.normal);

		// 선택된 영역 선택 해제하기
		polySelected = null;

		// 선택된 법정동(영역)의 이름도 지우기
		codeSelected = "";

		// 선택된 법정동(영역)의 스타일도 지우기
		styleSelected = null;
	}

	clickInfoBtnClose.click(function(){
		closeClickOverlay();
	});

	// 클릭 오버레이에서 더보기 버튼 클릭
	clickInfoBtnMore.click(function(){
		// 이동하기(파라미터로 선택된 영역의 법정동 코드를 포함해서)

		if(fnClickMore != null){
			fnClickMore(codeSelected);
		}
	});

	// 경로배열로 지도에 표시할 다각형을 생성하고 표시
	// 기존 다각형들은 삭제(놔두면 겹쳐진다/느려진다)
	function displayPoly(areas, generals){
		console.log("displayPoly");
		console.log(areas);
		console.log(generals);

		var generalData = null;
		if(generals != null){
			generalData = generals;
		}

		// 기존 다각형 삭제
		if(polygonArray != null){
			for(var i = 0; i < polygonArray.length; i++){
				polygonArray[i].setMap(null);
			}
		}

		// 다각형들을 저장한 배열 초기화
		polygonArray = [];
		for(var i = 0; i < areas.length; i++){
			var areaPathData = areas[i];

			var generalCountData = null;
			if(areaPathData != null && areaPathData.hasOwnProperty("code")){
				console.log("다각형 법정동 코드 => ", areaPathData.code);

				var genCode = "reg_" + areaPathData.code;
				if(generals.hasOwnProperty(genCode)){
					generalCountData = generals[genCode];
				}
			}
			console.log("generalCountData => ", generalCountData);

			polygonArray[i] = displayOnePoly(areaPathData, generalCountData);
		}

		function displayOnePoly(oneArea, genData){
			// 지도에 표시할 다각형을 생성
			var polyArea = new kakao.maps.Polygon({
				path: oneArea.path, // 그려질 다각형의 좌표 배열
				strokeWeight: 2, // 선의 두께
				strokeColor: '#777', // 선의 색깔
				strokeOpacity: 0.7, // 선의 불투명도 (1에서 0 사이의 값, 0에 가까울수록 투명)
				strokeStyle: 'solid', // 선의 스타일
				fillOpacity: 0.7 // 채우기 불투명도
			});

			// 해당 다각형(동네)에서 등록된 상품개수
			var countData = {
				saja: 0,
				panda: 0
			}

			if(genData != null){
				countData = genData;
			}
			console.log("상품 데이터 => ", countData)

			var areaStyle = polyStyle.same;
			if(countData.saja > countData.panda){
				areaStyle = polyStyle.sajaMore;
			}else if(countData.saja < countData.panda){
				areaStyle = polyStyle.pandaMore;
			}
			
			// 영역 색 설정하기
			polyArea.setOptions(areaStyle.normal);

			// 지도에 다각형을 표시
			polyArea.setMap(map);

			// 이벤트 등록
			// 마우스를 올렸을때
			kakao.maps.event.addListener(polyArea, "mouseover", function(mEvent){
				// 이미 선택된 영역은 무시
				if(polyArea == polySelected){
					return;
				}

				// 호버 오버레이 열기
				// 위치설정
				overInfo.setPosition(mEvent.latLng);

				// 표시할 맵 설정
				overInfo.setMap(map);

				// 텍스트 설정
				$("#overInfo > .nameTxt").text(oneArea.name.kor);
				$("#overInfo > .sajaTxt").text(countData.saja);
				$("#overInfo > .pandaTxt").text(countData.panda);

				// 영역 색 변경하기
				polyArea.setOptions(areaStyle.hover);

			});

			// 마우스를 움직였을때
			kakao.maps.event.addListener(polyArea, "mousemove", function(mEvent){
				// 이미 선택된 영역은 무시
				if(polyArea == polySelected){
					return;
				}

				// 호버 오버레이 위치 변경
				overInfo.setPosition(mEvent.latLng);
			});

			// 마우스가 영역을 나갔을때
			kakao.maps.event.addListener(polyArea, "mouseout", function(mEvent){
				// 이미 선택된 영역은 무시
				if(polyArea == polySelected){
					return;
				}

				// 호버 오버레이 닫기
				overInfo.setMap(null);

				// 영역 색 변경하기(원상복구)
				polyArea.setOptions(areaStyle.normal);

			});

			// 클릭했을때
			kakao.maps.event.addListener(polyArea, "click", function(mEvent){
				if(polyArea == polySelected){
					// 클릭 오버레이 닫기
					closeClickOverlay();
				}else{
					if(polySelected != null){
						// 클릭 오버레이 닫기
						closeClickOverlay();
					}

					// 호버 오버레이 닫기
					overInfo.setMap(null);

					// 클릭 오버레이 열기
					// 위치설정
					clickInfo.setPosition(mEvent.latLng);

					// 표시할 맵 설정
					clickInfo.setMap(map);

					// 텍스트 설정
					$("#clickInfo > .fullName").text(oneArea.name.full);
					$("#clickInfo > .sajaTxt > span").text(countData.saja);
					$("#clickInfo > .pandaTxt > span").text(countData.panda);

					// 선택된 영역 등록하기
					polySelected = polyArea;

					// 영역 색 변경하기
					polyArea.setOptions(areaStyle.selected);

					// 선택된 법정동(영역)의 코드 저장하기
					codeSelected = oneArea.code;

					// 선택된 법정동(영역)의 스타일 저장하기
					styleSelected = areaStyle;
				}
			});

			return polyArea;
		}
	}

	// GEOJSON 지형 데이터를 DAUM지도에 표시할 다각형 경로객체로 변환
	// 결과물 {name: (읍/면/동_이름){eng: 영문, kor: 한글, full: 전체이름(한글)}, code: 읍/면/동_법정코드, path: [경로배열]}
	function getPathData(geoData){
		console.log("[ getPathData ]");
		console.log(geoData);

		// 읍/면/동_이름
		// 한글
		var geoName_kr = geoData.properties.emd_kor_nm;

		// 전체
		var geoName_full = geoData.properties.full_nm;

		// 영문
		var geoName_eng = geoData.properties.emd_eng_nm;

		// 읍/면/동_법정코드
		var geoCode = geoData.properties.emd_cd + "00";

		// 다각형 경로
		// 지형 데이터의 타입(폴리곤, 멀티폴리곤) 확인
		var geoType = geoData.geometry.type;

		// 지형 데이터의 좌표객체
		var geoCoords = geoData.geometry.coordinates;

		// 경로배열 구하기
		var pathArr = null;

		if(geoType == "MultiPolygon"){
			// 멀티폴리곤
			pathArr = [];

			for(var i = 0; i < geoCoords.length; i++){
				var coords = geoCoords[i];
				var path = coordToPath(coords);

				for(var j = 0; j < path.length; j++){
					pathArr.push(path[j]);
				}
			}
		}else if(geoType == "Polygon"){
			// 폴리곤
			pathArr = coordToPath(geoCoords);
		}

		//console.log(pathArr);

		// 좌표배열을 경로배열로 변환
		function coordToPath(coordinates){
			var result = [];

			for(var i = 0; i < coordinates.length; i++){
				var coord = coordinates[i];

				var result1 = [];

				for(var j = 0; j < coord.length; j++){
					var latlng = coord[j];

					result1[j] = new kakao.maps.LatLng(latlng[1], latlng[0]);
				}

				result[i] = result1;
			}

			return result;
		}

		var pathData = {
				name: {
					kor: geoName_kr,
					eng: geoName_eng,
					full: geoName_full
				},
				code: geoCode,
				path: pathArr
		};

		console.log("결과 => ", pathData);
		return pathData;
	}

	// 지도 영역 좌표(bbox)배열을 통해 지도의 축척과, 표시위치 재설정
	function setBoundary(boundArr){
		// 영역 끄트머리에 좌표 객체 만들기(2개)
		var markerPin = [
			new kakao.maps.LatLng(boundArr[1], boundArr[0]),
			new kakao.maps.LatLng(boundArr[3], boundArr[2])
		];

		// 범위정보 객체 생성
		var boundaryArea = new kakao.maps.LatLngBounds(markerPin[0], markerPin[1]);

		// 지도범위 재설정
		map.setBounds(boundaryArea);
	}

	// 입력한 법정동코드('시/군/구' 혹은 '읍/면동'한정)의 GEOJSON 지형 데이터를 Ajax로 추출한뒤, 지도에 그리기
	function getArea(regCode){
		console.log("[ getArea ] regCode => " + regCode);

		// 법정동 코드가 있을때만 작동되게 하기
		if(regCode == null || regCode == ""){
			return;
		}

		// 호버 오버레이, 클릭 오버레이 닫기
		overInfo.setMap(null);
		clickInfo.setMap(null);

		// URL
		var areaURL = "/spw/regArea.spw";

		// 법정동 코드('시/군/구' 혹은 '읍/면동'한정)
		var datas = {regcode: regCode};

		// 성공
		function whenSuccess(data){
			console.log("가져온 데이터 => ", data);
			console.log("상태 => ", data.status);

			// 데이터를 성공적으로 가져왔다면 (status가 OK라면)
			if(data.status == "OK"){
				// 영역정보 가져오기
				var boundBox = data.boundary;
				console.log("영역정보 => ", boundBox);

				// 지도영역 설정하기
				setBoundary(boundBox);

				// areaData 가져오기
				var areaData = data.areaData;
				console.log("areaData => ", areaData);

				// generalData 가져오기
				var generalData = data.generalData;
				console.log("generalData => ", generalData);

				// areaData가 null이 아니라면
				if(areaData != null && areaData.length > 0){
					var pathDataArr = [];

					for(var i = 0; i < areaData.length; i++){
						// areaData를 다각형 경로객체로 변환하기
						pathDataArr[i] = getPathData(areaData[i]);
					}
					console.log("다각형 경로 객체 => ", pathDataArr);

					// 지도에 표시
					displayPoly(pathDataArr, generalData);

				}

			}else{
				console.log("API데이터 가져오기 실패");
			}
		}

		// 실패
		function whenError(){
			console.log("데이터 가져오기 실패");
		}

		$.ajax({
			url : areaURL,
			type : "GET",
			data : datas,
			success : whenSuccess,
			error : whenError
		});
	}

	return {getArea: getArea};
}