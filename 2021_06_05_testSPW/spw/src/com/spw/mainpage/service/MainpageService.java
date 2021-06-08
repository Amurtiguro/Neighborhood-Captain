package com.spw.mainpage.service;

import java.util.List;

import com.spw.auction.vo.AuctionVO;
import com.spw.general.vo.GeneralVO;

/**
 * 인터페이스
 * 설명
 * : 메인페이지 서비스 인터페이스
 * 날짜 : 2020/08/23
 * 작성자 : 최정규
 */
public interface MainpageService {
	/**
	 * 설명
	 * : 사자 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	 * 날짜 : 2020/08/23
	 * 작성자 : 최정규
	 */
	public List<GeneralVO> selectNewSaja();

	/**
	 * 설명
	 * : 판다 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	 * 날짜 : 2020/08/23
	 * 작성자 : 최정규
	 */
	public List<GeneralVO> selectNewPanda();

	/**
	 * 설명
	 * : 경매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	 * 날짜 : 2020/08/23
	 * 작성자 : 최정규
	 */
	public List<AuctionVO> selectNewAuction();
}
