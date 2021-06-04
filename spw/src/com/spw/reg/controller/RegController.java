package com.spw.reg.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spw.common.CommonUtil;
import com.spw.reg.service.RegService;
import com.spw.reg.vo.RegVO;

/**
 * 클래스 RegController
 * 설명
 * : 법정동코드기능을 위한 컨트롤러
 * 날짜 : 2020/07/31
 * 작성자 : 최정규
 */
@Controller
@RequestMapping("/reg")
public class RegController {
	private static Logger log = Logger.getLogger(RegController.class);

	// 서비스
	@Autowired
	RegService regService;

	/**
	 * 설명
	 * : '시/도', '시/군/구', '읍/면/동', '리' 법정동코드목록을 JSON으로 반환
	 * 매개변수 : RegVO - 법정동코드입력, String mode - 모드 선택(미입력시 시/도)
	 * 		'시/도'    : 모드 -  CP,  법정동 코드 - 사용하지 않음
	 * 		'시/군/구' : 모드 - CCD, 앞 법정동 코드 - 앞 두자리만 사용
	 * 		'읍/면/동' : 모드 - TTN, 앞 법정동 코드 - 앞 다섯자리만 사용
	 * 		'리'       : 모드 -   V, 법정동 코드 - 앞 여덟자리만 사용
	 * 반환값 : ResponseEntity (JSON 객체를 직접 출력, Content-Type과 인코딩 설정)
	 * 날짜 : 2020/08/05
	 * 작성자 : 최정규
	 */
	// JSON 객체 : {"regData" : [{"regcode": "법정동 코드", "regname": "법정동 이름"}, ...]}
	@RequestMapping("/regList")
	public ResponseEntity<String> regList(@ModelAttribute RegVO rvo
										,@RequestParam(value = "mode", required = false) String mode){
		log.info("[ regList 시작 ] rvo => " + rvo);
		log.info("[i] mode             => " + mode);

		// 법정동 코드
		String regcode = null;
		if(rvo != null) {
			regcode = rvo.getRegcode();
			log.info("[i] regcode          => " + regcode);
		}

		// 모드 (기본값 "CP" - 시/도)
		String regMode = "CP";

		// 모드 설정
		// 모드변수에 값이 있으면 적용(없으면 시/도 적용)
		// 모드에 값이 있어도 법정동코드가 없으면 시/도 적용
		if(mode !=null && mode.length() > 0
				&& regcode != null && regcode.length() > 0) {
			regMode = mode.toUpperCase();
		}

		log.info("[i] regMode          => " + regMode);

		// DB에서 법정동 목록 가져오기
		List<RegVO> regList = null;

		// 시/도
		if("CP".equals(regMode)) {
			regList = regService.regListCitPro();
		}

		// 시/군/구
		if("CCD".equals(regMode)) {
			regList = regService.regListCiCoDi(rvo);
		}

		// 읍/면/동
		if("TTN".equals(regMode)) {
			regList = regService.regListToToNe(rvo);
		}

		// 리
		if("V".equals(regMode)) {
			regList = regService.regListVillage(rvo);
		}
		
		log.info("[i] regList => " + regList);

		// JSON객체로 만들기
		JSONObject resultData = new JSONObject();

		// JSON 데이터 : regData (법정동 목록)
		JSONArray regData = new JSONArray();

		if(regList != null) {
			log.info("[i] regList size => " + regList.size());

			for(int i = 0; i < regList.size(); i++) {
				RegVO regVO = regList.get(i);

				JSONObject regRowData = new JSONObject();

				regRowData.put("regcode", regVO.getRegcode());
				
				regRowData.put("regname", regVO.getRegname());

				log.info("[i] regRowData => " + regRowData);
				regData.add(regRowData);
			}
		}

		resultData.put("regData", regData);

		// JSON객체를 클라이언트에게 출력

		ResponseEntity<String> resEntity = CommonUtil.responseJSON(resultData.toJSONString());

		log.info("[ regList 종료 ] resEntity => " + resEntity);
		return resEntity;
	}

}
