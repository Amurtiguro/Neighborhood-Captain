package com.spw.general.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spw.general.vo.GeneralCountVO;
import com.spw.general.vo.GeneralVO;
import com.spw.reg.vo.RegVO;

public class GeneralDaoImpl extends SqlSessionDaoSupport implements GeneralDao {
	private static Logger log = Logger.getLogger(GeneralDaoImpl.class);
	
	// 전체 글 목록 : generalAllList ==========================
	@Override
	public List<GeneralVO> generalAllList(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalAllList 시작 >>");
		
		List<GeneralVO> aList = getSqlSession().selectList("query.generalDao.generalAllList");
		log.info("GeneralDaoImpl.generalAllList : aList >>" + aList);
		
		log.info("GeneralDaoImpl.generalAllList 끝 >>");
		return aList;
	}
	// 사자 글 목록 : generalSList ==========================
	@Override
	public List<GeneralVO> generalSList(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalSList 시작 >>");
		
		List<GeneralVO> sList = getSqlSession().selectList("query.generalDao.generalSList");
		
		log.info("GeneralDaoImpl.generalSList 끝 >>");
		return sList;
	}

	// 판다 글 목록 : generalPList ==========================
	@Override
	public List<GeneralVO> generalPList(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalPList 시작 >>");
		
		List<GeneralVO> pList = getSqlSession().selectList("query.generalDao.generalPList");
		
		log.info("GeneralDaoImpl.generalPList 끝 >>");
		return pList;
	}

	// 글 상세 : generalSelect ========================
	@Override
	public GeneralVO generalSelect(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalSelect 시작 >>");
		
		GeneralVO select = getSqlSession().selectOne("query.generalDao.generalSelect");
		log.info("GeneralDaoImpl.generalSelect : select >>" + select);
		
		log.info("GeneralDaoImpl.generalSelect 끝 >>");
		return select;
	}

	// 글 입력 : generalInsert ========================
	@Override
	public int generalInsert(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalInsert 시작 >>");
		
		int insert = getSqlSession().insert("query.generalDao.generalInsert");
		log.info("GeneralDaoImpl.generalSelect : insert >>" + insert);
		
		log.info("GeneralDaoImpl.generalInsert 끝 >>");
		return insert;
	}

	// 글 수정 : generalUpdate ========================
	@Override
	public int generalUpdate(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalUpdate 시작 >>");
		
		int update = getSqlSession().update("query.generalDao.generalUpdate");
		log.info("GeneralDaoImpl.generalSelect : update >>" + update);
		
		log.info("GeneralDaoImpl.generalUpdate 끝 >>");
		return update;
	}

	// 글 삭제 : generalDelete ========================
	@Override
	public int generalDelete(GeneralVO gvo) {
		log.info("GeneralDaoImpl.generalDelete 시작 >>");
		
		int delete = getSqlSession().delete("query.generalDao.generalDelete");
		log.info("GeneralDaoImpl.generalSelect : delete >>" + delete);
		
		log.info("GeneralDaoImpl.generalDelete 시작 >>");
		return delete;
	}
	
	private static String PACKAGE_PATH = "com.spw.general.dao.GeneralDao.";

	/**
	 * 설명
	 * : 법정동 코드로 동네별 상품목록 조회
	 * 매개변수 : GeneralVO gvo - 페이지 번호, 그룹 사이즈, 페이지 사이즈, 법정동 코드
	 * 반환값 : List<GeneralVO> - 상품목록
	 * 날짜 : 2020/08/13
	 * 작성자 : 최정규
	 */
	public List<GeneralVO> generalSelectLocal(GeneralVO gvo){
		log.info("[ generalSelectLocal() 시작 ] gvo => " + gvo);

		List<GeneralVO> list = getSqlSession().selectList(PACKAGE_PATH + "generalSelectLocal");

		log.info("[ generalSelectLocal() 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 법정동 코드로 시군구의 동네별 상품개수 조회
	 * 매개변수 : RegVO rvo - 법정동 코드
	 * 반환값 : List<GeneralCountVO> - 동네별 상품개수
	 * 날짜 : 2020/08/13
	 * 작성자 : 최정규
	 */
	public List<GeneralCountVO> generalSelectCount(RegVO rvo){
		log.info("[ generalSelectCount() 시작 ] rvo => " + rvo);

		List<GeneralCountVO> list = getSqlSession().selectList(PACKAGE_PATH + "generalSelectCount");

		log.info("[ generalSelectCount() 종료 ] list => " + list);
		return list;
	}
}
