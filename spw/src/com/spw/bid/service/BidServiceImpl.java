package com.spw.bid.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.auction.vo.AuctionVO;
import com.spw.bid.dao.BidMapper;
import com.spw.bid.vo.BidVO;

@Service
@Transactional
public class BidServiceImpl implements BidService{
	private Logger log=Logger.getLogger(BidService.class);
	
	@Autowired
	private BidMapper bidmapper;
	
	//입찰신청 했을 때 insert 
	@Override
	public int bidInsert(BidVO bivo) {
		// TODO Auto-generated method stub
		log.info("BidServiceImpl bidInsert start >>> ");
		
		log.info("vo test >>> "+bivo.getBprice()); //입찰 요청 가격 
		log.info("vo test >>> "+bivo.getBwinyn()); //입찰여부

		int res=bidmapper.bidInsert(bivo);
		log.info("insert res >>>" +res);
		
		return res;
	}

	

	@Override
	public List<BidVO> bidSelect(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("BidServiceImpl bidSelect start >>> ");
		
		List<BidVO> listBid=bidmapper.bidSelect(auvo);
		log.info("service 경매종료된 상품 >>>> "+listBid.size());
		
		return listBid;
	}

	@Override
	public int bidUpdateWin(BidVO bivo) {
		// TODO Auto-generated method stub
		log.info("BidServiceImpl bidUpdateWin start >>> ");
		
		log.info("낙찰자 번호 >>> "+bivo.getMnum()); //입찰 요청 가격 

		int res=bidmapper.bidUpdateWin(bivo);
		log.info("낙찰자 update res >>>" +res);
		
		return res;
	}

}
