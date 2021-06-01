package com.spw.general.service;

import java.util.List;

import com.spw.general.vo.GeneralCountVO;
import com.spw.general.vo.GeneralVO;
import com.spw.reg.vo.RegVO;

public interface GeneralService {
	// 전체 글 목록 : generalAllList ==========================
	public List<GeneralVO> generalAllList(GeneralVO gvo);
	
	// 사자 글 목록 : generalSList ==========================
	public List<GeneralVO> generalSList(GeneralVO gvo);
	
	// 판다 글 목록 : generalPList ==========================
	public List<GeneralVO> generalPList(GeneralVO gvo);
	
	// 글 상세 : generalSelect ========================
	public GeneralVO generalSelect(GeneralVO gvo);
	
	// 글 입력 : generalInsert ========================
	public int generalInsert(GeneralVO gvo);
	
	// 글 수정 : generalUpdate ========================
	public int generalUpdate(GeneralVO gvo);
	
	// 글 삭제 : generalDelete ========================
	public int generalDelete(GeneralVO gvo);

	/**
	 * 설명
	 * : 법정동 코드로 동네별 상품목록 조회
	 * 매개변수 : GeneralVO gvo - 페이지 번호, 그룹 사이즈, 페이지 사이즈, 법정동 코드
	 * 반환값 : List<GeneralVO> - 상품목록
	 * 날짜 : 2020/08/13
	 * 작성자 : 최정규
	 */
	public List<GeneralVO> generalSelectLocal(GeneralVO gvo);

	/**
	 * 설명
	 * : 법정동 코드로 시군구의 동네별 상품개수 조회
	 * 매개변수 : RegVO rvo - 법정동 코드
	 * 반환값 : List<GeneralCountVO> - 동네별 상품개수
	 * 날짜 : 2020/08/13
	 * 작성자 : 최정규
	 */
	public List<GeneralCountVO> generalSelectCount(RegVO rvo);
}
