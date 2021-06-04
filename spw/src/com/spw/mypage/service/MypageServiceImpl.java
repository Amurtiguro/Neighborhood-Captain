package com.spw.mypage.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.spw.auction.vo.AuctionVO;
import com.spw.general.vo.GeneralVO;
import com.spw.member.vo.MemberVO;
import com.spw.mypage.dao.MypageMapper;
import com.spw.mypage.vo.MyPickVO;
import com.spw.notice.vo.NoticeVO;


/**
 * 클래스
 * 설명
 * : 
 * 날짜 :
 * 작성자 :
 */
@Service
@Transactional
public class MypageServiceImpl implements MypageService{
	
	// 로그. ========================================
	private Logger log = Logger.getLogger(MypageServiceImpl.class);
	
	// Mapper 의존주입. ========================================
	@Autowired
	private MypageMapper mypageMapper;

	
	// 로그인 회원 조회 ========================================
	@Override
	public MemberVO myInfo(String mnum) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myInfo 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mnum);
		MemberVO mvo = mypageMapper.myInfo(mnum);
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디 : "+mvo.getMid());
		log.info("MypageServiceImpl myInfo 종료 : ");
		return mvo;
	}

	
	// 로그인 회원 수정 ========================================
	@Override
	public int myInfoUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myInfoUpdate 실행 : ");
		log.info("수정 값 : ");
		log.info("번호 : "+mvo.getMnum());
		log.info("아이디 : "+mvo.getMid());
		log.info("비밀번호 : "+mvo.getMpw());
		log.info("이름 : "+mvo.getMname());
		log.info("휴대폰 번호 : "+mvo.getMphone());
		log.info("이메일 : "+mvo.getMemail());
		log.info("우편번호 : "+mvo.getMaddr0());
		log.info("주소 : "+mvo.getMaddr1());
		log.info("상세주소 : "+mvo.getMaddr2());
		log.info("삭제여부 : "+mvo.getMdelyn());
		log.info("회원등록일 : "+mvo.getMregdate());
		log.info("등록일 : "+mvo.getMindate());
		log.info("수정일 : "+mvo.getMupdate());
		log.info("회원 히스토리 번호 : "+mvo.getHnum());
		int iCnt=0;
		int uCnt=0;
		// 회원번호를 통해 그전 데이터를 가져옴.
		// 가져온 데이터를 히스토리 테이블에 인서트.
		MemberVO _mvo = mypageMapper.myInfo(mvo.getMnum());
		log.info("회원번호로 쿼리갔다온 기본 값 : ");
		log.info("번호 : "+_mvo.getMnum());
		log.info("아이디 : "+_mvo.getMid());
		log.info("비밀번호 : "+_mvo.getMpw());
		log.info("이름 : "+_mvo.getMname());
		log.info("휴대폰 번호 : "+_mvo.getMphone());
		log.info("이메일 : "+_mvo.getMemail());
		log.info("우편번호 : "+_mvo.getMaddr0());
		log.info("주소 : "+_mvo.getMaddr1());
		log.info("상세주소 : "+_mvo.getMaddr2());
		log.info("삭제여부 : "+_mvo.getMdelyn());
		log.info("회원등록일 : "+_mvo.getMregdate());
		log.info("등록일 : "+_mvo.getMindate());
		log.info("수정일 : "+_mvo.getMupdate());
		log.info("회원 히스토리 번호 : "+_mvo.getHnum());
		
		
		iCnt = mypageMapper.hmemInsert(_mvo);
		log.info("회원 히스토리 테이블 추가 : "+iCnt);
		if(iCnt>0) {	
			// 수정.
			uCnt = mypageMapper.myInfoUpdate(mvo); 	
 			log.info("회원 테이블 수정 : "+uCnt);
		}		
		
		log.info("MypageServiceImpl myInfoUpdate 종료: ");
		return uCnt;
	}
	
	// 로그인 회원 탈퇴 ========================================
	@Override
	public int myInfoDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myInfoDelete 실행 : ");
		log.info("번호 : "+mvo.getMnum());
		log.info("아이디 : "+mvo.getMid());
		log.info("비밀번호 : "+mvo.getMpw());
		log.info("이름 : "+mvo.getMname());
		log.info("휴대폰 번호 : "+mvo.getMphone());
		log.info("이메일 : "+mvo.getMemail());
		log.info("우편번호 : "+mvo.getMaddr0());
		log.info("주소 : "+mvo.getMaddr1());
		log.info("상세주소 : "+mvo.getMaddr2());
		log.info("삭제여부 : "+mvo.getMdelyn());
		log.info("회원등록일 : "+mvo.getMregdate());
		log.info("등록일 : "+mvo.getMindate());
		log.info("수정일 : "+mvo.getMupdate());
		log.info("회원 히스토리 번호 : "+mvo.getHnum());
		int iCnt=0;
		int dCnt=0;

		// 히스토리 테이블에 인서트.
		MemberVO _mvo = mypageMapper.myInfo(mvo.getMnum());
		iCnt = mypageMapper.hmemInsert(_mvo);
		log.info("회원 히스토리 테이블 추가 : "+iCnt);
		if(iCnt>0) {	
			// 삭제.
			dCnt = mypageMapper.myInfoDelete(mvo);
			log.info("회원 테이블 삭제 : "+dCnt);
		}

		log.info("MypageServiceImpl myInfoDelete 종료 : ");
		return dCnt;
	}

	
	// 경매목록 조회. ========================================
	@Override
	public List<AuctionVO> myAuctionSALL(AuctionVO mavo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myAuctionSALL 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mavo.getMnum());
		List<AuctionVO> list = mypageMapper.myAuctionSALL(mavo);
		log.info("MypageServiceImpl list : "+list);
		log.info("MypageServiceImpl myAuctionSALL 종료: ");
		return list;
	}

	
	// 경매 상세페이지 조회. ========================================
	@Override
	public List<AuctionVO> selectAuction(AuctionVO mavo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl selectAuction 실행 : ");
		log.info("MypageServiceImpl 선택한 글번호 : "+mavo.getAnum());
		List<AuctionVO> list = mypageMapper.selectAuction(mavo);
		log.info("MypageServiceImpl list : "+list);
		log.info("MypageServiceImpl selectAuction 종료: ");
		return list;
	}
	
	
	// 경매 목록 삭제. ========================================
	@Override
	public int myAuctionDel(AuctionVO mavo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myAuctionDel 실행 : ");
		log.info("MypageServiceImpl 선택한 글번호 : "+mavo.getAnum());
		int dCnt = mypageMapper.myAuctionDel(mavo);
		log.info("MypageServiceImpl dCnt : "+dCnt);
		log.info("MypageServiceImpl myAuctionDel 종료: ");
		return dCnt;
	}
	
	
	// 사자, 판다 목록 조회. ========================================
	@Override
	public List<GeneralVO> myGeneralSALL(GeneralVO mgvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myGeneralSALL 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mgvo.getMnum());
		log.info("MypageServiceImpl myInfo 현재 페이지 구분 : "+mgvo.getGsort());
		List<GeneralVO> list = mypageMapper.myGeneralSALL(mgvo);
		log.info("MypageServiceImpl list : "+list);
		log.info("MypageServiceImpl myGeneralSALL 종료: ");
		return list;
	}
	
	
	// 사자목록 삭제. ========================================
	@Override
	public int myGeneralDel(GeneralVO mgvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myGeneralDel 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mgvo.getMnum());
		int dCnt = mypageMapper.myGeneralDel(mgvo);
		log.info("MypageServiceImpl dCnt : "+dCnt);
		log.info("MypageServiceImpl myGeneralDel 종료: ");
		return dCnt;
	}


	
	// 알림목록 조회. ========================================
	@Override
	public List<NoticeVO> noticeSALL(NoticeVO mnvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl noticeSALL 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mnvo.getMnum());
		List<NoticeVO> list = mypageMapper.noticeSALL(mnvo);
		log.info("MypageServiceImpl list : "+list);
		log.info("MypageServiceImpl noticeSALL 종료: ");
		return list;
	}
	

	// 찜하기 목록 조회. ========================================
	@Override
	public List<MyPickVO> myPickSALL(MyPickVO mpvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myPickSALL 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mpvo.getMnum());
		List<MyPickVO> list = mypageMapper.myPickSALL(mpvo);
		log.info("MypageServiceImpl list : "+list);
		log.info("MypageServiceImpl myPickSALL 종료: ");
		return list;
	}

	// 찜하기 목록 추가. ========================================
	@Override
	public int pickInsert(MyPickVO mpvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl pickInsert 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mpvo.getMnum());
		int iCnt = mypageMapper.pickInsert(mpvo);
		log.info("MypageServiceImpl iCnt : "+iCnt);
		log.info("MypageServiceImpl pickInsert 종료: ");
		return iCnt;
	}

	// 찜하기 목록 삭제. ========================================
	@Override
	public int myPickDel(MyPickVO mpvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl myPickDel 실행 : ");
		log.info("MypageServiceImpl myInfo 현재 로그인한 아이디의 회원번호 : "+mpvo.getMnum());
		int uCnt = mypageMapper.myPickDel(mpvo);
		log.info("MypageServiceImpl iCnt : "+uCnt);
		log.info("MypageServiceImpl myPickDel 종료: ");
		return uCnt;
	}


	// 찜하기에서 상세페이지 조회. ========================================
	@Override
	public List<GeneralVO> selectGeneral(GeneralVO mgvo) {
		// TODO Auto-generated method stub
		log.info("MypageServiceImpl selectGeneral 실행 : ");
		log.info("MypageServiceImpl 선택한 글번호 : "+mgvo.getGnum());
		List<GeneralVO> list = mypageMapper.selectGeneral(mgvo);
		log.info("MypageServiceImpl list : "+list);
		log.info("MypageServiceImpl selectGeneral 종료 : ");
		return list;
	}
	
}
