package com.ijw.mainpage.service;

import java.util.List;

import com.ijw.auction.vo.AuctionVO;
import com.ijw.general.vo.GeneralVO;

/**
 * 인터페이스
 * 설명
 * : 메인페이지 서비스 인터페이스
 
 */
public interface MainpageService {
	/**
	 * 설명
	 * 구매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	
	 */
	public List<GeneralVO> selectNewSaja();

	/**
	 * 설명
	 * : 판매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	
	 */
	public List<GeneralVO> selectNewPanda();

	/**
	 * 설명
	 * : 경매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	
	 */
	public List<AuctionVO> selectNewAuction();
}
