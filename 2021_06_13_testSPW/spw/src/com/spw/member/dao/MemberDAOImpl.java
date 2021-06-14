package com.spw.member.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.member.vo.MemberVO;

public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {
	Logger log = Logger.getLogger(MemberDAOImpl.class);
	//패키지 경로는 dao에 경로를 적어준다.
	private final String PACKAGE_PATH = "com.spw.member.dao.MemberDAO.";

	
	@Override
	public MemberVO memLogin(MemberVO memberVO) {
		MemberVO mvo =  (MemberVO) getSqlSession().selectList(PACKAGE_PATH+"memLogin");
		log.info(mvo);
		return mvo;
	}
	
	
	@Override
	public List<MemberVO> memSelectAll(MemberVO memberVO) {
		List<MemberVO> list = getSqlSession().selectList(PACKAGE_PATH+"memSelectAll");
		return list;
	}

	@Override
	public int memInsert(MemberVO memberVO) {
		int result;
		result = getSqlSession().insert(PACKAGE_PATH+"memInsert");
		//memInsert는 DAOImp에서 메서드 이름과 같아야하고 mapper.xml에서 이름과도 같아야한다.
		log.info(result);
		return result;
	}

	@Override
	public MemberVO memIdfind(MemberVO memberVO) {
		MemberVO mvo;
		mvo = getSqlSession().selectOne(PACKAGE_PATH+"memIdfind");
		return mvo;
	}

	@Override
	public MemberVO memPwfind(MemberVO memberVO) {
		MemberVO result;
		result = getSqlSession().selectOne(PACKAGE_PATH+"memPwfind");
		return result;
	}

	@Override
	public int idchk(MemberVO memberVO) {
		int result;
		result = getSqlSession().selectOne(PACKAGE_PATH+"idchk");
		
		return result;
	}


	@Override
	public int adminDel(MemberVO memberVO) {
		int result;
		result = getSqlSession().update(PACKAGE_PATH+"adminDel");
		return result;
	}


	@Override
	public int naverInsert(MemberVO memberVO) {
		int result;
		result=getSqlSession().insert(PACKAGE_PATH+"naverInsert");
		return result;
	}


	@Override
	public MemberVO naverLogin(MemberVO memberVO) {
		MemberVO result;
		result=getSqlSession().selectOne(PACKAGE_PATH+"naverLogin");
		return result;
	}
	
	@Override
	public MemberVO naverSelect(MemberVO memberVO) {
		MemberVO result;
		result=getSqlSession().selectOne(PACKAGE_PATH+"naverSelect");
		return result;
	}
	
	
		
}
