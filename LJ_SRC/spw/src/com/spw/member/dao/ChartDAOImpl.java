package com.spw.member.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spw.member.vo.ChartVO;

public class ChartDAOImpl extends SqlSessionDaoSupport implements ChartDAO{
	private final String PACKAGE_PATH = "com.spw.member.dao.ChartDAO.";
	//dao 매개 변수로 받는 값은 mybatise config.xml 에 세팅된 값이고
	//mapper.xml에서 parameterType 으로 설정한 값으로 맞춰야 한다.
	Logger log = Logger.getLogger(ChartDAOImpl.class);
	
	
	@Override
	public ChartVO cntAllData(ChartVO chartVO) {
		
		ChartVO cvo = (ChartVO)getSqlSession().selectOne(PACKAGE_PATH+"cntAll");
		log.info(cvo);
		
		return cvo;
	}

	@Override
	public ChartVO cntSaja(ChartVO chartVO) {
		ChartVO cvo = (ChartVO)getSqlSession().selectOne(PACKAGE_PATH+"cntSaja");
//		Map<String, String> map = getSqlSession().selectMap(PACKAGE_PATH+"cntSaja", ChartVO);
//		List<ChartVO> list = getSqlSession().selectList(PACKAGE_PATH+"cntSaja");
//		ChartVO cvo=list.get(0);
		
		return cvo;
	}

	@Override
	public ChartVO cntPanda(ChartVO chartVO) {
		ChartVO cvo = (ChartVO)getSqlSession().selectOne(PACKAGE_PATH+"cntPanda");
		return cvo;
	}

	@Override
	public ChartVO cntAuct(ChartVO chartVO) {
		ChartVO cvo = (ChartVO)getSqlSession().selectOne(PACKAGE_PATH+"cntAuct");
		return cvo;
	}

	@Override
	public ChartVO cntAll(ChartVO chartVO) {
		ChartVO cvo = getSqlSession().selectOne(PACKAGE_PATH+"cntAll");
		return cvo;
	}

}
