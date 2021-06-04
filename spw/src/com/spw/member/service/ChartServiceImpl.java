package com.spw.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spw.member.dao.ChartDAO;
import com.spw.member.vo.ChartVO;

@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	private ChartDAO chartDAO;

	@Override
	public ChartVO cntAllData(ChartVO chartVO) {
		ChartVO cvo = chartDAO.cntAllData(chartVO);
		System.out.println("service cvo :::"+cvo);
		return cvo;
	}

	@Override
	public ChartVO cntSaja(ChartVO chartVO) {
		ChartVO cvo = chartDAO.cntSaja(chartVO);
		return cvo;
	}

	@Override
	public ChartVO cntPanda(ChartVO chartVO) {
		ChartVO cvo = chartDAO.cntPanda(chartVO);
		return cvo;
	}

	@Override
	public ChartVO cntAuct(ChartVO chartVO) {
		ChartVO cvo = chartDAO.cntAuct(chartVO);
		return cvo;
	}

	@Override
	public ChartVO cntAll(ChartVO chartVO) {
		ChartVO  cvo= chartDAO.cntAll(chartVO);
		return cvo;
	}

}
