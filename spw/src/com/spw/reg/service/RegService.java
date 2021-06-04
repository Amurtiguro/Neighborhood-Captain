package com.spw.reg.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.spw.reg.vo.RegVO;

/**
 * 클래스 RegService
 * 설명
 * : 법정동코드와 관련된 기능을 위한 서비스 인터페이스
 * 날짜 : 2020/07/31
 * 작성자 : 최정규
 */
public interface RegService {

	/**
	 * 설명
	 * : '시/도' 법정동코드목록을 반환
	 * 매개변수 : 없음
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListCitPro();

	/**
	 * 설명
	 * : '시/군/구' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 두자리만 사용)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListCiCoDi(RegVO rvo);

	/**
	 * 설명
	 * : '읍/면/동' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 다섯자리만 사용)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListToToNe(RegVO rvo);

	/**
	 * 설명
	 * : '리' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 여덟자리만 사용)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListVillage(RegVO rvo);

	/**
	 * 설명
	 * : 선택한 법정동 코드의 정보를 반환
	 * 매개변수 : RegVO - 법정동코드입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListSelect(RegVO rvo);

	/**
	 * 설명
	 * : 국토 교통부의 오픈 API를통해
	 *   영역정보를 JSON형식으로 가져오기
	 * 매개변수 : RegVO - 법정동이름입력
	 * 반환값 : JSONObject - API결과물을 그대로 반환
	 * 날짜 : 2020/08/04
	 * 작성자 : 최정규
	 * @throws Exception 
	 */
	public JSONObject getRegArea(RegVO rvo);
}
