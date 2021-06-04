package com.spw.mypage.vo;

public class MyPickVO {

	
	private String pnum;
	private String pdate;
	private String pdelyn;
	// fk
	private String mnum;
	private String gnum;
	
	// 찜하기테이블이랑 사자판다조인.
	private String gsort;
	private String gtitle;
	private String gphoto;
	private String gprice;
	private String gloc;
	
	// 페이징
	private String groupsize; 	// 그룹 사이즈 : 총 데이터수에 비례한 페이지 사이즈
	private String pagesize; 	// 페이지 사이즈 : 1페이지에 들어있는 데이터 수
	private String curpage; 	// 현재페이지 
	private String totalcount; 	// 총데이터수
	
	// 데이트 피커 날짜 검색
	private String dateFrom;
	private String dateTo;
	
	
	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getGroupsize() {
		return groupsize;
	}

	public void setGroupsize(String groupsize) {
		this.groupsize = groupsize;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getCurpage() {
		return curpage;
	}

	public void setCurpage(String curpage) {
		this.curpage = curpage;
	}

	public String getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}

	public String getGloc() {
		return gloc;
	}

	public void setGloc(String gloc) {
		this.gloc = gloc;
	}

	public String getGsort() {
		return gsort;
	}

	public void setGsort(String gsort) {
		this.gsort = gsort;
	}

	public String getGtitle() {
		return gtitle;
	}

	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}

	public String getGphoto() {
		return gphoto;
	}

	public void setGphoto(String gphoto) {
		this.gphoto = gphoto;
	}

	public String getGprice() {
		return gprice;
	}

	public void setGprice(String gprice) {
		this.gprice = gprice;
	}

	public MyPickVO() {

	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getPdelyn() {
		return pdelyn;
	}

	public void setPdelyn(String pdelyn) {
		this.pdelyn = pdelyn;
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
