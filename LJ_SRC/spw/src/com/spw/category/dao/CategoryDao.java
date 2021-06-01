package com.spw.category.dao;

import java.util.List;

import com.spw.category.vo.CategoryVO;

/**
 * 클래스
 * 설명
 * : 카테고리 DB테이블 'CATEGORY_LIST'의 매퍼 인터페이스
 * 날짜 : 2020/08/06
 * 작성자 : 최정규
 */
public interface CategoryDao {

	/**
	 * 설명
	 * : 카테고리목록을 반환
	 * 매개변수 : 없음
	 * 반환값 : List (CategoryVO)
	 * 날짜 : 2020/08/06
	 * 작성자 : 최정규
	 */
	public List<CategoryVO> categoryList();

	/**
	 * 설명
	 * : 카테고리코드를 받아서 코드에 해당되는 카테고리를 반환
	 * 매개변수 : CategoryVO cvo - 카테고리 코드
	 * 반환값 : List (CategoryVO)
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	public List<CategoryVO> categorySelect(CategoryVO cvo);

	/**
	 * 설명
	 * : 카테고리 등록
	 * 매개변수 : CategoryVO cvo - 카테고리 이름
	 * 반환값 : int - 입력된 데이터(카테고리) 수
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	public int categoryInsert(CategoryVO cvo);

	/**
	 * 설명
	 * : 카테고리 편집
	 * 매개변수 : CategoryVO cvo - 카테고리 코드, 이름
	 * 반환값 : int - 편집된 데이터(카테고리) 수
	 * 날짜 : 2020/08/07
	 * 작성자 : 최정규
	 */
	public int categoryUpdate(CategoryVO cvo);
}
