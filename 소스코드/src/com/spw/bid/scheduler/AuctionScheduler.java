package com.spw.bid.scheduler;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spw.auction.service.AuctionService;
import com.spw.auction.vo.AuctionVO;
import com.spw.bid.service.BidService;
import com.spw.bid.vo.BidVO;
import com.spw.notice.service.NoticeService;
import com.spw.notice.vo.NoticeVO;

@Component
public class AuctionScheduler {
	private Logger log=Logger.getLogger(AuctionScheduler.class);
	
	@Autowired
	private BidService bidservice;
	
	@Autowired 
	private AuctionService auctionservice;
	
	@Autowired 
	private NoticeService noticeservice;
	
	//낙찰자가 있는 경매 게시글 수 
	int countO=0;
	
	//낙찰자가 없는 경매 게시글 수 
	int countX=0;
	
	//경매가 종료된 총 게시글 수 
	int tot=1;
	
	/**
	 * 설명
	 * : 상품의 종료시간이 지났고, 경매상태가 1(경매진행중)인  
	 * 경매글번호(anum), 글 작성한 회원번호(mnum) 목록 조회
	 * 매개변수 : 없음. 
	 * 반환값 : void
	 * 날짜 : 2020/08/
	 * 작성자 : 조하영
	 */
	// fixedRate=1000 1초마다 
	@Scheduled(cron="0 09 12 * * *")
	public void autoSelect() {
		log.info("AuctionScheduler autoSelect start >>> ");

		List<AuctionVO> listAuto=auctionservice.autoSelect();
		log.info(">>>>> 불러온 목록 개수 "+listAuto.size());
		
		for(int i=0;i<listAuto.size();i++) {
			log.info(" 경매번호 >>> "+listAuto.get(i).getAnum());
			bidSelect(listAuto.get(i));
		}		
		
		log.info("\n================결과 ================");
		log.info("입찰된 경매 게시글 수 >>> "+countO);
		log.info("입찰되지 않은 경매 게시글 수 >>> "+countX);
		int total=countO+countX;
		log.info("수정된 총 게시글 수 >>> "+total);
		log.info("\n================결과 ================");
	}
	
	
	/**
	 * 설명
	 * : autoSelect()에서 조회된 상품의 입찰자 여부에 따라 
	 * 매개변수 : auvo 
	 * 반환값 : void
	 * 날짜 : 
	 * 작성자 : 조하영
	 */
	public void bidSelect(AuctionVO auvo) {
		log.info("AuctionScheduler bidSelect start >>> ");

		
		//최고가 입찰 정보 
		List<BidVO> listBid=bidservice.bidSelect(auvo);
		log.info(">>>>> 불러온 목록 개수 "+listBid.size());
		
		NoticeVO novo=new NoticeVO();
		
		//입찰자가 1명 이상일 경우
		if(listBid.size()>0) {
			log.info("<<<<경매번호 "+auvo.getAnum()+" :: 입찰자 o>>>>");
			
			
			//(입찰 table) 최고가 입찰자 컬럼 bwinyn에 ‘y’로 update
			int bidUpdateWinRes=bidservice.bidUpdateWin(listBid.get(0));
			log.info("경매 상품 낙찰자 bwinyn update >>>"+bidUpdateWinRes);
			log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tot);
			
			//(알림 table) 최고가 입찰자에게 알림 insert
			novo.setNmnum(auvo.getMnum());
			novo.setNsort("4");
			novo.setNinfo(listBid.get(0).getBprice());
			novo.setNurl("/spw/auctionViewDetail.spw?anum="+auvo.getAnum());
			novo.setMnum(listBid.get(0).getMnum());
			int notiInsertResA=noticeservice.notiInsertAuct(novo);
			log.info("경매 상품 낙찰자 알림 insert >>>"+notiInsertResA);
			
			//(알림 table) 게시물 작성자에게 알림 insert
			novo.setNmnum(listBid.get(0).getMnum());
			novo.setNsort("2");
			novo.setNinfo(listBid.get(0).getBprice());
			novo.setNurl("/spw/auctionViewDetail.spw?anum="+auvo.getAnum());
			novo.setMnum(auvo.getMnum());
			int notiInsertResB=noticeservice.notiInsertAuct(novo);
			log.info("경매 상품 작성자 알림 insert >>>"+notiInsertResB);
			
			//(경매 table) 경매상태구분(asort) 변경 update
			int auctionUpdateEnd=auctionservice.auctionUpdateEnd(auvo);
			log.info("경매 상태 종료 update >>>"+auctionUpdateEnd);
			
			tot++;
			countO++;
		}else{
			//입찰자가 없을 경우
			log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tot);
			log.info("<<<<경매번호 "+auvo.getAnum()+" :: 입찰자 x>>>>");
			
			//(알림 table) 게시물 작성자에게 알림 insert
			novo.setNmnum("");
			novo.setNsort("3");
			novo.setNinfo("");
			novo.setNurl("/spw/auctionViewDetail.spw?anum="+auvo.getAnum());
			novo.setMnum(auvo.getMnum());
			int notiInsertResA=noticeservice.notiInsertAuct(novo);
			log.info("경매 상품 작성자 알림 insert >>>"+notiInsertResA);

			//(경매 table) 경매상태구분(asort) 변경 update
			int auctionUpdateEnd=auctionservice.auctionUpdateEnd(auvo);
			log.info("경매 상태 종료 update >>>"+auctionUpdateEnd);

			tot++;
			countX++;
		}
		
	}
}



