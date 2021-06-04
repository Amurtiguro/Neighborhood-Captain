package com.spw.bid.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;


public class BidMapperImpl extends SqlSessionDaoSupport implements BidMapper{
	private Logger log=Logger.getLogger(BidMapperImpl.class);
	
	//입찰신청 했을 때 insert 
	@Override
	public int bidInsert(BidVO bivo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().insert("bidInsert");
	}

	
	@Override
	public List<BidVO> bidSelect(AuctionVO auvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("bidSelect");
	}

	@Override
	public int bidUpdateWin(BidVO bivo) {
		// TODO Auto-generated method stub
		return getSqlSession().update("bidUpdateWin");
	}

}
