// 드롭박스값 변경시 해당 값과 일치하는 목록을 target에 출력하는 함수
// target : 목록을 출력할 드롭박스
// ele : 값이 변경된 드롭박스
// mode : 모드(getRegData와 동일)
function setSelectList(target, ele, mode){
	// ele드롭박스에서 법정동 코드값 가져오기
	var regcode = null;
	if(ele != null){
		regcode = ele.val();
	}
	console.log("regCode", regcode);

	// target의 기본값(첫번째 option) 담아두기
	var optDefault = target.find("option")[0];

	// ele드롭박스에 선택된값이 없으면(기본값이면) target만 비우기
	if(regcode == "SEL"){
		clearTargetBox(optDefault);
		return;
	}

	// 목록 가져와서 ele드롭박스에 출력하기
	getRegData(function(data){
		console.log("[ CitPro ] data => ", data);

		// 목록데이터만 가져오기
		var regData = data.regData;

		// ele드롭박스에 선택된 option의 텍스트 가져오기
		var strSel = null;

		if(ele != null){
			strSel = ele.find(":checked").text();
		}

		console.log("strSel => " + strSel);

		// target 목록 비우기
		clearTargetBox(optDefault);

		// target에 목록채우기
		for(var i = 0; i < regData.length; i++){
			var regObj = regData[i];
			console.log("regObj => ", regObj);

			// target의 목록에서
			// ele드롭박스에서 선택된 option의 텍스트와 중복되는부분 제거
			var startPoint = regObj.regname.indexOf(strSel);

			if(startPoint < 0){
				startPoint = 0;
			}else{
				startPoint = startPoint + strSel.length + 1;
			}

			var rName = regObj.regname.substr(startPoint);

			// option객체 만들고 target에 담기
			var optReg = $("<option>").attr("value", regObj.regcode).text(rName);

			target.append(optReg);
		}

	}, null, mode, regcode);

	// target의 드롭박스를 비워주는 함수
	// defaultOption : 기본적으로 있어야하는 option요소
	function clearTargetBox(defaultOption){
		// target 비우기
		target.empty();

		// target에 기본option요소 다시 추가하기
		target.append(optDefault);

		// target이 변경되었으므로 change이벤트 발생
		target.change();
	}
}

// 성공함수와 실패함수, 모드와 법정동 코드를 받아서 AJAX로 데이터를 받아서 처리하는 함수
// 성공함수는 무조건 있어야하며, 실패함수 없을시 alert로 실패메세지 출력
// 모드와 법정동코드가 없거나, 모드만 있으면 시/도 법정동 코드를 반환
// 모드
// '시/도'    : CP
// '시/군/구' : CCD
// '읍/면/동' : TTN
// '리'       : V
function getRegData(fnSuccess, fnFail, mode, regcode){
	console.log("[getRegData]");
	console.log("fnSuccess => ", fnSuccess);
	console.log("fnFail    => ", fnFail);
	console.log("mode      => ", mode);
	console.log("regcode   => ", regcode);

	// 성공함수가 없으면 종료
	if(fnSuccess == null){
		return;
	}

	// 실패함수가 없으면 기본값
	if(fnFail == null){
		fnFail = function(){
			alert("동네 데이터를 가져오는데 실패했습니다.");
		}
	}

	// 모드와 법정동 코드가 둘다 있을때만 모드를 설정  
	var regMode = "CP";
	if(mode != null && mode != ""
			&& regcode != null && regcode != ""){
		regMode = mode;
	}

	// 법정동 목록 요청시 필요한 데이터
	var dataSend = {
			"mode": regMode,
			"regcode": regcode
	};

	// AJAX로 법정동 데이터 가져오기
	$.ajax({
		url : "/spw/reg/regList.spw",
		type : "GET",
		contentType : "application/json; charset=UTF-8",
		data : dataSend,
		success : fnSuccess,
		error : fnFail
	});
}