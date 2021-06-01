package com.spw.reg.dao;

import java.util.List;

import com.spw.reg.vo.RegVO;

/**
 * 클래스 RegMapper
 * 설명
 * : 법정동코드 DB테이블 'REG_LIST'의 매퍼 인터페이스
 * 날짜 : 2020/07/30
 * 작성자 : 최정규
 */
public interface RegDao {

	/**
	 * 설명
	 * : '시/도' 법정동코드목록을 반환
	 * 매개변수 : 없음
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListCitPro();

	/**
	 * 설명
	 * : '시/군/구' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 두자리만)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListCiCoDi(RegVO rvo);
	
	/**
	 * 설명
	 * : '읍/면/동' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 다섯자리만)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListToToNe(RegVO rvo);
	
	/**
	 * 설명
	 * : '리' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드(앞 여덟자리만)입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
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
	List<RegVO> regListSelect(RegVO rvo);

}
