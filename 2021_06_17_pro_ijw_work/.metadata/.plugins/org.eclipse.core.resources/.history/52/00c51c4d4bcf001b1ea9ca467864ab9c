package com.ijw.deal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ijw.deal.service.DealService;
import com.ijw.deal.vo.DealVO;
import com.ijw.general.vo.GeneralVO;
import com.ijw.notice.service.NoticeService;
import com.ijw.notice.vo.NoticeVO;

@Controller
public class DealController {
	
	// log.
	private Logger log = Logger.getLogger(DealController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private DealService dealService;
	// 嫄곕옒�떊泥� . ========================================
	@RequestMapping("dealPop")
	public ModelAndView dealPop(@ModelAttribute DealVO dvo) {
		log.info("GeneralController dealPop �떎�뻾 : ");
		log.info("dvo.getDnum() : "+dvo.getDnum());
		log.info("dvo.getDcontact() : "+dvo.getDcontact());
		log.info("dvo.getDdate() : "+dvo.getDdate());
		log.info("dvo.getMnum() : "+dvo.getMnum()); 
		log.info("dvo.getGnum() : "+dvo.getGnum());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("deal/dealPop");
		mav.addObject("dvo",dvo);
		log.info("GeneralController dealPop �걹 : ");
		return mav;
	}
	
	// 嫄곕옒�떊泥� . ========================================
	@RequestMapping("dealInsert")
	public ModelAndView dealInsert(@ModelAttribute GeneralVO gvo, HttpServletRequest req) {
		log.info("GeneralController dealInsert �떎�뻾 : ");
		
		// �꽆寃⑥� �뜲�씠�꽣.
		String phone0 = req.getParameter("phone0");
		String phone1 = req.getParameter("phone1");
		String phone2 = req.getParameter("phone2");
		
		String dcontact = phone0+"-"+phone1+"-"+phone2;  
		
		// 濡쒓렇�씤�븳 �쉶�썝踰덊샇.
		HttpSession hs = req.getSession();
		String mnum = (String)hs.getAttribute("mnum");
		// �궗�옄�뙋�떎 湲��쓽 湲�踰덊샇.
//		String gnum = req.getParameter("gnum");
		String gnum = gvo.getGnum();
		// �궗�옄�뙋�떎 湲��쓣 �삱由� �쉶�썝踰덊샇.
//		String gmnum = req.getParameter("mnum");
		String gmnum = gvo.getMnum();
		
		// 嫄곕옒�떊泥�.
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
			dealStr = "嫄곕옒�떊泥� �꽦怨�";
		}else {
			dealStr = "嫄곕옒�떊泥� �떎�뙣";
		}
		// �븣由�.
		NoticeVO nvo = new NoticeVO();
		nvo.setNmnum(mnum);
		nvo.setNsort("1");
		nvo.setNinfo(dcontact);
		nvo.setNurl("/ijw/generalDetailForm.ijw?gnum="+gnum);
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
			noticeStr = "�븣由� �꽦怨�";
		}else {
			noticeStr = "�븣由� �떎�뙣";
		}
		ModelAndView mav = new ModelAndView();
		if(dealStr!=null&&noticeStr!=null) {
			mav.setViewName("deal/dealOK");
			mav.addObject("gnum",gnum);
			mav.addObject("noticeStr",noticeStr);
			mav.addObject("dealStr", dealStr);
		}
		log.info("GeneralController dealInsert �걹 : ");
		return mav;
	}
}
