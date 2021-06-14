package com.spw.reg.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.reg.vo.RegVO;

/**
 * 클래스 RegMapperImpl
 * 설명
 * : 법정동코드 DB테이블의 매퍼클래스 ('RegMapper' 인터페이스의 구현체)
 * 날짜 : 2020/07/30
 * 작성자 : 최정규
 */
public class RegDaompl extends SqlSessionDaoSupport implements RegDao {
	private static Logger log = Logger.getLogger(RegDaompl.class);

	private static String PACKAGE_PATH = "com.spw.reg.dao.RegDao.";

	/**
	 * 설명
	 * : '시/도' 법정동코드목록을 반환
	 * 매개변수 : 없음
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
	 * 작성자 : 최정규
	 */
	public List<RegVO> regListCitPro() {
		log.info("[ regListCitPro() 실행 ]");

		List<RegVO> list = getSqlSession().selectList(PACKAGE_PATH + "regListCitPro");

		log.info("[ regListCitPro() 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : '시/군/구' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListCiCoDi(RegVO rvo) {
		log.info("[ regListCiCoDi() 실행 ]");

		List<RegVO> list = getSqlSession().selectList(PACKAGE_PATH + "regListCiCoDi");

		log.info("[ regListCiCoDi() 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : '읍/면/동' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListToToNe(RegVO rvo) {
		log.info("[ regListToToNe() 실행 ]");

		List<RegVO> list = getSqlSession().selectList(PACKAGE_PATH + "regListToToNe");

		log.info("[ regListToToNe() 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : '리' 법정동코드목록을 반환
	 * 매개변수 : RegVO - 법정동코드입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/30
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListVillage(RegVO rvo) {
		log.info("[ regListVillage() 실행 ]");

		List<RegVO> list = getSqlSession().selectList(PACKAGE_PATH + "regListVillage");

		log.info("[ regListVillage() 종료 ] list => " + list);
		return list;
	}
	
	/**
	 * 설명
	 * : 선택한 법정동 코드의 정보를 반환
	 * 매개변수 : RegVO - 법정동코드입력
	 * 반환값 : List (RegVO)
	 * 날짜 : 2020/07/31
	 * 작성자 : 최정규
	 */
	@Override
	public List<RegVO> regListSelect(RegVO rvo) {
		log.info("[ regListVillage() 실행 ]");
		
		List<RegVO> list = getSqlSession().selectList(PACKAGE_PATH + "regListFromCode");
		
		log.info("[ regListVillage() 종료 ] list => " + list);
		return list;
	}
}
