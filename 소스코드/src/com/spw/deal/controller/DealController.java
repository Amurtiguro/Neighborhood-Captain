package com.spw.deal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spw.deal.service.DealService;
import com.spw.deal.vo.DealVO;
import com.spw.general.vo.GeneralVO;
import com.spw.notice.service.NoticeService;
import com.spw.notice.vo.NoticeVO;

@Controller
public class DealController {
	
	// log.
	private Logger log = Logger.getLogger(DealController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private DealService dealService;
	// 거래신청 . ========================================
	@RequestMapping("dealPop")
	public ModelAndView dealPop(@ModelAttribute DealVO dvo) {
		log.info("GeneralController dealPop 실행 : ");
		log.info("dvo.getDnum() : "+dvo.getDnum());
		log.info("dvo.getDcontact() : "+dvo.getDcontact());
		log.info("dvo.getDdate() : "+dvo.getDdate());
		log.info("dvo.getMnum() : "+dvo.getMnum()); 
		log.info("dvo.getGnum() : "+dvo.getGnum());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deal/dealPop");
		mav.addObject("dvo",dvo);
		log.info("GeneralController dealPop 끝 : ");
		return mav;
	}
	
	// 거래신청 . ========================================
	@RequestMapping("dealInsert")
	public ModelAndView dealInsert(@ModelAttribute GeneralVO gvo, HttpServletRequest req) {
		log.info("GeneralController dealInsert 실행 : ");
		
		// 넘겨준 데이터.
		String phone0 = req.getParameter("phone0");
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		
		String dcontact = phone0+"-"+phone1+"-"+phone2;  
		
		// 로그인한 회원번호.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// 사자판다 글의 글번호.
//		String gnum = req.getParameter("gnum");
		String gnum = gvo.getGnum();
		// 사자판다 글을 올린 회원번호.
//		String gmnum = req.getParameter("mnum");
		String gmnum = gvo.getMnum();
		
		// 거래신청.
		DealVO dvo = new DealVO();
		dvo.setDcontact(dcontact);
		dvo.setMnum(mnum);
		dvo.setGnum(gnum);
		int diCnt = dealService.dealInsert(dvo);
		
		log.info("DealVO dvo : ");
		log.info("dvo.getDnum() : "+dvo.getDnum());
		log.info("dvo.getDcontact() : "+dvo.getDcontact());
		log.info("dvo.getDdate() : "+dvo.getDdate());
		log.info("dvo.getMnum() : "+dvo.getMnum());
		log.info("dvo.getGnum() : "+dvo.getGnum());
		
		log.info("dealInsert diCnt : "+diCnt);
		String dealStr=null;
		
		if(diCnt>0) {
			dealStr = "거래신청 성공";
		}else {
			dealStr = "거래신청 실패";
		}
		// 알림.
		NoticeVO nvo = new NoticeVO();
		nvo.setNmnum(mnum);
		nvo.setNsort("1");
		nvo.setNinfo(dcontact);
		nvo.setNurl("/spw/generalDetailForm.spw?gnum="+gnum);
		nvo.setMnum(gmnum);
		int niCnt = noticeService.noticeInsert(nvo);
		
		log.info("NoticeVO nvo : ");
		log.info("nvo.getNnum() : "+nvo.getNnum());
		log.info("nvo.getNmnum() : "+nvo.getNmnum());
		log.info("nvo.getNsort() : "+nvo.getNsort());
		log.info("nvo.getNinfo() : "+nvo.getNinfo());
		log.info("nvo.getNurl() : "+nvo.getNurl());
		log.info("nvo.getNdelyn() : "+nvo.getNdelyn());
		log.info("nvo.getNsenddate() : "+nvo.getNsenddate());
		log.info("nvo.getMnum() : "+nvo.getMnum());
		
		log.info("noticeInsert niCnt : "+niCnt);
		String noticeStr=null;
		
		if(niCnt>0) {
			noticeStr = "알림 성공";
		}else {
			noticeStr = "알림 실패";
		}
		ModelAndView mav = new ModelAndView();
		if(dealStr!=null&&noticeStr!=null) {
			mav.setViewName("deal/dealOK");
			mav.addObject("gnum",gnum);
			mav.addObject("noticeStr",noticeStr);
			mav.addObject("dealStr", dealStr);
		}
		log.info("GeneralController dealInsert 끝 : ");
		return mav;
	}
}
