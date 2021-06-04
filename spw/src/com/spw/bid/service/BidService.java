package com.spw.bid.service;

import java.util.List;

import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;

public interface BidService {

	//입찰 데이터 insert
	public int bidInsert(BidVO bivo) ;
	
	//종료된 경매 상품에 대한 입찰 정보 select
	public List<BidVO> bidSelect(AuctionVO auvo);

	//최고가로 입찰한 사람 낙찰여부 변경
	public int bidUpdateWin(BidVO bivo);
	
}
