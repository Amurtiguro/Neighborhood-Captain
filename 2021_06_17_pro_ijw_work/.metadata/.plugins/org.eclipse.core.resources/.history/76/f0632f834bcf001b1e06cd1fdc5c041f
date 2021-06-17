package com.ijw.mypage.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ijw.auction.vo.AuctionVO;
import com.ijw.general.vo.GeneralVO;
import com.ijw.member.vo.MemberVO;
import com.ijw.mypage.vo.MyPickVO;
import com.ijw.notice.vo.NoticeVO;


/**
 * 클래스
 * 설명
 * : Mypage 매퍼.
 
 */
public class MypageMapperImpl extends SqlSessionDaoSupport implements MypageMapper {

	
	
	// 로그인 회원 조회 ========================================
	@Override
	public MemberVO myInfo(String mnum) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("myInfo");
	}
	
	
	// 로그인 회원 수정 ========================================
	@Override
	public int myInfoUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("myInfoUpdate");
	}
	
	
	// 회원 히스토리 테이블에 추가. ===================================
	@Override
	public int hmemInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().insert("hmemInsert");
	}
	
	
	// 로그인 회원 탈퇴 ========================================
	@Override
	public int myInfoDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().delete("myInfoDelete");
	}

	
	// 경매목록 조회. ========================================
	@Override
	public List<AuctionVO> myAuctionSALL(AuctionVO mavo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("myAuctionSALL");
	}


	// 경매 상세페이지 조회. ========================================
	@Override
	public List<AuctionVO> selectAuction(AuctionVO mavo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectAuction");
	}
	
	
	// 경매 목록 삭제. ========================================
	@Override
	public int myAuctionDel(AuctionVO mavo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("myAuctionDel");
	}
	
	
	// 구매, 판매 목록 조회. ========================================
	@Override
	public List<GeneralVO> myGeneralSALL(GeneralVO mgvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("myGeneralSALL");
	}

	
	// 구매목록 삭제. ========================================
	@Override
	public int myGeneralDel(GeneralVO mgvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("myGeneralDel");
	}	
	
	// 알림목록 조회. ========================================
	@Override
	public List<NoticeVO> noticeSALL(NoticeVO mnvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("noticeSALL");
	}

	// 찜하기목록 조회. ========================================
	@Override
	public List<MyPickVO> myPickSALL(MyPickVO mpvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("myPickSALL");
	}

	// 찜하기목록 추가. ========================================
	@Override
	public int pickInsert(MyPickVO mpno) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().insert("pickInsert");
	}

	// 찜하기목록 삭제. ========================================
	@Override
	public int myPickDel(MyPickVO mpno) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().update("myPickDel");
	}

	// 찜하기에서 상세페이지 조회. ========================================
	@Override
	public List<GeneralVO> selectGeneral(GeneralVO mgvo) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectGeneral");
	}

}
