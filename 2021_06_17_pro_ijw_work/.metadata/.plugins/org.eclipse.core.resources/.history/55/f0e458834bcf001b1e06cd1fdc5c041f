package com.ijw.bid.dao;

import java.util.List;

import com.ijw.auction.vo.AuctionVO;
import com.ijw.bid.vo.BidVO;

public interface BidMapper {
	
	//입찰 데이터 insert
	public int bidInsert(BidVO bivo) ;
	
	//종료된 경매 상품에 대한 입찰 정보 select
	public List<BidVO> bidSelect(AuctionVO auvo);
	
	//최고가로 입찰한 사람 낙찰여부 변경
	public int bidUpdateWin(BidVO bivo);
}
