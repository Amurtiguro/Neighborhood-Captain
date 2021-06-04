package com.spw.deal.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.deal.dao.DealDao;
import com.spw.deal.vo.DealVO;
import com.spw.general.dao.GeneralDao;
import com.spw.general.service.GeneralServiceImpl;

@Service
@Transactional
public class DealServiceImpl implements DealService {
	// log.
	private Logger log = Logger.getLogger(GeneralServiceImpl.class);
	
	@Autowired
	private DealDao dealDao;
	
	// 거래 신청. ================================
	@Override
	public int dealInsert(DealVO dvo) {
		// TODO Auto-generated method stub
		log.info("GeneralServiceImpl dealInsert 실행 : ");
		log.info("dvo.getDnum() : "+dvo.getDnum());
		log.info("dvo.getDcontact() : "+dvo.getDcontact());
		log.info("dvo.getDdate() : "+dvo.getDdate());
		log.info("dvo.getMnum() : "+dvo.getMnum());
		log.info("dvo.getGnum() : "+dvo.getGnum());
		int iCnt = dealDao.dealInsert(dvo);
		log.info("GeneralServiceImpl iCnt : "+iCnt);
		log.info("GeneralServiceImpl dealInsert 끝 : ");
		return iCnt;
	}
}
