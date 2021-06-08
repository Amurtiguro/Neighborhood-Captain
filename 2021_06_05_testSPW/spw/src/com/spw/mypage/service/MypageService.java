package com.spw.mypage.service;

import java.util.List;

import com.spw.auction.vo.AuctionVO;
import com.spw.general.vo.GeneralVO;
import com.spw.member.vo.MemberVO;
import com.spw.mypage.vo.MyPickVO;
import com.spw.notice.vo.NoticeVO;

/**
 * 클래스
 * 설명
 * : MypageService 인터페이스.
 * 날짜 : 2020.07.31(금)
 * 작성자 : 장효제.
 */
public interface MypageService {
	// 로그인 회원 조회 ========================================
	public MemberVO myInfo(String mnum);
	
	// 로그인 회원 수정 ========================================
	public int myInfoUpdate(MemberVO mvo);
	
	// 로그인 회원 탈퇴 ========================================
	public int myInfoDelete(MemberVO mvo);
	
	// 경매목록 조회. ========================================
	public List<AuctionVO> myAuctionSALL(AuctionVO mavo);
	
	// 경매 상세페이지 조회. ========================================
	public List<AuctionVO> selectAuction(AuctionVO mavo);
	
	// 경매 목록 삭제. ========================================
	public int myAuctionDel(AuctionVO mavo);
	
	// 사자, 판다 목록 조회. ========================================
	public List<GeneralVO> myGeneralSALL(GeneralVO mgvo);
	
	// 사자, 판다 목록 삭제. ========================================
	public int myGeneralDel(GeneralVO mgvo);
	
	// 알림목록 조회. ========================================
	public List<NoticeVO> noticeSALL(NoticeVO mnvo);
	
	// 찜하기 목록 조회. ========================================
	public List<MyPickVO> myPickSALL(MyPickVO mpvo);
	
	// 찜하기 목록 추가. ========================================
	public int pickInsert(MyPickVO mpvo);
	
	// 찜하기 목록 삭제. ========================================
	public int myPickDel(MyPickVO mpvo);
	
	// 찜하기에서 상세페이지 조회. ========================================	
	public List<GeneralVO> selectGeneral(GeneralVO mgvo);
}
