package com.spw.common;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 클래스
 * 설명
 * : 여러곳에서 사용되는 기능들을 함수로 만들어서 담은 클래스
 * 날짜 : 2020/08/11
 * 작성자 : 최정규
 */
public abstract class CommonUtil {
	private static Logger log = Logger.getLogger(CommonUtil.class);

	/**
	 * 설명
	 * : JSON문자열을 응답할때 Content-Type도 설정해주는 함수
	 * 매개변수 : String jsonStr - JSON문자열
	 * 반환값 : ResponseEntity - Controller 에 반환값으로 설정하면 JSON문자열을 응답(한글 안깨짐)
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public static ResponseEntity<String> responseJSON(String jsonStr){
		int strLen = -1;

		if(jsonStr != null) {
			strLen = jsonStr.length();
		}

		log.info("[responseJSON] jsonStr length (-1 = null) => " + strLen);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");

		return new ResponseEntity<String>(jsonStr, headers, HttpStatus.OK);
	}
}
