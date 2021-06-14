package com.spw.member.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.member.dao.MemberDAO;
import com.spw.member.vo.MemberVO;
import com.spw.mypage.dao.MypageMapper;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{
Logger log = Logger.getLogger(MemberService.class);
	//DAO의존성 주입해서 여기서 사용가능 하게 하였다.
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MypageMapper mypageMapper;
	
	@Override
	public MemberVO memLogin(MemberVO memberVO) {
		MemberVO mvo = memberDAO.memLogin(memberVO);
		log.info(mvo);
		return mvo;
	}

	@Override
	public List<MemberVO> memSelectAll(MemberVO memberVO) {
		List<MemberVO> list = memberDAO.memSelectAll(memberVO);
		return list;
	}

	@Override
	public int memInsert(MemberVO memberVO) {
		int result=0;
		result = memberDAO.memInsert(memberVO);
		log.info(result);
		return result;
	}

	@Override
	public MemberVO memIdfind(MemberVO memberVO) {
		MemberVO result;
		result = memberDAO.memIdfind(memberVO);
		return result;
	}

	@Override
	public MemberVO memPwfind(MemberVO memberVO) {
		MemberVO result;
		result = memberDAO.memPwfind(memberVO);
		return result;
	}

	@Override
	public int idchk(MemberVO memberVO) {
		int result;
		result =memberDAO.idchk(memberVO);
		return result;
	}

	@Override
	public int adminDel(MemberVO memberVO) {
		int result=0;
		// 삭제할려는 해당 회원번호를 가져와서 
		MemberVO _mvo = mypageMapper.myInfo(memberVO.getMnum());
		// 해당 번호의 vo정보를 히스토리 테이블에 인서트.
		int iCnt=0;
		try {
			iCnt = mypageMapper.hmemInsert(_mvo);
			if(iCnt>0) {
				result = memberDAO.adminDel(memberVO);
			}
		}catch(Exception e) {
			log.info("adminDel 에러 : ");
		}
		return result;
	}

	@Override
	public int naverInsert(MemberVO memberVO) {
		int result;
		result =memberDAO.naverInsert(memberVO);
		return result;
	}

	@Override
	public MemberVO naverLogin(MemberVO memberVO) {
		MemberVO result;
		result=memberDAO.naverLogin(memberVO);
		return result;
	}

	@Override
	public MemberVO naverSelect(MemberVO memberVO) {
		MemberVO result;
		result=memberDAO.naverLogin(memberVO);
		return result;
		
	}
}
