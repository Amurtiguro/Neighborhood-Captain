package com.ijw.mainpage.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ijw.auction.vo.AuctionVO;
import com.ijw.general.vo.GeneralVO;
import com.ijw.mainpage.dao.MainpageDao;
import com.ijw.mainpage.dao.MainpageDaoImpl;

/**
 * 클래스
 * 설명
 * : 메인페이지 서비스 클래스

 */
@Service
@Transactional
public class MainpageServiceImpl implements MainpageService{
	private static Logger log = Logger.getLogger(MainpageServiceImpl.class);

	private static String PACKAGE_PATH = "com.ijw.mainpage.dao.MainpageDao.";

	@Autowired
	private MainpageDao mainpageDao;

	/**
	 * 설명
	 * : 구매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	 
	 */
	public List<GeneralVO> selectNewSaja(){
		log.info("[ selectNewSaja 시작 ]");

		GeneralVO gvo = new GeneralVO();
		gvo.setGsort("1");

		List<GeneralVO> list = mainpageDao.selectNewGeneral(gvo);

		log.info("[ selectNewSaja 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 판매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	 
	 */
	public List<GeneralVO> selectNewPanda(){
		log.info("[ selectNewPanda 시작 ]");

		GeneralVO gvo = new GeneralVO();
		gvo.setGsort("2");

		List<GeneralVO> list = mainpageDao.selectNewGeneral(gvo);

		log.info("[ selectNewPanda 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 경매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	 
	 */
	public List<AuctionVO> selectNewAuction(){
		log.info("[ selectNewAuction 시작 ]");

		List<AuctionVO> list = mainpageDao.selectNewAuction();

		log.info("[ selectNewAuction 종료 ] list => " + list);
		return list;
	}

}
