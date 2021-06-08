package com.spw.auction.vo;

public class AuctionVO {
	
	//경매상품 변수
	private String anum;
	private String asort;
	private String atitle;
	private String aloc;
	private String aphoto;
	private String arephoto;
	private String apricemin;
	private String aendtime;
	private String acontents;
	private String astatus;
	private String adelyn;
	private String aregdate;
	private String aupdate;
	private String mnum;
	private String cgnum;
	
	//상세페이지를 위한 변수
	private String cgname;
	private String mid;
	
	//페이징 변수
	private String groupsize;
	private String pagesize;
	private String curpage;
	private String totalcount;
	private String pageno;
	
	//기간별 검색 변수
	private String searchTerm;
	private String dateFrom;
	private String dateTo;
	
	//경매 최고가 변수
	private String bidhighprice;

	public AuctionVO() {}
	
	public AuctionVO(String anum, String asort, String atitle, String aloc, String aphoto, String arephoto,
			String apricemin, String aendtime, String acontents, String astatus, String adelyn, String aregdate,
			String aupdate, String mnum, String cgnum, String cgname, String mid, String groupsize, String pagesize,
			String curpage, String totalcount, String pageno, String searchTerm, String dateFrom, String dateTo,
			String bidhighprice) {
		this.anum = anum;
		this.asort = asort;
		this.atitle = atitle;
		this.aloc = aloc;
		this.aphoto = aphoto;
		this.arephoto = arephoto;
		this.apricemin = apricemin;
		this.aendtime = aendtime;
		this.acontents = acontents;
		this.astatus = astatus;
		this.adelyn = adelyn;
		this.aregdate = aregdate;
		this.aupdate = aupdate;
		this.mnum = mnum;
		this.cgnum = cgnum;
		this.cgname = cgname;
		this.mid = mid;
		this.groupsize = groupsize;
		this.pagesize = pagesize;
		this.curpage = curpage;
		this.totalcount = totalcount;
		this.pageno = pageno;
		this.searchTerm = searchTerm;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.bidhighprice = bidhighprice;
	}

	public String getAnum() {
		return anum;
	}

	public void setAnum(String anum) {
		this.anum = anum;
	}

	public String getAsort() {
		return asort;
	}

	public void setAsort(String asort) {
		this.asort = asort;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAloc() {
		return aloc;
	}

	public void setAloc(String aloc) {
		this.aloc = aloc;
	}

	public String getAphoto() {
		return aphoto;
	}

	public void setAphoto(String aphoto) {
		this.aphoto = aphoto;
	}

	public String getArephoto() {
		return arephoto;
	}

	public void setArephoto(String arephoto) {
		this.arephoto = arephoto;
	}

	public String getApricemin() {
		return apricemin;
	}

	public void setApricemin(String apricemin) {
		this.apricemin = apricemin;
	}

	public String getAendtime() {
		return aendtime;
	}

	public void setAendtime(String aendtime) {
		this.aendtime = aendtime;
	}

	public String getAcontents() {
		return acontents;
	}

	public void setAcontents(String acontents) {
		this.acontents = acontents;
	}

	public String getAstatus() {
		return astatus;
	}

	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}

	public String getAdelyn() {
		return adelyn;
	}

	public void setAdelyn(String adelyn) {
		this.adelyn = adelyn;
	}

	public String getAregdate() {
		return aregdate;
	}

	public void setAregdate(String aregdate) {
		this.aregdate = aregdate;
	}

	public String getAupdate() {
		return aupdate;
	}

	public void setAupdate(String aupdate) {
		this.aupdate = aupdate;
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

	public String getPageno() {
		return pageno;
	}

	public void setPageno(String pageno) {
		this.pageno = pageno;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
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

	public String getBidhighprice() {
		return bidhighprice;
	}

	public void setBidhighprice(String bidhighprice) {
		this.bidhighprice = bidhighprice;
	}
	
	
}
