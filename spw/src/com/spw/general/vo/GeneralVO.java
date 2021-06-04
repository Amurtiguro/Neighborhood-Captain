package com.spw.general.vo;

public class GeneralVO {
	private String gnum;   		// 일반 상품번호
	private String gsort;  		// 구분
	private String gtitle; 		// 제목
	private String gloc;    	// 거래지역
	private String gregcode;    // 법정동코드
	private String gphoto;  	// 사진
	private String grephoto;  	// 리사이즈사진
	private String gprice; 		// 가격
	private String gcontents; 	// 설명
	private String gstatus; 	// 상태
	private String gdelyn; 	    // 삭제여부
	private String gregdate; 	// 등록일
	private String gupdate;  	// 수정일
	// 받아오는 값
	private String mnum; 		// 회원번호
	private String cgnum; 		// 카테고리 코드
	private String cgname;
	private String mid;
	// 페이징
	private String groupsize; 	// 그룹 사이즈 : 총 데이터수에 비례한 페이지 사이즈
	private String pagesize; 	// 페이지 사이즈 : 1페이지에 들어있는 데이터 수
	private String curpage; 	// 현재페이지 
	private String totalcount; 	// 총데이터수
	
	
	// 데이트 피커 날짜 검색
	private String dateFrom;
	private String dateTo;
	
	public String getGrephoto() {
		return grephoto;
	}
	public void setGrephoto(String grephoto) {
		this.grephoto = grephoto;
	}
	public String getCgname() {
		return cgname;
	}
	public void setCgname(String cgname) {
		this.cgname = cgname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
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
	public String getGnum() {
		return gnum;
	}
	public void setGnum(String gnum) {
		this.gnum = gnum;
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
	public String getGloc() {
		return gloc;
	}
	public void setGloc(String gloc) {
		this.gloc = gloc;
	}
	public String getGregcode() {
		return gregcode;
	}
	public void setGregcode(String gregcode) {
		this.gregcode = gregcode;
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
	public String getGcontents() {
		return gcontents;
	}
	public void setGcontents(String gcontents) {
		this.gcontents = gcontents;
	}
	public String getGstatus() {
		return gstatus;
	}
	public void setGstatus(String gstatus) {
		this.gstatus = gstatus;
	}
	public String getGdelyn() {
		return gdelyn;
	}
	public void setGdelyn(String gdelyn) {
		this.gdelyn = gdelyn;
	}
	public String getGregdate() {
		return gregdate;
	}
	public void setGregdate(String gregdate) {
		this.gregdate = gregdate;
	}
	public String getGupdate() {
		return gupdate;
	}
	public void setGupdate(String gupdate) {
		this.gupdate = gupdate;
	}
	public String getMnum() {
		return mnum;
	}
	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	public String getCgnum() {
		return cgnum;
	}
	public void setCgnum(String cgnum) {
		this.cgnum = cgnum;
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

};

