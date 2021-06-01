package com.spw.deal.dao;

import com.spw.deal.vo.DealVO;

public interface DealDao {

	// 거래 신청. ===============================
	public int dealInsert(DealVO dvo);
}
