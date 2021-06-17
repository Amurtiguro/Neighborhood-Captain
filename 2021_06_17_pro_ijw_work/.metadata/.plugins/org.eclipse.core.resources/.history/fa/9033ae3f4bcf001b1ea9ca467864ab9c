package com.ijw.mainpage.dao;

import java.util.List;

import com.ijw.auction.vo.AuctionVO;
import com.ijw.general.vo.GeneralVO;

/**
 * 인터페이스
 * 설명
 * : 메인페이지 맵퍼 인터페이스
 
 */
public interface MainpageDao {
	/**
	 * 설명
	 * :최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : GeneralVO gvo (사자/판다 구분글)
	 * 반환값 : List<GeneralVO>
	 
	 */
	public List<GeneralVO> selectNewGeneral(GeneralVO gvo);

	/**
	 * 설명
	 * : 경매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	
	 */
	public List<AuctionVO> selectNewAuction();
}
