package com.spw.auction.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.auction.dao.AuctionMapper;
import com.spw.auction.vo.AuctionVO;
import com.spw.bid.vo.BidVO;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService{
	private Logger log=Logger.getLogger(AuctionServiceImpl.class);

	@Autowired
	private AuctionMapper auctionmapper;

	
	@Override
	public int auctionInsert(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionInsert start >>>  ");
		
		log.info("제목 >>> : "+auvo.getAtitle());
		log.info("카테고리 >>> : "+auvo.getCgnum());
		log.info("사진 >>> : "+auvo.getAphoto());
		log.info("시작가 >>> : "+auvo.getApricemin());
		log.info("종료시간 >>> : "+auvo.getAendtime());
		log.info("거래지역 >>> : "+auvo.getAloc());
		log.info("설명>>> : "+auvo.getAcontents());
		
		int res=auctionmapper.auctionInsert(auvo);
		log.info("insert 성공 여부 >>> "+res);
		
		return res;
	}

	//경매상품 목록
	@Override
	public List<AuctionVO> auctionList(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionList start >>>  ");
		
		if(auvo.getPagesize()==null) {
			auvo.setPagesize("16");
		}
		if(auvo.getCurpage()==null) {
			auvo.setCurpage("1");
		}
		List<AuctionVO> alist=new ArrayList<AuctionVO>();
		alist=auctionmapper.auctionList(auvo);
		log.info("alist size >>> : "+alist.size());
		
		log.info("AuctionServiceImpl auctionList end >>>  ");
		return alist;
	}

	//경매상품 상세보기
	@Override
	public AuctionVO auctionViewDetail(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionViewDetail start >>>  ");
		AuctionVO detailVO=auctionmapper.auctionViewDetail(auvo);
		return detailVO;
	}

	@Override
	public AuctionVO auctionUpdateView(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionUpdateView start >>>  ");
		AuctionVO detailVO=auctionmapper.auctionUpdateView(auvo);
		return detailVO;
	}

	//경매상품 상세보기 수정 
	@Override
	public int auctionUpdate(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionUpdate start >>>  ");
		int res=auctionmapper.auctionUpdate(auvo);
		log.info("update res >>> " +res);
		return res;
	}

	//경매상품 상세보기 삭제 
	@Override
	public int auctionDelete(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionDelete start >>>  ");
		log.info("auvo.getAnum() >>> "+auvo.getAnum());
		
		int res=auctionmapper.auctionDelete(auvo);
		log.info("delete res >>> " +res);
		
		return res;
	}

	@Override
	public int auctionUpdateEnd(AuctionVO auvo) {
		// TODO Auto-generated method stub
		log.info("AuctionServiceImpl auctionUpdateEnd start >>>  ");
		log.info("auvo.getAnum() >>> "+auvo.getAnum());
		
		int res=auctionmapper.auctionUpdateEnd(auvo);
		log.info("auctionUpdateEnd res >>> " +res);
		
		return res;
	}

	
	//경매 종료된 상품 select 
	@Override
	public List<AuctionVO> autoSelect() {
		// TODO Auto-generated method stub
		log.info("BidServiceImpl autoSelect start >>> ");
		
		List<AuctionVO> listAuto=auctionmapper.autoSelect();
		log.info("service 경매종료된 상품 갯수 >>>> "+listAuto.size());
		
		return listAuto;
	}
	
}
