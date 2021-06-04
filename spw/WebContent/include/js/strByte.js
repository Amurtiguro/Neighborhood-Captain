// 문자열의 바이트 길이를 구하는 함수 (UTF-8)
// str : 문자열
function getByteLength(str){

	// 문자열을 URI인코딩(퍼센트 인코딩)
	var strEnc = encodeURI(str);

	// 정규표현식을 통해 배열로 변환
	// (% 와 두글자 or 한글자)
	// 바이트 길이 + 1만큼의 배열이 반환됨 (내용물은 전부 빈 문자열)
	var encArr = strEnc.split(/%..|./);

	// 배열의 크기 - 1
	return encArr.length - 1;
}

// 문자열을 원하는 바이트 길이만큼 자르는 함수 (UTF-8)
// str : 문자열 , size : 바이트 길이
function substrByte(str, size){

	// 전체문자열의 바이트 길이
	var strByteLen = 0;

	// 문자열의 길이
	var strLen = str.length;

	// 문자열 인덱스
	var i;

	for(i = 0; i < strLen; i++){
		// 문자열 하나
		var oneStr = str.charAt(i);
		var oneStrSize = getByteLength(oneStr);

		// 바이트길이가 원하는 바이트길이보다 크면 종료
		if(strByteLen + oneStrSize > size){
			break;
		}

		// 문자열 하나의 바이트길이를 전체문자열 바이트 길이에 추가
		strByteLen += oneStrSize;

	}

	// 문자열 인덱스 까지 자르기
	return str.substring(0, i);
}