package com.spw.general.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.general.dao.GeneralDao;
import com.spw.general.vo.GeneralCountVO;
import com.spw.general.vo.GeneralVO;
import com.spw.reg.vo.RegVO;

@Service
@Transactional
public class GeneralServiceImpl implements GeneralService {

	// log.
	private Logger log = Logger.getLogger(GeneralServiceImpl.class);
	
	@Autowired
	private GeneralDao generalDao;

	// 전체 글 목록 출력: generalAllList ==========================
	@Override
	public List<GeneralVO> generalAllList(GeneralVO gvo) {
		log.info("GeneralServiceImpl.generalAllList 시작 >>");
		log.info("groupsize >>> " + gvo.getGroupsize());		
		log.info("pagesize >>> " + gvo.getPagesize());		
		log.info("curpage >>> " + gvo.getCurpage());		
		log.info("totalcount >>> " + gvo.getTotalcount());		
		
		// generalAllList 출력을 위해 ArrayList 소환
		List<GeneralVO> aList = new ArrayList<GeneralVO>();
		// 변수 list에 dao.list를 가져옴
		aList = generalDao.generalAllList(gvo);
		log.info("GeneralServiceImpl.generalAllList : aList >>" + aList);
		
		log.info("GeneralServiceImpl.generalAllList 끝 >>");
		return aList;
	}
	
	// 사자 글 목록 출력: generalSList ==========================
	@Override
	public List<GeneralVO> generalSList(GeneralVO gvo) {
		log.info("GeneralServiceImpl.generalSList 시작 >>");
		
		List<GeneralVO> sList = new ArrayList<GeneralVO>();
		sList = generalDao.generalSList(gvo);
		log.info("GeneralServiceImpl.generalSList : sList  >>");
		log.info("groupsize >>> " + gvo.getGroupsize());		
		log.info("pagesize >>> " + gvo.getPagesize());		
		log.info("curpage >>> " + gvo.getCurpage());		
		log.info("totalcount >>> " + gvo.getTotalcount());		
		log.info("GeneralServiceImpl.generalSList 끝 >>");
		return sList;
	}
	
	// 판다 글 목록 출력: generalPList ==========================
	@Override
	public List<GeneralVO> generalPList(GeneralVO gvo) {
		log.info("GeneralServiceImpl.generalPList 시작 >>");
		
		List<GeneralVO> pList = new ArrayList<GeneralVO>();
		pList = generalDao.generalPList(gvo);
		log.info("GeneralServiceImpl.generalPList : pList >>" + pList);
		
		log.info("GeneralServiceImpl.generalPList 끝 >>");
		return pList;
	}

	// 글 상세 : generalSelect ========================
	@Override
	public GeneralVO generalSelect(GeneralVO gvo) {
		log.info("GeneralServiceImpl.generalSelect 시작 >>");
		
		GeneralVO select = generalDao.generalSelect(gvo);
		
		log.info("GeneralServiceImpl.generalSelect 끝 >>");
		return select;
	}

	// 글 입력 : generalInsert ========================
	@Override
	public int generalInsert(GeneralVO gvo) {
		log.info("GeneralServiceImpl.generalInsert 시작 >>");
		
		// insert를 실행하고 결과값을 반환
		int insert = generalDao.generalInsert(gvo);
		log.info("GeneralServiceImpl.generalInsert : insert >>" + insert);
		
		log.info("GeneralServiceImpl.generalInsert 끝 >>");
		return insert;
	}

	// 글 수정 : generalUpdate ========================
	@Override
	public int generalUpdate(GeneralVO gvo) {
		log.info("GeneralServiceImpl.generalUpdate 시작 >> ");
		
		int update = generalDao.generalUpdate(gvo);
		log.info("GeneralServiceImpl.generalInsert : update >>" + update);
		
		log.info("GeneralServiceImpl.generalUpdate 끝 >> ");
		return update;
	}

	// 글 삭제 : generalDelete ========================
	@Override
	public int generalDelete(GeneralVO gvo) {
		log.info("GeneralServiceImpl.generalDelete 시작 >> ");
		
		int delete = generalDao.generalDelete(gvo);
		log.info("GeneralServiceImpl.generalInsert : delete >>" + delete);
		
		log.info("GeneralServiceImpl.generalDelete 끝 >> ");
		return delete;
	}
	
	/**
	 * 설명
	 * : 법정동 코드로 동네별 상품목록 조회
	 * 매개변수 : GeneralVO gvo - 페이지 번호, 그룹 사이즈, 페이지 사이즈, 법정동 코드
	 * 반환값 : List<GeneralVO> - 상품목록
	 * 날짜 : 2020/08/13
	 * 작성자 : 최정규
	 */
	public List<GeneralVO> generalSelectLocal(GeneralVO gvo){
		log.info("[ generalSelectLocal 시작 ] gvo => " + gvo);

		List<GeneralVO> list = generalDao.generalSelectLocal(gvo);

		log.info("[ generalSelectLocal 종료 ] list => " + list);
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
		log.info("[ generalSelectCount 시작 ] rvo => " + rvo);

		List<GeneralCountVO> list = generalDao.generalSelectCount(rvo);

		log.info("[ generalSelectCount 종료 ] list => " + list);
		return list;
	}
}
