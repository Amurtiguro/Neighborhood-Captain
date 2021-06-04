package com.spw.category.vo;

/**
 * 클래스
 * 설명
 * :카테고리 VO 클래스
 * 날짜 : 2020/08/06
 * 작성자 : 최정규
 */
public class CategoryVO {

	private String cgnum;
	private String cgname;

	// 생성자
	public CategoryVO() {
		
	}

	public CategoryVO(String cgnum, String cgname) {
		super();
		this.cgnum = cgnum;
		this.cgname = cgname;
	}

	// getter/setter
	public String getCgnum() {
		return cgnum;
	}

	public void setCgnum(String cgnum) {
		this.cgnum = cgnum;
	}

	public String getCgname() {
		return cgname;
	}

	public void setCgname(String cgname) {
		this.cgname = cgname;
	}

}
