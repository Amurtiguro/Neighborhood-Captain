package com.spw.notice.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.bid.vo.BidVO;
import com.spw.notice.dao.NoticeMapper;
import com.spw.notice.vo.NoticeVO;

@Transactional
@Service
public class NoticeServiceImpl implements NoticeService{
	private Logger log=Logger.getLogger(NoticeServiceImpl.class);
			
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public int notiInsertAuct(NoticeVO novo) {
		// TODO Auto-generated method stub
		log.info("NoticeServiceImpl notiInsertAuct start >>> ");
		
		log.info("novo.getMnum() >>> "+novo.getMnum());
		log.info("novo.getMnum() >>> "+novo.getMnum());
		log.info("novo.getMnum() >>> "+novo.getMnum());
		log.info("novo.getMnum() >>> "+novo.getMnum());
		
		int res=noticeMapper.notiInsertAuct(novo);
		
		log.info("결과 >>>> "+res);
		return res;
	}


	// 알림 추가. ================================
	@Override
	public int noticeInsert(NoticeVO nvo) {
		// TODO Auto-generated method stub
		log.info("NoticeServiceImpl noticeInsert 실행 : ");
		log.info("nvo.getNnum() : "+nvo.getNnum());
		log.info("nvo.getNmid() : "+nvo.getNmnum());
		log.info("nvo.getNcontents() : "+nvo.getNsort());
		log.info("nvo.getNinfo() : "+nvo.getNinfo());
		log.info("nvo.getNurl() : "+nvo.getNurl());
		log.info("nvo.getNdelyn() : "+nvo.getNdelyn());
		log.info("nvo.getNsenddate() : "+nvo.getNsenddate());
		log.info("nvo.getMnum() : "+nvo.getMnum());
		
		int iCnt = noticeMapper.noticeInsert(nvo);
		log.info("NoticeServiceImpl : "+iCnt);
		log.info("NoticeServiceImpl noticeInsert 끝 : ");
		return iCnt;
	}
}
