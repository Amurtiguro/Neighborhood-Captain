package com.ijw.category.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ijw.category.dao.CategoryDao;
import com.ijw.category.vo.CategoryVO;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	private static Logger log = Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDao categoryDao;

	/**
	 * 설명
	 * : 카테고리목록을 반환
	 * 매개변수 : 없음
	 * 반환값 : List (CategoryVO)
	 
	 */
	public List<CategoryVO> categoryList(){
		log.info("[categoryList 시작]");

		List<CategoryVO> list = categoryDao.categoryList();

		log.info("[categoryList 종료] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 카테고리코드를 받아서 코드에 해당되는 카테고리를 반환
	 * 매개변수 : CategoryVO cvo - 카테고리 코드
	 * 반환값 : List (CategoryVO)
	 
	 */
	public List<CategoryVO> categorySelect(CategoryVO cvo){
		log.info("[categorySelect 시작] cvo => " + cvo);

		List<CategoryVO> list = categoryDao.categorySelect(cvo);

		log.info("[categorySelect 종료] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 카테고리 등록
	 * 매개변수 : CategoryVO cvo - 카테고리 이름
	 * 반환값 : int - 입력된 데이터(카테고리) 수
	
	 */
	public int categoryInsert(CategoryVO cvo) {
		log.info("[categoryInsert 시작] cvo => " + cvo);

		int cnt = categoryDao.categoryInsert(cvo);

		log.info("[categoryInsert 종료] cnt => " + cnt);
		return cnt;
	}

	/**
	 * 설명
	 * : 카테고리 편집
	 * 매개변수 : CategoryVO cvo - 카테고리 코드, 이름
	 * 반환값 : int - 편집된 데이터(카테고리) 수
	 
	 */
	public int categoryUpdate(CategoryVO cvo) {
		log.info("[categoryUpdate 시작] cvo => " + cvo);

		int cnt = categoryDao.categoryUpdate(cvo);

		log.info("[categoryUpdate 종료] cnt => " + cnt);
		return cnt;
	}
}
