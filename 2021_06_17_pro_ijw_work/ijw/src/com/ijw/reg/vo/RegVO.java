package com.ijw.reg.vo;

/*
 *
 * 클래스 RegVO
 * 설명
 * : 법정동 목록의 VO 클래스
 */
public class RegVO {

	private String regcode;	// REGCODE
	private String regname; // REGNAME
	private String regexist; // REGEXIST
	private String reglati; // REGLATI
	private String reglong; // REGLONG

	// 생성자
	public RegVO() {
		
	}

	public RegVO(String regcode
				,String regname
				,String regexist
				,String reglati
				,String reglong) {
		this.regcode = regcode;
		this.regname = regname;
		this.regexist = regexist;
		this.reglati = reglati;
		this.reglong = reglong;
	}
	
	// Getter / Setter
	public String getRegcode() {
		return regcode;
	}

	public void setRegcode(String regcode) {
		this.regcode = regcode;
	}

	public String getRegname() {
		return regname;
	}

	public void setRegname(String regname) {
		this.regname = regname;
	}

	public String getRegexist() {
		return regexist;
	}

	public void setRegexist(String regexist) {
		this.regexist = regexist;
	}

	public String getReglati() {
		return reglati;
	}

	public void setReglati(String reglati) {
		this.reglati = reglati;
	}

	public String getReglong() {
		return reglong;
	}

	public void setReglong(String reglong) {
		this.reglong = reglong;
	}
}
