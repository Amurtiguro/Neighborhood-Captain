package com.spw.auction.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;

public class AuctionMapperImpl extends SqlSessionDaoSupport implements AuctionMapper{
	private Logger log=Logger.getLogger(AuctionMapperImpl.class);
	
	//경매상품등록
	//query문의 id, method name, mapper에서 호출 string 모두 같아야 함.
	@Override
	public int auctionInsert(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().insert("auctionInsert");
	}

	//경매상품 목록 조회
	@Override
	public List<AuctionVO> auctionList(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("auctionList");
	}

	//경매상품 상세보기
	@Override
	public AuctionVO auctionViewDetail(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("auctionViewDetail");
	}

	//경매상품 상세보기 수정
	@Override
	public int auctionUpdate(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("auctionUpdate");
	}

	//경매상품 수정 상세 뷰 
	@Override
	public AuctionVO auctionUpdateView(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("auctionUpdateView");
	}
	
	//경매상품 상세보기 삭제
	@Override
	public int auctionDelete(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("auctionDelete");
	}

	@Override
	public int auctionUpdateEnd(AuctionVO auvo) {;
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("auctionUpdateEnd");
	}
	
	//경매종료된 상품 select
	@Override
	public List<AuctionVO> autoSelect() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("autoSelect");
	}

}
