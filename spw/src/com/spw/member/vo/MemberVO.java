package com.spw.member.vo;

public class MemberVO {
private String mnum;
private String mid;
private String mpw;
private String mname;
private String mphone;
private String maddr0;
private String maddr1;
private String maddr2;
private String memail;
private String mdelyn;
private String mregdate;
private String mindate;
private String mupdate;

private String madmin;//관리자여부
//페이징처리
private String pageSize;
private String groupSize;
private String curPage;
private String totalCount;

//조건검색
private String search;
private String keyword;


private String hnum;


public String getHnum() {
	return hnum;
}
public void setHnum(String hnum) {
	this.hnum = hnum;
}
public String getSearch() {
	return search;
}
public void setSearch(String search) {
	this.search = search;
}
public String getKeyword() {
	return keyword;
}
public void setKeyword(String keyword) {
	this.keyword = keyword;
}
public String getPageSize() {
	return pageSize;
}
public void setPageSize(String pageSize) {
	this.pageSize = pageSize;
}
public String getGroupSize() {
	return groupSize;
}
public void setGroupSize(String groupSize) {
	this.groupSize = groupSize;
}
public String getCurPage() {
	return curPage;
}
public void setCurPage(String curPage) {
	this.curPage = curPage;
}
public String getTotalCount() {
	return totalCount;
}
public void setTotalCount(String totalCount) {
	this.totalCount = totalCount;
}
public MemberVO() {
	
}
public MemberVO(String mnum, String mid, String mpw, String mname, String mphone, String maddr0, String maddr1,
		String maddr2, String memail, String mdelyn, String mregdate, String mindate, String mupdate, String madmin) {
	
	this.mnum = mnum;
	this.mid = mid;
	this.mpw = mpw;
	this.mname = mname;
	this.mphone = mphone;
	this.maddr0 = maddr0;
	this.maddr1 = maddr1;
	this.maddr2 = maddr2;
	this.memail = memail;
	this.mdelyn = mdelyn;
	this.mregdate = mregdate;
	this.mindate = mindate;
	this.mupdate = mupdate;
	this.madmin = madmin;
}

public MemberVO(String mid, String mpw, String mname, String mphone, String maddr0, String maddr1, String maddr2,
		String memail) {
	super();
	this.mid = mid;
	this.mpw = mpw;
	this.mname = mname;
	this.mphone = mphone;
	this.maddr0 = maddr0;
	this.maddr1 = maddr1;
	this.maddr2 = maddr2;
	this.memail = memail;
}

public String getMnum() {
	return mnum;
}
public void setMnum(String mnum) {
	this.mnum = mnum;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getMpw() {
	return mpw;
}
public void setMpw(String mpw) {
	this.mpw = mpw;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getMphone() {
	return mphone;
}
public void setMphone(String mphone) {
	this.mphone = mphone;
}
public String getMaddr0() {
	return maddr0;
}
public void setMaddr0(String maddr0) {
	this.maddr0 = maddr0;
}
public String getMaddr1() {
	return maddr1;
}
public void setMaddr1(String maddr1) {
	this.maddr1 = maddr1;
}
public String getMaddr2() {
	return maddr2;
}
public void setMaddr2(String maddr2) {
	this.maddr2 = maddr2;
}
public String getMemail() {
	return memail;
}
public void setMemail(String memail) {
	this.memail = memail;
}
public String getMdelyn() {
	return mdelyn;
}
public void setMdelyn(String mdelyn) {
	this.mdelyn = mdelyn;
}
public String getMregdate() {
	return mregdate;
}
public void setMregdate(String mregdate) {
	this.mregdate = mregdate;
}
public String getMindate() {
	return mindate;
}
public void setMindate(String mindate) {
	this.mindate = mindate;
}
public String getMupdate() {
	return mupdate;
}
public void setMupdate(String mupdate) {
	this.mupdate = mupdate;
}
public String getMadmin() {
	return madmin;
}
public void setMadmin(String madmin) {
	this.madmin = madmin;
}



}
