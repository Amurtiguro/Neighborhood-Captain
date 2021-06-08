package com.spw.comment.vo;

/**
 * 클래스
 * 설명
 * : COMMENT_LIST 테이블의 VO
 * 날짜 : 2020/08/10
 * 작성자 : 최정규
 */
public class CommentVO {
	private String cnum;
	private String ccontents;
	private String cgroupnum;
	private String ctargetnum;
	private String cdelyn;
	private String cpnum;
	private String cindate;
	private String mnum;

	// 회원정보
	private String mname;
	private String mid;

	// 대댓글 타겟 회원 이름
	private String tarname;

	// 댓글 알림을 위한 회원 번호(알림용)
	// 해당댓글이 달린 상품 작성자의 회원번호
	// 대댓글이라면 상위댓글을 단 작성자의 회원번호
	private String pmnum;	// 상품
	private String cmnum;	// 상위 댓글

	// 페이징
	private String groupsize;	// 그룹 사이즈
	private String pagesize;	// 페이지 사이즈
	private String curpage;		// 페이지 번호
	private String totalcount;	// 총데이터 수

	//생성자
	public CommentVO() {
		
	}

	public CommentVO(String cnum
					,String ccontents
					,String cgroupnum
					,String ctargetnum
					,String cdelyn
					,String cpnum
					,String cindate
					,String mnum
					,String mname
					,String mid
					,String tarname
					,String pmnum
					,String cmnum
					,String groupsize	
					,String pagesize
					,String curpage
					,String totalcount) {
		this.cnum = cnum;
		this.ccontents = ccontents;
		this.cgroupnum = cgroupnum;
		this.ctargetnum = ctargetnum;
		this.cdelyn = cdelyn;
		this.cpnum = cpnum;
		this.cindate = cindate;
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.tarname = tarname;
		this.pmnum = pmnum;
		this.cmnum = cmnum;
		this.groupsize = groupsize;
		this.pagesize = pagesize;
		this.curpage = curpage;
		this.totalcount = totalcount;
	}

	// Getter / Setter
	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getCcontents() {
		return ccontents;
	}

	public void setCcontents(String ccontents) {
		this.ccontents = ccontents;
	}

	public String getCgroupnum() {
		return cgroupnum;
	}

	public void setCgroupnum(String cgroupnum) {
		this.cgroupnum = cgroupnum;
	}

	public String getCtargetnum() {
		return ctargetnum;
	}

	public void setCtargetnum(String ctargetnum) {
		this.ctargetnum = ctargetnum;
	}

	public String getCdelyn() {
		return cdelyn;
	}

	public void setCdelyn(String cdelyn) {
		this.cdelyn = cdelyn;
	}

	public String getCpnum() {
		return cpnum;
	}

	public void setCpnum(String cpnum) {
		this.cpnum = cpnum;
	}

	public String getCindate() {
		return cindate;
	}

	public void setCindate(String cindate) {
		this.cindate = cindate;
	}

	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getTarname() {
		return tarname;
	}

	public void setTarname(String tarname) {
		this.tarname = tarname;
	}

	public String getPmnum() {
		return pmnum;
	}

	public void setPmnum(String pmnum) {
		this.pmnum = pmnum;
	}

	public String getCmnum() {
		return cmnum;
	}

	public void setCmnum(String cmnum) {
		this.cmnum = cmnum;
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

}
