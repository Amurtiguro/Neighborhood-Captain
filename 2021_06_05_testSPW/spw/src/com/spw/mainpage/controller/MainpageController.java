package com.spw.mainpage.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spw.auction.vo.AuctionVO;
import com.spw.general.vo.GeneralVO;
import com.spw.mainpage.service.MainpageService;

import oracle.net.aso.n;

@Controller
public class MainpageController {
	private static Logger log = Logger.getLogger(MainpageController.class);

	// 移댄뀒怨좊━ View媛� ���옣�맂 �뤃�뜑
	private static String VIEW_DIR = "main/";

	@Autowired
	private MainpageService mainpageService;

	/**
	 * 설명
	 * : 메인페이지를 출력
	 * 매개변수 : 없음
	 * 반환값 : ModelAndView
	 * 날짜 : 2021/06/05
	 * 작성자 : 이태형 오빠
	 */
	// /localohost:8088/spw/
	@RequestMapping("/index")
	public ModelAndView mainPage() {
		log.info("[ mainPage 시작 ]");

		// 사자 최근글
		List<GeneralVO> sajaList = mainpageService.selectNewSaja();
		
		// 판다 최근글
		List<GeneralVO> pandaList = mainpageService.selectNewPanda();

		// 경매 최근글
		List<AuctionVO> auctionList = mainpageService.selectNewAuction();

		// ModelAndView
		ModelAndView mav = new ModelAndView();

		mav.addObject("sajaList", sajaList);
		mav.addObject("pandaList", pandaList);
		mav.addObject("auctionList", auctionList);

		mav.setViewName(VIEW_DIR + "mainpage");

		log.info("[mainPage 종료] mav => " + mav);
		return mav;
	}
}
