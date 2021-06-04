package com.spw.category.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.category.vo.CategoryVO;

/**
 * 클래스
 * 설명
 * : 카테고리 DB테이블 'CATEGORY_LIST'의 매퍼 클래스
 * 날짜 : 2020/08/06
 * 작성자 : 최정규
 */
public class CategoryDaoImpl extends SqlSessionDaoSupport implements CategoryDao{
	private static Logger log = Logger.getLogger(CategoryDaoImpl.class);

	private static String PACKAGE_PATH = "com.spw.category.dao.CategoryDao.";

	/**
	 * 설명
	 * : 카테고리목록을 반환
	 * 매개변수 : 없음
	 * 반환값 : List (CategoryVO)
	 * 날짜 : 2020/08/06
	 * 작성자 : 최정규
	 */
	@Override
	public List<CategoryVO> categoryList() {
		log.info("[ categoryList() 실행 ]");

		List<CategoryVO> list = getSqlSession().selectList(PACKAGE_PATH + "categoryList");

		log.info("[ categoryList() 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 카테고리코드를 받아서 코드에 해당되는 카테고리를 반환
	 * 매개변수 : CategoryVO cvo - 카테고리 코드
	 * 반환값 : List (CategoryVO)
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	@Override
	public List<CategoryVO> categorySelect(CategoryVO cvo) {
		log.info("[ categorySelect() 실행 ] cvo => " + cvo);

		List<CategoryVO> list = getSqlSession().selectList(PACKAGE_PATH + "categorySelect");

		log.info("[ categorySelect() 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 카테고리 등록
	 * 매개변수 : CategoryVO cvo - 카테고리 이름
	 * 반환값 : int - 입력된 데이터(카테고리) 수
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	@Override
	public int categoryInsert(CategoryVO cvo) {
		log.info("[ categoryInsert() 실행 ] cvo => " + cvo);

		int cnt = getSqlSession().insert(PACKAGE_PATH + "categoryInsert");

		log.info("[ categoryInsert() 종료 ] cnt => " + cnt);
		return cnt;
	}

	/**
	 * 설명
	 * : 카테고리 편집
	 * 매개변수 : CategoryVO cvo - 카테고리 코드, 이름
	 * 반환값 : int - 편집된 데이터(카테고리) 수
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	@Override
	public int categoryUpdate(CategoryVO cvo) {
		log.info("[ categoryUpdate() 실행 ] cvo => " + cvo);

		int cnt = getSqlSession().insert(PACKAGE_PATH + "categoryUpdate");

		log.info("[ categoryUpdate() 종료 ] cnt => " + cnt);
		return cnt;
	}

}
