package com.ijw.deal.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ijw.deal.vo.DealVO;


public class DealDaoImpl extends SqlSessionDaoSupport implements DealDao {

	// 거래 신청. ===============================
	@Override
	public int dealInsert(DealVO dvo) {
		// TODO Auto-generated method stub
		return (int)getSqlSession().insert("dealInsert");
	}
}
