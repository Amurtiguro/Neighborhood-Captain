package com.ijw.mypage.dao;

import java.util.List;

import com.ijw.auction.vo.AuctionVO;
import com.ijw.general.vo.GeneralVO;
import com.ijw.member.vo.MemberVO;
import com.ijw.mypage.vo.MyPickVO;
import com.ijw.notice.vo.NoticeVO;

/**
 * 클래스
 * 설명
 * : Mypage 매퍼 인터페이스.
 */
public interface MypageMapper {
	
	// 로그인 회원 조회 ========================================
	public MemberVO myInfo(String mnum);
	
	// 로그인 회원 수정 ========================================
	public int myInfoUpdate(MemberVO mvo);
	
	// 회원 히스토리 테이블에 추가. ===================================
	public int hmemInsert(MemberVO mvo);
	
	// 로그인 회원 탈퇴 ========================================
	public int myInfoDelete(MemberVO mvo);
	
	// 경매목록 조회. ========================================
	public List<AuctionVO> myAuctionSALL(AuctionVO mavo);
	
	// 경매 상세 페이지 조회. ========================================
	public List<AuctionVO> selectAuction(AuctionVO mavo);
	
	// 경매 목록 삭제. ========================================
	public int myAuctionDel(AuctionVO mavo);
	
	// 구매, 판매 목록 조회. ========================================
	public List<GeneralVO> myGeneralSALL(GeneralVO mgvo);
	
	// 구매, 판매 목록 삭제. ========================================
	public int myGeneralDel(GeneralVO mgvo);

	// 알림목록 조회. ========================================
	public List<NoticeVO> noticeSALL(NoticeVO mnvo);
	
	// 찜하기목록 조회. ========================================
	public List<MyPickVO> myPickSALL(MyPickVO mpvo);
	
	// 찜하기목록 추가. ========================================
	public int pickInsert(MyPickVO mpno);
	
	// 찜하기목록 삭제. ========================================
	public int myPickDel(MyPickVO mpno);
	
	// 찜하기에서 상세페이지 조회. ========================================	
	public List<GeneralVO> selectGeneral(GeneralVO mgvo);
	
}
