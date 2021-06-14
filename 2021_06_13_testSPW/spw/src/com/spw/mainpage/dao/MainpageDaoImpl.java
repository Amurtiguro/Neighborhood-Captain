package com.spw.mainpage.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.auction.vo.AuctionVO;
import com.spw.general.vo.GeneralVO;

/**
 * 클래스
 * 설명
 * : 메인페이지 맵퍼 클래스
 * 날짜 : 2020/08/23
 * 작성자 : 최정규
 */
public class MainpageDaoImpl extends SqlSessionDaoSupport implements MainpageDao{
	private static Logger log = Logger.getLogger(MainpageDaoImpl.class);

	private static String PACKAGE_PATH = "com.spw.mainpage.dao.MainpageDao.";

	/**
	 * 설명
	 * : 사자/판다 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : GeneralVO gvo (사자/판다 구분글)
	 * 반환값 : List<GeneralVO>
	 * 날짜 : 2020/08/23
	 * 작성자 : 최정규
	 */
	public List<GeneralVO> selectNewGeneral(GeneralVO gvo){
		log.info("[ selectNewGeneral ]");

		return getSqlSession().selectList(PACKAGE_PATH + "selectNewGeneral");
	}

	/**
	 * 설명
	 * : 경매 최근글 4개 반환(진행중이고, 삭제되지 않은글)
	 * 매개변수 : 없음
	 * 반환값 : List<GeneralVO>
	 * 날짜 : 2020/08/23
	 * 작성자 : 최정규
	 */
	public List<AuctionVO> selectNewAuction(){
		log.info("[ selectNewAuction ]");

		return getSqlSession().selectList(PACKAGE_PATH + "selectNewAuction");
	}
}
