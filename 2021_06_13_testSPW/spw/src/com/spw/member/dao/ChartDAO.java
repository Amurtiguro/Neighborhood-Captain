package com.spw.member.dao;

import java.util.List;

import com.spw.member.vo.ChartVO;

public interface ChartDAO {
	
	public ChartVO cntAllData(ChartVO chartVO);
	public ChartVO cntSaja(ChartVO chartVO);
	public ChartVO cntPanda(ChartVO chartVO);
	public ChartVO cntAuct(ChartVO chartVO);
	public ChartVO cntAll(ChartVO chartVO);
}
