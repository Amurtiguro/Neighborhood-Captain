package com.spw.auction.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;

public class AuctionMapperImpl extends SqlSessionDaoSupport implements AuctionMapper{
	private Logger log=Logger.getLogger(AuctionMapperImpl.class);
	
	//寃쎈ℓ�긽�뭹�벑濡�
	//query臾몄쓽 id, method name, mapper�뿉�꽌 �샇異� string 紐⑤몢 媛숈븘�빞 �븿.
	@Override
	public int auctionInsert(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().insert("auctionInsert");
	}

	//寃쎈ℓ�긽�뭹 紐⑸줉 議고쉶
	@Override
	public List<AuctionVO> auctionList(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("auctionList");
	}

	//寃쎈ℓ�긽�뭹 �긽�꽭蹂닿린
	@Override
	public AuctionVO auctionViewDetail(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("auctionViewDetail");
	}

	//寃쎈ℓ�긽�뭹 �긽�꽭蹂닿린 �닔�젙
	@Override
	public int auctionUpdate(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("auctionUpdate");
	}

	//寃쎈ℓ�긽�뭹 �닔�젙 �긽�꽭 酉� 
	@Override
	public AuctionVO auctionUpdateView(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("auctionUpdateView");
	}
	
	//寃쎈ℓ�긽�뭹 �긽�꽭蹂닿린 �궘�젣
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
	
	//寃쎈ℓ醫낅즺�맂 �긽�뭹 select
	@Override
	public List<AuctionVO> autoSelect() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("autoSelect");
	}

}
