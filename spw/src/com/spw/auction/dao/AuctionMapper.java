package com.spw.auction.dao;

import java.util.List;

import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;

public interface AuctionMapper {
	
	//경매상품 등록
	public int auctionInsert(AuctionVO auvo); 
	
	//경매상품 목록 
	public List<AuctionVO> auctionList(AuctionVO auvo);
	
	//경매상품 상세조회 
	public AuctionVO auctionViewDetail(AuctionVO auvo);

	//경매상품 상세보기
	public int auctionUpdate(AuctionVO auvo);
	
	//경매상품 수정 상세보기 
	public AuctionVO auctionUpdateView(AuctionVO auvo);
	
	//경매상품 상세보기 삭제 
	public int auctionDelete(AuctionVO auvo);
	
	//경매상품 종료시 상태 수정 
	public int auctionUpdateEnd(AuctionVO auvo);

	//종료된 경매 select
	public List<AuctionVO> autoSelect();
}
