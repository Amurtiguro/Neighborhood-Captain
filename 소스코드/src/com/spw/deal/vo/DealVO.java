package com.spw.deal.vo;

public class DealVO {

	private String dnum;
	private String dcontact;
	private String ddate;
	// fk
	private String mnum;
	private String gnum;
	
	// 기본 생성자.
	public DealVO() {
	

	}
	// 생성자.
	public DealVO(String dnum, String dcontact, String ddate, String mnum, String gnum) {
		this.dnum = dnum;
		this.dcontact = dcontact;
		this.ddate = ddate;
		this.mnum = mnum;
		this.gnum = gnum;
	}
	// setter/getter.
	public String getDnum() {
		return dnum;
	}
	public void setDnum(String dnum) {
		this.dnum = dnum;
	}
	public String getDcontact() {
		return dcontact;
	}
	public void setDcontact(String dcontact) {
		this.dcontact = dcontact;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getMnum() {
		return mnum;
	}
	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	public String getGnum() {
		return gnum;
	}
	public void setGnum(String gnum) {
		this.gnum = gnum;
	}
	
	
}
