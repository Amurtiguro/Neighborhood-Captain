package com.spw.member.service;

import java.util.List;

import com.spw.member.vo.ChartVO;

public interface ChartService {
	public ChartVO cntAllData(ChartVO chartVO);
	public ChartVO cntSaja(ChartVO chartVO);
	public ChartVO cntPanda(ChartVO chartVO);
	public ChartVO cntAuct(ChartVO chartVO);
	public ChartVO cntAll(ChartVO chartVO);
}
